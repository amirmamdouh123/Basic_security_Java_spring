package com.example.demo.services;

import com.example.demo.base.BaseService;
import com.example.demo.entities.Role;
import com.example.demo.repos.RoleRepo;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class RoleService extends BaseService<Role, RoleRepo> {
    public RoleService(RoleRepo repo) {
        super(repo);
    }
    public Role getByName(String role) {
        return Optional.of(repo.getByName(role)).orElse(new Role(null,"newRole"));
    }

}
