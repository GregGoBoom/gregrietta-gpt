package com.gregrietta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ChatBot bot = new ChatBot();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Gregrietta GPT 🤖 - Type 'exit' to quit");

        while (true) {
            System.out.print("You: ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) break;

            String response = bot.getResponse(input);

            if (response == null) {
                System.out.print("I don't know how to respond to that. What should I say? ");
                String learnedResponse = scanner.nextLine();
                bot.learn(input, learnedResponse);
                System.out.println("Got it! I'll remember that.");
            } else {
                System.out.println("Bot: " + response);
            }
        }

        scanner.close();
    }
}
