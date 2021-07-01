package org.microprofileext.health.jvm;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

/**
 * Checking heap memory usage against available heap memory
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Liveness
@ApplicationScoped
public class HeapMemoryHealthCheck implements HealthCheck {

    @Inject @ConfigProperty(name = "health.jvm.heapmemory.maxpercentage", defaultValue = "0.9")
    double maxPercentage;
    
    @Override
    public HealthCheckResponse call() {
        MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
        long memUsed = memoryBean.getHeapMemoryUsage().getUsed();
        long memMax = memoryBean.getHeapMemoryUsage().getMax();

        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("heap-memory")
                .withData("used", memUsed)
                .withData("max", memMax)
                .withData("max %", String.valueOf(maxPercentage));

        if(memMax > 0){
            boolean status = (memUsed < memMax * maxPercentage);
            return responseBuilder.status(status).build();
        }else{
            // Max not available
            return responseBuilder.up().build();
        }

    }
}
