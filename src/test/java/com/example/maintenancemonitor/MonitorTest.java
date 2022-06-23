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

    @Test
    void difference() {
        double a = 50;

        assertEquals(49.95, monitor.difference(a));
    }

    @Test
    void correctMessageTest() {
        double a = 99.95;

        assertEquals("Current service level agreement: 99.95%." + "<br>" +
                "Status level is ok!", monitor.correctMessage(a));
    }

    @Test
    void falseMessageTest() {
        double a = 99.94;

        assertEquals("Current service level agreement: 99.94%." + "<br>" +
                "Status level is not ok as its 0.010000000000005116% too low!", monitor.falseMessage(a));
    }
}