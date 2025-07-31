package com.gregrietta;



/**
 * ChatBot is the main logic class for handling user input and generating responses.
 * It uses a MemoryManager to recall learned responses and falls back to hardcoded replies.
 */
public class ChatBot {
    private final MemoryManager memory;
    /**
     * Constriuctor initializes the chatbot and loads memory from file
     */
    public ChatBot() {
        memory = new MemoryManager();
    }

    
/**
     * Returns a response to the user's input.
     * First checks if the input is known from memory.
     * If not, falls back to hardcoded responses.
     *
     * @param input The user's input string
     * @return A response string, or null if unknown
     */
    public String getResponse(String input) {
        // Check if the bot has learned this input before
        if (memory.knows(input)) {
            return memory.getResponse(input);
        }

        // Fallback to hardcoded responses
        switch (input.toLowerCase()) {
            case "hello":
                return "Hi there!";
            case "how are you?":
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
        memory.learn(input, response);
    }
}
