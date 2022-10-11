package com.example.zad;

public class Buyer extends Person{

    int bonus;
    public Buyer(String name,int age,int bonus){
        super(name,age);
        this.bonus=bonus;
    }


    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getBonus() {
        return bonus;
    }


    public String toString() {
        return  "name ="+name+"\n"+
                "age= "+ age+"\n"+
                "bonus'" + bonus+ '\''
                ;
    }
}
