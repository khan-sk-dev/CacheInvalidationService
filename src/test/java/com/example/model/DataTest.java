package com.example.model;


import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Test class for {@link Data}.
 * Ensures 100% line and branch coverage with JUnit 5.
 */
public class DataTest {

    /**
     * Tests the constructor and verifies the initialized values.
     * Ensures minimum and maximum constraints are met.
     */
    @Test
    void testConstructor() {
        Data data = new Data(1, "testValue");
        assertEquals(1, data.getId(), "ID should match the initialized value");
        assertEquals("testValue", data.getValue(), "Value should match the initialized value");
    }

    /**
     * Tests the getter method for ID.
     */
    @Test
    void testGetId() {
        Data data = new Data(42, "example");
        assertEquals(42, data.getId(), "ID should be retrieved correctly");
    }

    /**
     * Tests the getter method for value.
     */
    @Test
    void testGetValue() {
        Data data = new Data(99, "sample");
        assertEquals("sample", data.getValue(), "Value should be retrieved correctly");
    }

    /**
     * Tests the setter method for value.
     */
    @Test
    void testSetValue() {
        Data data = new Data(55, "initial");
        data.setValue("updated");
        assertEquals("updated", data.getValue(), "Value should be updated correctly");
    }

    /**
     * Tests constructor with edge cases (min/max constraints for ID and value length).
     */
    @Test
    void testConstructorWithConstraints() {
        Data minData = new Data(Integer.MIN_VALUE, "a"); // Minimum ID, smallest non-empty string
        assertEquals(Integer.MIN_VALUE, minData.getId(), "ID should accept Integer.MIN_VALUE");
        assertEquals("a", minData.getValue(), "Value should accept a minimum-length string");
        
        Data maxData = new Data(Integer.MAX_VALUE, "This is a long string to test maximum constraints");
        assertEquals(Integer.MAX_VALUE, maxData.getId(), "ID should accept Integer.MAX_VALUE");
        assertEquals("This is a long string to test maximum constraints", maxData.getValue(), "Value should accept long strings");
    }

}
