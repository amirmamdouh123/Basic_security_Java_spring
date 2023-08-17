package com.example.demo.controllers;

import com.example.demo.base.BaseController;
import com.example.demo.entities.Role;
import com.example.demo.services.RoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("roles")
public class RoleController extends BaseController<Role, RoleService> {
    public RoleController(RoleService service) {
        super(service);
    }
}
