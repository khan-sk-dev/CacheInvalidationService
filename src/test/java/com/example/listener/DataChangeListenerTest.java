package com.example.listener;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.event.DataChangeEvent;

/**
 * Unit test for {@link DataChangeListener}.
 * Ensures that cache invalidation works correctly when a {@link DataChangeEvent} occurs.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
@EnableCaching
public class DataChangeListenerTest {

    @Autowired
    private DataChangeListener dataChangeListener;

    @Autowired
    private CacheManager cacheManager;

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    /**
     * Setup method to clear the cache before each test execution.
     * Ensures test cases run in isolation without cache contamination.
     */
    @BeforeEach
    public void setUp() {
        // Ensure the cache is empty before each test
        cacheManager.getCache("data").clear();
    }

    /**
     * Test case to verify that cache entries are invalidated upon receiving a {@link DataChangeEvent}.
     * Ensures the cache entry is removed after the event is published.
     */
    @Test
    public void testOnApplicationEvent() {
        // Arrange
        int id = 1;
        DataChangeEvent event = new DataChangeEvent(this, id);
        ConcurrentMapCache cache = (ConcurrentMapCache) cacheManager.getCache("data");
        cache.put(id, "someData");

        // Act
        applicationEventPublisher.publishEvent(event);

        // Assert
        assertThat(cache.get(id)).isNull(); // The cache entry should be invalidated
    }
}
