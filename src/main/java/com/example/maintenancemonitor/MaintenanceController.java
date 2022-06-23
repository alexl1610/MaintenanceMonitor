package com.example.maintenancemonitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {

    private Monitor monitor = new Monitor();

    @RequestMapping("/set")
    public String set(
            @RequestParam double a
    ) {
        monitor.setPercent(a);
        return monitor.change(monitor.getPercent());
    }

    @RequestMapping("/status")
    public String status() {
        if (monitor.getPercent() < 0) {
            return "Current status level is either invalid or not set";
        } else if (monitor.getPercent() >= 99.95) {
            return monitor.correctMessage(monitor.getPercent());
        }
        return monitor.falseMessage(monitor.getPercent());
    }

    @RequestMapping("/setMin")
    public String setMin(
            @RequestParam int a,
            @RequestParam int b
    ) {
        monitor.setPercent(monitor.convert(a,b));
        return monitor.change(monitor.getPercent());
    }
}
