package com.itvnue.Training.project.Models;

import javax.persistence.Column;

public enum RoleName {

    Auditor("Auditor"),
    Superuser("Superuser"),
    SupportUser("SupportUser");

    public final String RoleNameLabel;

    private RoleName(String RoleNameLabel) {
        this.RoleNameLabel = RoleNameLabel;
    }
}
