package com.example.zad;

import java.util.ArrayList;

public interface Repozitory<T>{
    void add (T sourse);
    void delit(int id);
    void update(int id);
    void sold(int id);
    ArrayList<T> print();
    void find(int id);




}
