package com.indium;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    private Car car;

    @BeforeEach
    public void setUp() {
        car = new Car();
    }

    @AfterEach
    public void tearDown() {
        car = null;
    }

    @Test
    void drive_a_car() {
        int speed = 100;
        car.drive(speed);
        assertEquals(car.getTotalNumberOfKms(), 100);
        car.drive(speed);
        assertEquals(car.getTotalNumberOfKms(), 200);
    }
}
