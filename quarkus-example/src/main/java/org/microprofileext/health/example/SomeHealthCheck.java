package org.microprofileext.health.example;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;

import javax.enterprise.context.ApplicationScoped;
import java.util.Random;

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
