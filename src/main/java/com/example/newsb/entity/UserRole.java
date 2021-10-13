package com.example.newsb.entity;

public enum UserRole {
    ADMIN, STUDENT;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}

