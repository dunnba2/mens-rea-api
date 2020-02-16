package com.revature.models;

public enum Role {

    ADMIN("Admin"), MEMBER("Member");

    private String roleName;

    Role(String name) {
        this.roleName = name;
    }

    @Override
    public String toString() {
        return this.roleName;
    }

}
