package com.company;

import java.util.ArrayList;

public class Storage {
    private static Storage instance;
    private ArrayList<Client> clients;

    private Storage(){
        clients = new ArrayList<>();
    }

    public static Storage getInstance(){
        if (instance == null) instance = new Storage();
        return instance;
    }
    public void addClient(Client c){
        clients.add(c);
    }
    public ArrayList<Client> getClients(){
        return clients;
    }
}
