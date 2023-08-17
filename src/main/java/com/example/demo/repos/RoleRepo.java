package com.example.demo.repos;

import com.example.demo.base.baseRepo;
import com.example.demo.entities.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepo extends baseRepo<Role> {
    @Query("select e from Role e where e.role =:name")
    public Role getByName(String name);


}
