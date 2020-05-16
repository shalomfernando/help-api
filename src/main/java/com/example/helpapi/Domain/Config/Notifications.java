package com.example.helpapi.Domain.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Notifications {

    private String Property;
    private String Message;

    private ArrayList<Notifications> Notifications;

    private Notifications(String property, String message) {
        Property = property;
        Message = message;
    }

    public Notifications() {
        Notifications = new ArrayList<>();
    }

    public static Notifications CreateNotification(String property,String message) {
        return new Notifications(property,message);
    }

    public void AddNotification(Notifications notification) {
        if (notification != null)
            Notifications.add(notification);
    }

    public void AddNotifications(List<Notifications> notifications) {
        if (notifications != null)
            Notifications.addAll(notifications);
    }

    public ArrayList<Notifications> GetNotifications(){
        return Notifications;
    }

    public boolean Valid() {
        return (Notifications.size() == 0);
    }

    public boolean IsValid() {
        return true;
    }
}
