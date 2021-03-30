package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {
    private int ID;
    private String name;
    private String surname;
    private String email;
    private Glass glass;
    private ArrayList<Purchase> purchases;

    public Client(int ID, String name, String surname, String email, Glass glass) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.glass = glass;
    }

    public Client(int ID, String name, String surname, String email, Purchase purchase) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.email = email;
        glass = purchase.getGlass();
        purchases = new ArrayList<>();
        this.purchases.add(purchase);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Glass getGlass() {
        return glass;
    }

    public void setGlass(Glass glass) {
        this.glass = glass;
    }

    public ArrayList<Purchase> getPurchases() {
        return purchases;
    }

    @Override
    public String toString() {
        return "Client{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", glass=" + glass +
                ", purchases=" + purchases +
                '}';
    }
}
