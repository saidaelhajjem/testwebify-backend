package com.example.demo.Entite;

import org.springframework.data.annotation.Id;

/**
 * Role
 */
public class Role {
    @Id

    private String id;
    private String roleName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Role(String roleName) {

        this.roleName = roleName;
    }

    public Role() {
    }

}