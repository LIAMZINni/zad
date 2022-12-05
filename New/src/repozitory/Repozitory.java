package repozitory;

import domen.Newspaper;

import java.util.ArrayList;
import java.util.Scanner;

public interface Repozitory<T> {
    void add(T sourse);
    T find(int id);
    void delit(T sourse);
    ArrayList<T> print();
    double sold(int id,int kolvo);
    T update(int id);


}
