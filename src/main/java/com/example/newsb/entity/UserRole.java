package com.example.newsb.entity;

public enum UserRole {
    ADMIN("messages.admin"),
    STUDENT("messages.student");

    final private String messageId;

    UserRole(String messageId) {
        this.messageId = messageId;
    }

    public String getMessageId() {
        return messageId;
    }

    @Override
    public String toString() {
        return "ROLE_" + name();
    }
}

