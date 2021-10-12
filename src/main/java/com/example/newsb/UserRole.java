package com.example.newsb;

public enum UserRole {
    ADMIN, STUDENT;

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}

