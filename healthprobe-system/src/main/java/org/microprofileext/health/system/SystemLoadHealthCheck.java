package org.microprofileext.health.system;

import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Liveness;

/**
 * Checking average load usage against configured max load
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Liveness
@ApplicationScoped
public class SystemLoadHealthCheck implements HealthCheck {

    @Inject @ConfigProperty(name = "health.system.load.max", defaultValue = "0.7")
    double max;
    
    @Override
    public HealthCheckResponse call() {
        OperatingSystemMXBean operatingSystemMXBean = ManagementFactory.getOperatingSystemMXBean();

        String arch = operatingSystemMXBean.getArch();
        String name = operatingSystemMXBean.getName();
        String version = operatingSystemMXBean.getVersion();
        int availableProcessors = operatingSystemMXBean.getAvailableProcessors();

        double systemLoadAverage = operatingSystemMXBean.getSystemLoadAverage();
        double systemLoadAveragePerProcessors = systemLoadAverage / availableProcessors;
        
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("system-load")
                .withData("name", name)
                .withData("arch", arch)
                .withData("version", version)
                .withData("processors", availableProcessors)
                .withData("loadAverage", String.valueOf(systemLoadAverage))
                .withData("loadAverage per processor", String.valueOf(systemLoadAveragePerProcessors))
                .withData("loadAverage max", String.valueOf(max));

        if(systemLoadAverage>0){
            boolean status = systemLoadAveragePerProcessors < max;
            return responseBuilder.state(status).build();
        }else{
            // Load average not available
            return responseBuilder.up().build();
        }

    }
}
