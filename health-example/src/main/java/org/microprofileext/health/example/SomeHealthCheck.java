package org.microprofileext.health.example;

import java.util.Random;
import javax.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

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

        return responseBuilder.state(randomUpDown).build();
        
    }
    
}
