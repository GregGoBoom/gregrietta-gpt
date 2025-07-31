package org.example;

import java.util.Scanner;

public class App {
    private static final String BOT_NAME = "Gregrietta";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to " + BOT_NAME + "-GPT! Type 'exit' to quit.");

        while (true) {
            System.out.print("You: ");
            String input;
            try {
                input = scanner.nextLine().trim().toLowerCase();
            } catch (Exception e) {
                System.err.println(BOT_NAME + ": Sorry, I didn't catch that. Exiting");
                break;
            }

            if ("exit".equals(input)) {
                System.out.println(BOT_NAME + ": Goodbye!");
                break;
            }

            System.out.println(BOT_NAME + ": " + getResponse(input));
        }
        scanner.close();
    }

    private static String getResponse(String input) {
        switch (input) {
            case "hello":
            return "Hi there!";
        case "how are you":
            return "I'm just code, but I'm running smoothly!";
        case "what is your name":
            return "My name is " + BOT_NAME + ", your friendly AI assistant!";
        default:
            return "I don't understand that yet.";
        }
    }
}