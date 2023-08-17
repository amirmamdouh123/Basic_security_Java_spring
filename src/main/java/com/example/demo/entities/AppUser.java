package com.example.demo.entities;

import com.example.demo.base.BaseEntity;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "SEC_USERS",schema = "HR")
@NoArgsConstructor
@Setter
public class AppUser extends BaseEntity implements UserDetails {

    public String username;

    public String password;

    @ManyToMany
    @JoinTable(schema = "HR",name="RELATION_USERS_ROLES",
            joinColumns =  @JoinColumn(name="USER_ID",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="ROLE_ID",referencedColumnName = "id"))
    public List<Role> roles;

    public AppUser(Long id, String username, String password, List<Role> roles) {
        super(id);
        this.username = username;
        this.password = password;
        this.roles =  roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
