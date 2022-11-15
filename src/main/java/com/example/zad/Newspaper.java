package com.example.zad;

import javafx.beans.property.StringProperty;

public class Newspaper {
    private String autor;
    private String name;
    private int id;
    private double price;

    public double getPrice() {
        return price;
    }

    public Newspaper(String name, int id, double price, String autor) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.autor=autor;
    }




    public void setId(int newid){
        this.id=id;
    }
    public int getId() {
        return id;
    }
    public void setName(String newname){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAutor(String newautor){
        this.autor=autor;
    }
    public String getAutor(){
        return  autor;
    }


    public String tostring() {
        return "id= "+id+"\n"+
                "name= "+name+"\n"+
                "autor= "+autor+"\n"+
                 "price= "+price+"\n";

    }
}


