package com.example.zad.repozitory.InMemmoryrep;

import com.example.zad.domen.Books;


import java.util.ArrayList;

public class StorageB {
    private static StorageB instanse;
    public ArrayList<Books> books;

    public static StorageB getInstance(){
        if(instanse==null){
            instanse =new StorageB();

        }
        return instanse;
    }



    private StorageB(){
        this.books=new ArrayList<>();

    }
}
