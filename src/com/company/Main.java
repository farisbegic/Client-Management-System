package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int input;
        boolean state = true;
        Scanner in = new Scanner(System.in);
            while (state){
                System.out.println("1. Load all clients");
                System.out.println("2. Enter a new client");
                System.out.println("3. Delete a client");
                System.out.println("4. Add new purchase");
                System.out.println("5. Display all users");
                System.out.println("6. Write all clients");
                System.out.println("7. Exit the program");
                input = in.nextInt();
                switch (input){
                    case 1:
                        loadClients();
                        break;
                    case 2:
                        enterUser();
                        break;
                    case 3:
                        deleteClient();
                        break;
                    case 4:
                        addPurchase();
                        break;
                    case 5:
                        displayClients();
                        break;
                    case 6:
                        writeClients();
                        break;
                    case 7:
                        state = false;
                        break;
                }
            }
        }

    private static void deleteClient() {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the ID of a client you wish to remove: ");
        int ID = in.nextInt();
        Storage.getInstance().getClients().removeIf(c -> c.getID() == ID);
    }

    private static void writeClients() {
        File file = new File("data/clients.csv");
        try {
            FileWriter write = new FileWriter(file.getPath());
            ArrayList<Integer> IDs = new ArrayList<>();
            write.write("ID, Name, Surname, E-Mail, Glass Type, Sphere, Cylinder, Axis, Frame, Price(With discount), Discount, Date \n");
            for (Client c : Storage.getInstance().getClients()) {
                if (!IDs.contains(c.getID())){
                    write.write(c.getID() + ", " + c.getName() + ", " + c.getSurname() + ", " + c.getEmail() + ", " + c.getPurchases().get(0) + "\n");
                    IDs.add(c.getID());
                }
            }
            write.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void loadClients() {
        File file = new File("data/clients.csv");
        try {
            Scanner scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()){
                String[] parts = scan.nextLine().split(", ");
                Client temp = new Client(Integer.parseInt(parts[0]), parts[1], parts[2], parts[3], new Purchase(new Glass(parts[4], new Diopter(parts[5], parts[6], Double.parseDouble(parts[7]))), parts[8], Double.parseDouble(parts[9]), Double.parseDouble(parts[10])));
                Storage.getInstance().addClient(temp);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    private static void addPurchase() {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter clients ID number: ");
        int ID = in.nextInt();
        in.nextLine();
        boolean temp = false;
        for (Client c : Storage.getInstance().getClients()) {
            if (ID == c.getID()){
                temp = true;
                break;
            }
        }
        if (temp){
            System.out.println("We have found that client in our system, please enter the following");
        } else{
            System.out.println("We haven't found client with such ID thus exiting the function.");
            return;
        }
        System.out.println("Enter glass type: ");
        String glassType = in.nextLine();
        System.out.println("Enter sphere: ");
        String sphere = in.nextLine();
        System.out.println("Enter cylinder: ");
        String cylinder = in.nextLine();
        System.out.println("Enter axis: ");
        double axis = in.nextDouble();
        in.nextLine();
        System.out.println("Enter frame: ");
        String frame = in.nextLine();
        System.out.println("Enter price: ");
        double price = in.nextDouble();
        System.out.println("Enter discount: ");
        double discount = in.nextDouble();
        Purchase p = new Purchase(new Glass(glassType, new Diopter(sphere,cylinder,axis)),frame,price,discount);
        for (Client c : Storage.getInstance().getClients()) {
            if (ID == c.getID()){
                c.getPurchases().add(p);
            }
        }
    }

    private static void enterUser() {
        int ID;
        String name, surname, email, glassType, sphere, cylinder, frame;
        double axis, price, discount;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter clients ID Number: ");
        ID = in.nextInt();
        in.nextLine();
        System.out.print("Enter clients name: ");
        name = in.nextLine();
        System.out.print("Enter clients surname: ");
        surname = in.nextLine();
        System.out.print("Enter clients email: ");
        email = in.nextLine();
        System.out.print("Enter clients glass type: ");
        glassType = in.nextLine();
        System.out.print("Enter clients sphere: ");
        sphere = in.nextLine();
        System.out.print("Enter clients cylinder: ");
        cylinder = in.nextLine();
        System.out.print("Enter clients axis: ");
        axis = in.nextDouble();
        System.out.print("Enter clients frame: ");
        in.nextLine();
        frame = in.nextLine();
        System.out.print("Enter the price: ");
        price = in.nextDouble();
        System.out.print("Enter the discount: ");
        discount = in.nextDouble();

        Client client = new Client(ID,name, surname, email, new Purchase(new Glass(glassType, new Diopter(sphere,cylinder,axis)),frame,price,discount));
        Storage.getInstance().addClient(client);
    }

    private static void displayClients() {
        for (Client c : Storage.getInstance().getClients()) {
            System.out.println(c);
        }
    }
}
