package org.microprofileext.health.example;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

/**
 * Checking some pretend stuff
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Readiness
@ApplicationScoped
public class SomeHealthCheck implements HealthCheck {
    Random r = new Random();
            
    @Override
    public HealthCheckResponse call() {
        
        boolean randomUpDown = r.nextBoolean();
        
        HealthCheckResponseBuilder responseBuilder = HealthCheckResponse.named("something random")
                .withData("some number", r.nextInt())
                .withData("some boolean", randomUpDown);

        return responseBuilder.status(randomUpDown).build();
        
    }
    
}
