package ru.rtu_mirea;

public class User {
    private String username;
    public User(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void sendMessage(String message) {
        Mediator.sendMessage(this, message);
    }
}
