package com.example.event;

import org.springframework.context.ApplicationEvent;

/**
 * Event representing a change in data.
 * <p>
 * This event is published whenever data is updated, allowing listeners
 * to respond to changes accordingly.
 * </p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>
 *     applicationEventPublisher.publishEvent(new DataChangeEvent(this, id));
 * </pre>
 *
 * @author Your Name
 * @version 1.0
 */
public class DataChangeEvent extends ApplicationEvent {
    
    private final int id;
    
    /**
     * Constructs a new DataChangeEvent.
     * <p>
     * This constructor initializes the event with a source object and an identifier.
     * </p>
     *
     * @param source The object on which the event initially occurred.
     * @param id The unique identifier of the data that changed.
     */
    public DataChangeEvent(Object source, int id) {
        super(source);
        this.id = id;
    }
    
    /**
     * Retrieves the ID associated with the changed data.
     *
     * @return The unique identifier of the modified data.
     */
    public int getId() {
        return id;
    }
}
