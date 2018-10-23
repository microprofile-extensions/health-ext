package org.microprofileext.health.example;

import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Something POJO
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Data @AllArgsConstructor @NoArgsConstructor
@Schema(name="Something", description="POJO that represents something.")
public class Something {
    
    @Schema(required = true, description = "Some id",type = SchemaType.STRING)
    private String id = UUID.randomUUID().toString();
    
    @Schema(required = true, description = "Some time")
    private Date date = new Date(); 
        
    @Schema(required = true, description = "Someone")
    private String name;
    
    public Something(String name){
        this.name = name;
    }
    
}