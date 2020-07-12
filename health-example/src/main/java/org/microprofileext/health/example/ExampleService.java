package org.microprofileext.health.example;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@RequestScoped
@Path("/")
@Consumes(MediaType.APPLICATION_JSON) @Produces(MediaType.APPLICATION_JSON)
@Tag(name = "Example service",description = "Just some example")
public class ExampleService {
    
    @GET @Path("{name}")
    @Operation(description = "Getting something")
    @APIResponses({
            @APIResponse(responseCode = "200", description = "Successful, returning something", 
                    content = @Content(schema = @Schema(implementation = Something.class)))
    })
    public Response getSomething(
            @Parameter(name = "name", description = "Your name", 
                    required = true, allowEmptyValue = false, example = "John Smith") 
                    @PathParam("name") String name){
        
        return Response.ok(new Something(name)).build();
    }
}
