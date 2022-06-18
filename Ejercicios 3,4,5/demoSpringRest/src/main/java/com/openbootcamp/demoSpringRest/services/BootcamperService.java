package com.openbootcamp.demoSpringRest.services;

import com.openbootcamp.demoSpringRest.models.Bootcamper;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class BootcamperService {
    private List<Bootcamper> bootcampers = new ArrayList<>();
    
    public List<Bootcamper> getAll(){
        return this.bootcampers;
    }
    
    public Bootcamper getByName(String name){
        return bootcampers.stream().filter(x -> x.getNombre().equalsIgnoreCase(name))
                .findFirst().orElse(null);
        //get()
    }
    
    public void add(Bootcamper bootcamper){
        this.bootcampers.add(bootcamper);
    }
}
