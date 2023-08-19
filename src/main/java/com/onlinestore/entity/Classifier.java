package com.onlinestore.entity;

public enum Classifier {
    NOTE("Note"),
    TASK("Task"),
    INCOME("Income"),
    OUTCOME("Outcome"),
    MEETING("Meeting"),
    ASSIGNMENT("Assignment");

    public final String classifierName;

    Classifier(String classifierName) {
        this.classifierName = classifierName;
    }
}
