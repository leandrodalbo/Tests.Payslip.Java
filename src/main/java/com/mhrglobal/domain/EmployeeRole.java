package com.mhrglobal.domain;

public enum EmployeeRole {
    ENGINEER("ENGINEER"),
    MANAGER("MANAGER"),
    DIRECTOR("DIRECTOR"),
    NONE("NONE");

    private final String value;

    EmployeeRole(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
