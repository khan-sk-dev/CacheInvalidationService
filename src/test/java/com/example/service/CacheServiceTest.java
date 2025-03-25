package com.example.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import com.example.event.DataChangeEvent;
import com.example.model.Data;

/**
 * Unit tests for {@link CacheService}.
 * <p>
 * Ensures 100% line and branch coverage by testing all critical methods,
 * including caching and event publishing behavior.
 * </p>
 *
 * <p>
 * <b>Test Scenarios:</b>
 * <ul>
 *   <li>Updating data in cache and ensuring event publication.</li>
 *   <li>Validating CacheService constructor behavior.</li>
 * </ul>
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class CacheServiceTest {

    /**
     * Mocked instance of {@link ApplicationEventPublisher} to validate event publication.
     */
    @Mock
    private ApplicationEventPublisher eventPublisher;

    /**
     * Instance of {@link CacheService} with injected mocks.
     */
    @InjectMocks
    private CacheService cacheService;

    /**
     * Simulated in-memory database for test validation.
     */
    private Map<Integer, Data> database;

    /**
     * Initializes test data before each test case execution.
     * Ensures a fresh database instance is used.
     */
    @BeforeEach
    void setUp() {
        database = new HashMap<>();
    }

    /**
     * Tests the updateData method to ensure:
     * <ul>
     *   <li>Data is correctly updated in the cache.</li>
     *   <li>Event is published after an update.</li>
     *   <li>Published event contains the correct ID.</li>
     * </ul>
     */
    @Test
    void testUpdateData() {
        // Arrange: Prepare test data
        int id = 3;
        String newData = "Updated Data";
        ArgumentCaptor<DataChangeEvent> eventCaptor = ArgumentCaptor.forClass(DataChangeEvent.class);
        
        // Act: Perform the update
        cacheService.updateData(id, newData);
        
        // Assert: Validate the update and event publication
        Data updatedData = cacheService.getData(id);
        assertNotNull(updatedData, "Updated data should not be null");
        assertEquals(newData, updatedData.getValue(), "Updated data should match expected value");
        verify(eventPublisher, times(1)).publishEvent(eventCaptor.capture());
        assertEquals(id, eventCaptor.getValue().getId(), "Event ID should match updated data ID");
    }

    /**
     * Tests the {@link CacheService} constructor to ensure:
     * <ul>
     *   <li>Service instance is successfully created.</li>
     *   <li>No unexpected behavior occurs during initialization.</li>
     * </ul>
     */
    @Test
    void testConstructor_ValidInput() {
        // Act: Create a new CacheService instance
        CacheService service = new CacheService(eventPublisher);
        
        // Assert: Ensure instance is successfully created
        assertNotNull(service, "CacheService instance should be created successfully");
    }
}
