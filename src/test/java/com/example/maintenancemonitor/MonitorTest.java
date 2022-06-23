package com.example.maintenancemonitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonitorTest {

    private Monitor monitor = new Monitor();

    @Test
    void setPercentTest() {
        monitor.setPercent(50);

        assertEquals(50, monitor.getPercent());
    }

    @Test
    void changeTest() {
        double a = 86;

        assertEquals("Status level changed to 86.0%", monitor.change(a));
    }
}