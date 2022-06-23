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

    @RequestMapping("/reset")
    public String reset() {
        monitor.setPercent(-1);
        return "Status level reset";
    }

    @RequestMapping("/")
    public String open() {
        return "Welcome to the Maintenance Monitor!" + "<br>" +
                "Our Customers expect electricity around the clock " +
                "with a service level agreement of 99.95%."  + "<br>" + "<br>" +
                "The following options are available:" + "<br>" +
                "/set?a=X -> To set the current status to X"  + "<br>" +
                "/setMin?a=X&b=X -> To set the current status using Xmin and Xsec" + "<br>" +
                "/status -> To see the current status level"  + "<br>" +
                "/reset -> To reset the current status level";
    }
}
