package ru.rtu_mirea;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	    Tea_Factory tea = null;
        System.out.println("We've got some types of tea - green and black. What did you prefer?");
        System.out.print("> ");
        Scanner input = new Scanner(System.in);
        String ans = input.nextLine();
        switch (ans) {
            case "green":
                tea = new GreenTea_Factory();
                break;
            case "black":
                tea = new BlackTea_Factory();
                break;
        }

        System.out.println("Indian(I) or Turkish(T)?");
        System.out.print("> ");
        ans = input.nextLine();
        switch (ans) {
            case "I":
                tea.create_IndianT();
                break;
            case "T":
                tea.create_TurkishT();
                break;
        }
    }
}
