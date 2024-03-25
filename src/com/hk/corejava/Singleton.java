package com.hk.corejava;

import java.io.Serializable;

public class Singleton implements Serializable {
    private static final long serialVersionUID = 1L;

    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
        if (instance != null) {
            throw new IllegalStateException("Singleton instance already created.");
        }
    }

    // Implement readResolve to prevent deserialization creating a new instance
    protected Object readResolve() {
        return instance;
    }

    // Override clone to prevent cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Clone is not allowed.");
    }

    public static synchronized Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }
    // Optional: Add other methods or properties as needed
}
