package com.indium;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Tuesday tests")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class TuesdayTest {
    private Object dataObject;

    @BeforeAll
    static void initAll() {
        System.out.println("Before all tests");
    }

    @AfterAll
    static void cleanAll() {
        System.out.println("After all tests");
    }

    @BeforeEach
    void setDataObject() {
        dataObject = new Object();
    }

    @AfterEach
    void cleanDataObject() {
        dataObject = null;
    }

    @Test
    @Disabled
    void sample_message() {
        assertEquals("Hello Test", "Hello Test");
    }

    @Test
    void positive_test_example() {
        assertTrue(true);
    }

    @Test
    void negative_test_example() {
        assertFalse(false);
    }

    @Test
    void exception_test_example() {
        assertThrows(ArithmeticException.class, () -> {
            int i = 10 / 0;
        });
    }
}
