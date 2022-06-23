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
}
