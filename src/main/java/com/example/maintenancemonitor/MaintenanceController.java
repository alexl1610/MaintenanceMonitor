package com.example.maintenancemonitor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MaintenanceController {

    @RequestMapping("/set")
    public String set(
            @RequestParam double a
    ) {
        double status = a;
        return "Status set to" + status;
    }
}
