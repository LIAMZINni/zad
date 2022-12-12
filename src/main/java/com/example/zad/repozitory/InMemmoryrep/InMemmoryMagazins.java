package com.example.zad.repozitory.InMemmoryrep;

import com.example.zad.domen.Magazins;

import com.example.zad.repozitory.Repozitory;

import java.util.ArrayList;

public class InMemmoryMagazins implements Repozitory<Magazins> {
    private final ArrayList<Magazins> magazinsArrayList;

    public InMemmoryMagazins() {
        this.magazinsArrayList = StorageM.getInstance().magazins;
    }

    @Override
    public void add(Magazins sourse) {
        magazinsArrayList.add(sourse);

    }

    @Override
    public Magazins find(int id) {
        return magazinsArrayList.stream()
                .filter(b -> id==(b.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delit(Magazins sourse) {
        magazinsArrayList.removeIf(box -> box.getId()==(sourse.getId()));

    }

    @Override
    public ArrayList<Magazins> print() {
        return new ArrayList<>(magazinsArrayList);
    }

    @Override
    public double sold(int id, int kolvo) {
        double price=0;
        Magazins magazins=find(id);
        int kolvoPer=magazins.getKolvo();
        int raz=kolvoPer-kolvo;
        if(raz>0){
            magazins.setKolvo(raz);
            price=kolvo*magazins.getPrice();
        }
        if (raz==0){
            price=kolvo* magazins.getPrice();
            delit(magazins);


        }
        if(raz<0){
            return 0;
        }
        return price;
    }

    @Override
    public Magazins update(Magazins magazins) {

        return magazins;
    }
}
