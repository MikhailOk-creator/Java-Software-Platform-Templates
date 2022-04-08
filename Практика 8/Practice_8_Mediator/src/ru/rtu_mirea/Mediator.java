package ru.rtu_mirea;

public class Mediator {
    public static void sendMessage(User user, String message) {
        System.out.println(user.getUsername() + ": " + message);
    }
}
