package com.example.maintenancemonitor;

public class Monitor {

    private double percent = -1;

    public double getPercent() {
        return percent;
    }
    public void setPercent(double a) {
        percent = a;
    }
    public String change(double a) {
        return "Status level changed to " + a + "%";
    }

    public String correctMessage(double a) {
        return "Current service level agreement: " + a + "%." + "<br>" +
                "Status level is ok!";
    }

    public String falseMessage(double a) {
        return "Current service level agreement: " + a + "%." + "<br>" +
                "Status level is not ok as its " + difference(a) + "% too low!";
    }

    public double difference (double a) {
        return 99.95 - a;
    }

    public double convert (double a, double b) {
        return ((a * 60 + b) / 60)*100/43800;
    }
}
