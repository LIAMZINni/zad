package com.example.zad;

public class Newspaper {
    private String autor;
    private String name;
    private int id;
    private int kolvo;
    private double price;

    public double getPrice() {
        return price;
    }



    public Newspaper(String name, int id, double price, int kolvo, String autor) {
        this.name = name;
        this.id = id;
        this.price = price;
        this.autor=autor;
        this.kolvo=kolvo;
    }


    public int getKolvo() {
        return kolvo;
    }

    public void setKolvo(int kolvo) {
        this.kolvo = kolvo;
    }

    public void setId(int id){
        this.id=id;
    }
    public int getId() {
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setAutor(String autor){
        this.autor=autor;
    }
    public String getAutor(){
        return  autor;
    }


    public String tostring() {
        return "id= "+id+"\n"+
                "name= "+name+"\n"+
                "autor= "+autor+"\n"+
                "kolvo= "+kolvo+"\n"+
                "price= "+price+"\n";

    }
}
