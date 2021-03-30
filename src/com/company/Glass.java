package com.company;

public class Glass {
    private String type;
    private Diopter diopter;

    public Glass(String type, Diopter diopter) {
        this.type = type;
        this.diopter = diopter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Diopter getDiopter() {
        return diopter;
    }

    public void setDiopter(Diopter diopter) {
        this.diopter = diopter;
    }

    @Override
    public String toString() {
        return  type + ", " +
                diopter;
    }
}
