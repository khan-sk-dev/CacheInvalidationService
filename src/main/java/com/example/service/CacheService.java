package com.example.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import com.example.event.DataChangeEvent;
import com.example.model.Data;

/**
 * Service class responsible for managing cached data retrieval and updates.
 * Implements caching for optimized data access and triggers events on data updates.
 *
 * @author Your Name
 * @version 1.0
 */
@Service
public class CacheService {
    
    /**
     * Event publisher for broadcasting data change events.
     */
    private final ApplicationEventPublisher eventPublisher;
    
    /**
     * In-memory data storage simulating a database.
     */
    private final Map<Integer, Data> database = new HashMap<>();
    
    /**
     * Constructor for CacheService.
     *
     * @param eventPublisher The event publisher used to broadcast data change events.
     */
    public CacheService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }
    
    /**
     * Retrieves data from the cache or returns a default value if not present.
     *
     * @param id The unique identifier for the data.
     * @return The retrieved data if present, otherwise a default Data object.
     */
    @Cacheable("data")
    public Data getData(int id) {
        return database.getOrDefault(id, new Data(id, "Default Data"));
    }
    
    /**
     * Updates data in the database and triggers a cache invalidation event.
     *
     * @param id The unique identifier for the data to update.
     * @param newData The new value to be assigned.
     */
    public void updateData(int id, String newData) {
        database.put(id, new Data(id, newData));
        eventPublisher.publishEvent(new DataChangeEvent(this, id));
    }
}
