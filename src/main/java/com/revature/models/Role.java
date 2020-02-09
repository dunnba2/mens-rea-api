package com.revature.models;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "ROLES")
@SequenceGenerator(name = "role_gen", sequenceName = "role_seq", allocationSize = 1)
public class Role {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_gen")
    private int id;

    @Column(nullable = false, unique = true)
    private String role;

    public Role () {
        super();
    }

    public Role(String role) {
        this.role = role;
    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Role role1 = (Role) o;
        return id == role1.id &&
                Objects.equals(role, role1.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }
}
