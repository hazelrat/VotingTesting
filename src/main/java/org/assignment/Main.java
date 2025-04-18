package org.assignment;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import static org.assignment.Candidate.*;
import static org.assignment.Logic.*;

public class Main {
    public static void main(String[] args) throws IOException {
    }

    static void mainMenu() {
        System.out.println("""
                Welcome to the VoteApp! Please select an option from below:
                1: I would like to lodge a vote.
                2: I would like to edit the list of candidates.
                4: I would like to access data relating to the election.
                5: I would like to edit my password.
                6: I would like to exit the application.
                """);

        Scanner menu = new Scanner(System.in);
        String menuInput = menu.nextLine();

        switch(menuInput) {
            case "1":
                vote();
                break;
            case "2":
                candidates();
                break;
            case "3":
                password();
                break;
            case "4":
                shutdown();
            default:
                System.out.println("You have entered an invalid input.");
        }
    }

    static void vote() {
        System.out.println("You are now voting on candidates.");
    }

    static void candidates() {
        System.out.println("You are now editing the candidates.");
    }

    static void password() {
        System.out.println("You are now editing your password.");
    }

    static void shutdown() {
        System.out.println("Shutting down application!");
        System.exit(0);
    }
}