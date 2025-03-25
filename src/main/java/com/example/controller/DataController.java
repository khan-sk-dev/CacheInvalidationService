package com.example.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Data;
import com.example.service.CacheService;

/**
 * REST Controller for managing data operations.
 * <p>
 * This controller provides endpoints to retrieve and update data,
 * leveraging caching mechanisms for optimized performance.
 * </p>
 *
 * <p><b>Usage Example:</b></p>
 * <pre>
 *     GET /data/{id} - Retrieve data by ID.
 *     POST /data/{id} - Update data and invalidate cache.
 * </pre>
 *
 * @author Your Name
 * @version 1.0
 */
@RestController
@RequestMapping("/data")
public class DataController {

    private final CacheService cacheService;

    /**
     * Constructor for DataController.
     * <p>
     * Injects {@link CacheService} to manage data retrieval and updates.
     * </p>
     *
     * @param cacheService The service handling cache operations.
     */
    public DataController(CacheService cacheService) {
        this.cacheService = cacheService;
    }

    /**
     * Retrieves data by ID.
     * <p>
     * This method fetches data from the cache or database based on the given ID.
     * </p>
     *
     * @param id The unique identifier of the data.
     * @return The requested {@link Data} object.
     */
    @GetMapping("/{id}")
    public Data getData(@PathVariable int id) {
        return cacheService.getData(id);
    }

    /**
     * Updates data and invalidates the cache.
     * <p>
     * This method updates the stored data and triggers cache invalidation.
     * </p>
     *
     * @param id The unique identifier of the data.
     * @param newData The new data content.
     * @return A success message confirming the update and cache invalidation.
     */
    @PostMapping("/{id}")
    public String updateData(@PathVariable int id, @RequestBody String newData) {
        cacheService.updateData(id, newData);
        return "Data updated and cache invalidated for ID: " + id;
    }
}
