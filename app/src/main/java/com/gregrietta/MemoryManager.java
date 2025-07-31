package com.gregrietta;

import com.google.gson.reflect.TypeToken;
import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;



public class MemoryManager {
    private static final String MEMORY_FILE = "memory.json"; // File to store memory
    private Map<String, String> memory; // In-memory map of input-response pairs
    private final Gson gson = new Gson(); // Gson instance for JSON serialization


    /**
     * Constructor loads memory from file or initializes a new one.
     */
    public MemoryManager() {
        memory = loadMemory();
    }

    
    /**
     * Loads memory from the JSON file.
     * If the file doesn't exist or fails to load, returns an empty map.
     */
    private Map<String, String> loadMemory() {
        try (Reader reader = new FileReader(MEMORY_FILE)) {
            Type type = new TypeToken<Map<String, String>>() {}.getType();
            return gson.fromJson(reader, type);
        } catch (IOException e) {
            return new HashMap<>(); // Return the empty memory if file not found or unreadable
        }
    }


    /**
     * Saves the current memory map to the JSON file.
     */
    public void saveMemory() {
        try (Writer writer = new FileWriter(MEMORY_FILE)) {
            gson.toJson(memory, writer);
        } catch (IOException e) {
            System.err.println("Failed to save memory: " + e.getMessage());
        }
    }


    /**
     * Retrieves a response for a given input if it exists in memory.
     * @param input The user's input
     * @return The learned response, or null if not found
     */
    public String getResponse(String input) {
        return memory.get(input.toLowerCase());
    }


    /**
     * Learns a new input-response pair and saves it to memory.
     * @param input The user's input
     * @param response The chatbot's response
     */
    public void learn(String input, String response) {
        memory.put(input.toLowerCase(), response);
        saveMemory();
    }

    /**
     * Checks if the chatbot already knows a response for the input.
     * @param input The user's input
     * @return true if known, false otherwise
     */
    public boolean knows(String input) {
        return memory.containsKey(input.toLowerCase());
    }

}
