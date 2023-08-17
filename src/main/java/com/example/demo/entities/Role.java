package com.example.demo.entities;

import com.example.demo.base.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.Set;


@Entity
@Table(name="sec_roles", schema = "HR")
@Setter
@Getter
//@Builder
@JsonIgnoreProperties("users")
@NoArgsConstructor
public class Role extends BaseEntity implements GrantedAuthority {

    @Column(name="rolee")
    String role;

    @ManyToMany(mappedBy = "roles" ,cascade = CascadeType.ALL)
    Set<AppUser> users;
    public Role(Long id) {
        super(id);
    }

    public Role(Long id,String role) {
        super(id);
        this.role=role;

    }



//    public void addUser(AppUser user){
//        users.add(user);
//    }
//    public void removeUser(AppUser user){
//        users.remove(user);
//    }


    @Override
    public String toString() {
        return "id: "+getId() +" Name: "+ getRole();
    }

    @Override
    public String getAuthority() {
        return role;
    }
}