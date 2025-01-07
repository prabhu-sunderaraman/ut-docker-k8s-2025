package com.indium;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class DataProcessingEngineTest {
    private DataProcessingEngine dataProcessingEngine;

    @BeforeEach
    void setUp() {
        dataProcessingEngine = new DataProcessingEngine();
    }

    @AfterEach
    void tearDown() {
        dataProcessingEngine = null;
    }

    @Test
    void setup_is_fine() {
        assertNotNull(dataProcessingEngine);
    }

    @Test
    void pass_empty_input_data() {
        InputData inputData = new InputData();
        OutputData outputData =  dataProcessingEngine.process(inputData);
        assertNotNull(outputData);
    }

    @Test
    void pass_data_with_values() {
        InputData inputData = new InputData();
        inputData.setFirstName("John");
        inputData.setLastName("Doe");
        inputData.setAge(30);
        OutputData outputData =  dataProcessingEngine.process(inputData);
        assertNotNull(outputData);
        String header = "Firstname,Lastname,Age\n";
        String row1 = "John,Doe,30\n";
        assertEquals(header + row1, outputData.getData());
    }
}
