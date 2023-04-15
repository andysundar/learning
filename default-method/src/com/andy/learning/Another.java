package com.andy.learning;

public interface Another {
    
    default String method() {
        return "Another";
    }
}
