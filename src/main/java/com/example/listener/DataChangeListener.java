package com.example.listener;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.example.event.DataChangeEvent;

/**
 * Listener for {@link DataChangeEvent}.
 * <p>
 * This component listens for data change events and invalidates the cache
 * for the corresponding data entry.
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
@Component
public class DataChangeListener implements ApplicationListener<DataChangeEvent> {
    
    /**
     * Handles the {@link DataChangeEvent} by evicting the corresponding cache entry.
     * <p>
     * When a data change event occurs, this method removes the associated cache entry,
     * ensuring the cache remains consistent with the updated data.
     * </p>
     *
     * @param event The data change event containing the ID of the modified data.
     */
    @CacheEvict(value = "data", key = "#event.id")
    public void onApplicationEvent(DataChangeEvent event) {
        System.out.println("Invalidating cache for ID: " + event.getId());
    }
}