package ru.rtu_mirea;

public class Main {

    public static void main(String[] args) {
	    User user1 = new User("Roger");
        User user2 = new User("David");
        user1.sendMessage("Run here, I have an idea for a concept album!");
        user2.sendMessage("Have you got any music ideas?");
    }
}
