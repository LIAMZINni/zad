package com.example.zad.repozitory;



import java.util.ArrayList;

public interface Repozitory<T> {
    void add(T sourse);
    T find(int id);
    void delit(T sourse);
    ArrayList<T> print();
    double sold(int id,int kolvo);
    T update(T sourse);


}
