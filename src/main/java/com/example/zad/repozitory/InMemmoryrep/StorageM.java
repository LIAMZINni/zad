package com.example.zad.repozitory.InMemmoryrep;

import com.example.zad.domen.Magazins;


import java.util.ArrayList;

public class StorageM {
    private static StorageM instanse;
    public ArrayList<Magazins> magazins;

    public static StorageM getInstance(){
        if(instanse==null){
            instanse =new StorageM();

        }
        return instanse;
    }



    private StorageM(){
        this.magazins=new ArrayList<>();

    }
}
