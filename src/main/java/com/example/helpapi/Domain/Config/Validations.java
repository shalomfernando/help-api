package com.example.helpapi.Domain.Config;

public class Validations {
    public static boolean IsNullOrEmpty(String attribute) {
        return (attribute == null || attribute.isEmpty());
    }
}
