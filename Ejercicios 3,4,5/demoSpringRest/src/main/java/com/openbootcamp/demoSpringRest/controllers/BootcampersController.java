package com.openbootcamp.demoSpringRest.controllers;

import com.openbootcamp.demoSpringRest.models.Bootcamper;
import com.openbootcamp.demoSpringRest.services.BootcamperService;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.stereotype.Component;

@Component
@Path("/")
public class BootcampersController {
    private BootcamperService bootcamperservice;
    
    public BootcampersController(BootcamperService bootcamperservice){
        bootcamperservice.add(new Bootcamper("Oliver"));
        bootcamperservice.add(new Bootcamper("Michelle"));
        this.bootcamperservice = bootcamperservice;
    }
    
    @GET
    @Path("/bootcampers")
    @Produces("application/json")
    public List<Bootcamper> listarTodos(){
        return bootcamperservice.getAll();
    }
    
    @GET
    @Path("/bootcampers/{name}")
    @Produces("application/json")
    public Bootcamper listarUno(@PathParam("name") String name){
        return bootcamperservice.getByName(name);
    }
    
    @POST
    @Path("/bootcampers")
    @Produces("application/json")
    @Consumes("application/json")
    public Response insertarBootcamper(Bootcamper bootcamper){
        bootcamperservice.add(bootcamper);
        return Response.created(URI.create("/bootcampers/"+bootcamper.getNombre())).build();
    }
}
