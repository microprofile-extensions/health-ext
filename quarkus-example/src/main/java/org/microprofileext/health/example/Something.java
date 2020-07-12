package org.microprofileext.health.example;


import java.util.Date;
import java.util.UUID;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Schema;

/**
 * Something POJO
 * @author Phillip Kruger (phillip.kruger@phillip-kruger.com)
 */
@Schema(name="Something", description="POJO that represents something.")
public class Something {
    
    @Schema(required = true, description = "Some id",type = SchemaType.STRING)
    private String id = UUID.randomUUID().toString();
    
    @Schema(required = true, description = "Some time")
    private Date date = new Date(); 
        
    @Schema(required = true, description = "Someone")
    private String name;
    
    public Something() {
    }
    
    public Something(String name){
        this.name = name;
    }

    public Something(String id, Date date, String name){
        this.id = id;
        this.date = date;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}