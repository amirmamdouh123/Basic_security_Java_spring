package com.example.demo.repos;

import com.example.demo.base.baseRepo;
import com.example.demo.entities.AppUser;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public interface UserRepo extends baseRepo<AppUser> {
    @Query("select e from AppUser e where e.username =:name")
    public AppUser getByName(String name);

}
