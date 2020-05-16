package com.example.helpapi.Domain.Config;

import static com.example.helpapi.Domain.Config.Notifications.CreateNotification;

public class ValidationContract extends Validations {

    public static Notifications IsNullOrEmpty(String attribute, String property, String message) {
        if (IsNullOrEmpty(attribute))
            return CreateNotification(property,message);
        return null;
    }

    public static Notifications MaxLenght(String attribute,Integer lenght, String property, String message){
        if (attribute.length() > lenght)
            return CreateNotification(property,message);
        return null;
    }
}
