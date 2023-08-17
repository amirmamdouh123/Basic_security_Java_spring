package com.example.demo.controllers;

import com.example.demo.base.BaseController;
import com.example.demo.entities.AppUser;
import com.example.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController extends BaseController<AppUser, UserService> {
    public UserController(UserService service) {
        super(service);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("getUser")
    public ResponseEntity<?> getAuthName() {
        Authentication auth =SecurityContextHolder.getContext().getAuthentication();
        return ResponseEntity.ok(((AppUser)auth.getPrincipal()).getUsername());
    }

    @PreAuthorize("hasRole('USER')")
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
}
