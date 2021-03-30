package com.company;

public class Diopter {
    private String sphere;
    private String cylinder;
    private double axis;

    public Diopter(String sphere, String cylinder, double axis) {
        this.sphere = sphere;
        this.cylinder = cylinder;
        this.axis = axis;
    }

    public String getSphere() {
        return sphere;
    }

    public void setSphere(String sphere) {
        this.sphere = sphere;
    }

    public String getCylinder() {
        return cylinder;
    }

    public void setCylinder(String cylinder) {
        this.cylinder = cylinder;
    }

    public double getAxis() {
        return axis;
    }

    public void setAxis(double axis) {
        this.axis = axis;
    }

    @Override
    public String toString() {
        return  sphere + ", " +
                cylinder + ", " +
                axis;
    }

}
