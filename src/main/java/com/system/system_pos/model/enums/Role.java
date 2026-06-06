package com.system.system_pos.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Role {
    ADMIN("ADMIN", "ROLE_ADMIN"),
    EMPLOYEE("EMPLOYEE", "ROLE_EMPLOYEE");

    private final String name;
    private final String authority;

    Role(String name, String authority) {
        this.name = name;
        this.authority = authority;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public String getAuthority() {
        return authority;
    }

    public boolean isAdmin() { return this == ADMIN; }
    public boolean isEmployee() { return this == EMPLOYEE; }

    @JsonCreator
    public static Role fromString(String value) {
        if (value == null) return null;
        String v = value.trim().toUpperCase();
        if ("ROLE_ADMIN".equals(v) || "ADMIN".equals(v)) return ADMIN;
        if ("ROLE_EMPLOYEE".equals(v) || "EMPLOYEE".equals(v)) return EMPLOYEE;
        throw new IllegalArgumentException("Unknown role: " + value);
    }

    @Override
    public String toString() { return name; }
    
}
