package com.gregrietta;

/**
 * ChatBot handles user input and generates responses.
 * In Version 3, it uses NLPProcessor to provide more natural, human-like replies.
 */
public class ChatBot {
    private final MemoryManager memory;

    /**
     * Initializes the chatbot and loads memory from file.
     */
    public ChatBot() {
        memory = new MemoryManager();
    }

    /**
     * Returns a response to the user's input.
     * First checks learned memory, then uses NLP logic, and finally falls back to hardcoded responses.
     *
     * @param input The user's input string
     * @return A response string, or null if unknown
     */
    public String getResponse(String input) {
        // Normalize input for consistent processing
        String normalized = NLPProcessor.normalize(input);

        // Check if the bot has learned this input before
        if (memory.knows(normalized)) {
            return memory.getResponse(normalized);
        }

        // NLP-based responses
        if (NLPProcessor.isGreeting(normalized)) {
            return "Hey there! 👋";
        } else if (NLPProcessor.isHowAreYou(normalized)) {
            return "I'm doing great, thanks for asking!";
        } else if (NLPProcessor.isAskingName(normalized)) {
            return "I'm Gregrietta GPT, your friendly chatbot!";
        }

        // Fallback to hardcoded responses
        switch (normalized) {
            case "hello":
                return "Hi there!";
            case "how are you":
                return "I'm just a bunch of code, but thanks for asking!";
            default:
                return null; // Unknown input, bot will ask to learn
        }
    }

    /**
     * Teaches the bot a new input-response pair and saves it to memory.
     *
     * @param input The user's input
     * @param response The chatbot's response to learn
     */
    public void learn(String input, String response) {
        String normalized = NLPProcessor.normalize(input);
        memory.learn(normalized, response);
    }
}
