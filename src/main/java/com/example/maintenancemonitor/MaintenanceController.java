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
}
