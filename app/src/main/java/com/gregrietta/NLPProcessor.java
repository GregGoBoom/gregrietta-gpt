package com.gregrietta;

import java.util.regex.Pattern;

public class NLPProcessor {
    /**
     * Normalize input: lowercase trim, remove punctuation.
     */
    public static String normalize(String input) {
        return input.toLowerCase().replaceAll("[^a-zA-Z0-9\\s]", "").trim();
    }

/**
     * Detects if input is a greeting.
     */
    public static boolean isGreeting(String input) {
        return Pattern.compile("\\b(hi|hello|hey|greetings)\\b").matcher(input).find();
    }

    /**
     * Detects if input is asking how the bot is.
     */
    public static boolean isHowAreYou(String input) {
        return Pattern.compile("how are you").matcher(input).find();
    }

    /**
     * Detects if input is asking for the bot's name.
     */
    public static boolean isAskingName(String input) {
        return Pattern.compile("what.*your name").matcher(input).find();
    }
}
