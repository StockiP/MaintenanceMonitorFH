package org.Monitor;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/api/monitoring")
public class MaintenanceController {
    private static String status = "-";

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response getStatus(){
        Response.ResponseBuilder rb = Response.ok(status);
        return rb.header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Path("/{status}")
    @Produces(MediaType.TEXT_PLAIN)
    public String setStatus(@PathParam("status") String newStatus){
        if (newStatus == null || newStatus.isBlank()){
            return status;
        } else{
            status = newStatus;
            return newStatus;
        }
    }
}
