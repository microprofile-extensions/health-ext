package org.microprofileext.health.example;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.health.Health;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

/**
 * Checking some pretend stuff
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Health
@ApplicationScoped
public class SomeHealthCheck implements HealthCheck {
    Random r = new Random();
            
    @Override
    public HealthCheckResponse call() {
        
        boolean randomUpDown = r.nextBoolean();
        
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("something random")
                .withData("some number", r.nextInt())
                .withData("some boolean", randomUpDown);

        return responseBuilder.state(randomUpDown).build();
        
    }
    
}
