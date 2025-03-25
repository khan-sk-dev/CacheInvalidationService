package com.example.model;

/**
 * Model class representing data with an ID and value.
 * <p>
 * This class provides getter and setter methods for managing data entities.
 * </p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>
 *     Data data = new Data(1, "Sample Value");
 *     int id = data.getId();
 *     String value = data.getValue();
 * </pre>
 *
 * @author Your Name
 * @version 1.0
 */
public class Data {
    
    private int id;
    private String value;

    /**
     * Constructs a new {@code Data} object.
     *
     * @param id The unique identifier of the data.
     * @param value The associated value of the data.
     */
    public Data(int id, String value) {
        this.id = id;
        this.value = value;
    }

    /**
     * Retrieves the ID of the data.
     *
     * @return The unique identifier.
     */
    public int getId() {
        return id;
    }

    /**
     * Retrieves the value associated with the data.
     *
     * @return The data value.
     */
    public String getValue() {
        return value;
    }

    /**
     * Updates the value of the data.
     *
     * @param value The new value to set.
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Updates the ID of the data.
     *
     * @param id The new ID to set.
     */
    public void setId(int id) {
        this.id = id;
    }
}