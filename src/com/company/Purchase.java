package com.company;

import java.time.LocalDate;

public class Purchase {
    private Glass glass;
    private String frame;
    private double price;
    private double discount;
    private LocalDate date;

    public Purchase(Glass glass, String frame, double price, double discount) {
        this.glass = glass;
        this.frame = frame;
        this.price = price-discount;
        this.discount = discount;
        date = LocalDate.now();
    }

    public Glass getGlass() {
        return glass;
    }

    public void setGlass(Glass glass) {
        this.glass = glass;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return  glass + ", " +
                frame + ", " +
                price + ", " +
                discount + ", " +
                date;
    }
}
