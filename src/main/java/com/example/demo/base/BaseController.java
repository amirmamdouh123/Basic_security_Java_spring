package com.example.demo.base;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor

public class BaseController<T extends BaseEntity,Service extends BaseService<T,?>> {

    @Autowired
    //@Qualifier("EmployeeService")
    protected Service service;


    @GetMapping
    public ResponseEntity<?> getAllEntitys(){
        try{
            return ResponseEntity.ok(service.getAllEntitys());
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }







    @GetMapping("{id}")
    public ResponseEntity<?> getEntityById(@PathVariable Long id){
        try{
            return ResponseEntity.ok(service.getObjectById(id));
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> createEntity(@RequestBody @Valid T object){
        try{
            service.createObject(object);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<?> updateEntity(@PathVariable Long id, @RequestBody T object){
        try{
            service.updateEntity(id, object);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteEntity(@PathVariable Long id){
        try{
            service.deleteEntity(id);
            return ResponseEntity.ok().build();
        }
        catch (Exception ex){
            ex.printStackTrace();
            return ResponseEntity.internalServerError().body(ex.getMessage());
        }
    }




}
