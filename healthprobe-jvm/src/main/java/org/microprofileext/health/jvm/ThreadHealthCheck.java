package org.microprofileext.health.jvm;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

/**
 * Checking the number of threads
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Liveness
@ApplicationScoped
public class ThreadHealthCheck implements HealthCheck {
    @Inject @ConfigProperty(name = "health.jvm.threadcount.max", defaultValue = "-1") // default switched off
    long maxThreadCount;
    
    @Override
    public HealthCheckResponse call() {
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        
        int threadCount = threadMXBean.getThreadCount();
        int peakThreadCount = threadMXBean.getPeakThreadCount();
        int daemonThreadCount = threadMXBean.getDaemonThreadCount();
        long totalStartedThreadCount = threadMXBean.getTotalStartedThreadCount();
        
        long[] deadlockedThreads = threadMXBean.findDeadlockedThreads();
        long[] monitorDeadlockedThreads = threadMXBean.findMonitorDeadlockedThreads();
                
        int deadlockedThreadCount = getNumberOfThreads(deadlockedThreads);
        int monitorDeadlockedThreadCount = getNumberOfThreads(monitorDeadlockedThreads);
        
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("threads")
                .withData("thread count", threadCount)
                .withData("peak thread count", peakThreadCount)
                .withData("daemon thread count", daemonThreadCount)
                .withData("started thread count", totalStartedThreadCount)
                .withData("deadlocked thread count", deadlockedThreadCount)
                .withData("monitor deadlocked thread count", monitorDeadlockedThreadCount)
                .withData("max thread count", maxThreadCount);

        if(threadCount > 0 && maxThreadCount > 0){
            boolean status = threadCount < maxThreadCount;
            return responseBuilder.state(status).build();
        }else{
            // Thread count not available
            return responseBuilder.up().build();
        }

    }
    
    private int getNumberOfThreads(long[] ids){
        if(ids==null)return 0;
        return ids.length;
    }
}
