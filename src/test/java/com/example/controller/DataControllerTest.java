package com.example.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.model.Data;
import com.example.service.CacheService;

/**
 * Unit test for {@link DataController}.
 * <p>
 * This test class ensures the correct functionality and coverage
 * of the DataController by verifying interactions with the CacheService.
 * </p>
 *
 * @author Your Name
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class DataControllerTest {

    @Mock
    private CacheService cacheService;

    @InjectMocks
    private DataController dataController;

    /**
     * Setup method to initialize mock dependencies before each test case.
     * Ensures each test starts with a fresh mock state.
     */
    @BeforeEach
    void setUp() {
        reset(cacheService);
    }

    /**
     * Tests retrieving data from the controller.
     * <p>
     * Validates that {@code getData} correctly fetches data from the cache service.
     * </p>
     */
    @Test
    void testGetData() {
        int id = 1;
        Data expectedData = new Data(id, "Sample Data");
        when(cacheService.getData(id)).thenReturn(expectedData);

        Data result = dataController.getData(id);

        assertNotNull(result, "Result should not be null");
        assertEquals(expectedData, result, "Returned data should match expected data");
        verify(cacheService, times(1)).getData(id);
    }

    /**
     * Tests updating data in the cache.
     * <p>
     * Ensures that {@code updateData} method correctly updates and invalidates the cache.
     * </p>
     */
    @Test
    void testUpdateData() {
        int id = 1;
        String newData = "Updated Data";
        doNothing().when(cacheService).updateData(id, newData);

        String response = dataController.updateData(id, newData);

        assertNotNull(response, "Response should not be null");
        assertEquals("Data updated and cache invalidated for ID: " + id, response,
                "Response message should indicate update success");
        verify(cacheService, times(1)).updateData(id, newData);
    }

    /**
     * Tests handling null values when retrieving data.
     * <p>
     * Ensures that {@code getData} gracefully handles null returns from CacheService.
     * </p>
     */
    @Test
    void testGetData_NotFound() {
        int id = 2;
        when(cacheService.getData(id)).thenReturn(null);

        Data result = dataController.getData(id);

        assertNull(result, "Result should be null for non-existing data");
        verify(cacheService, times(1)).getData(id);
    }
}
