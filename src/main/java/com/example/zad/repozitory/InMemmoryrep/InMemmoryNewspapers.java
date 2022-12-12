package com.example.zad.repozitory.InMemmoryrep;

import com.example.zad.domen.Newspaper;
import com.example.zad.repozitory.Repozitory;


import java.util.ArrayList;

public class InMemmoryNewspapers implements Repozitory<Newspaper> {
    private final ArrayList<Newspaper> publicistics;

    public InMemmoryNewspapers() {
        this.publicistics= Storage.getInstance().newspapers;
    }


    @Override
    public void add(Newspaper sourse) {
        publicistics.add(sourse);

    }

    @Override
    public Newspaper find(int id) {
        return publicistics.stream()
                .filter(b -> id==(b.getId()))
                .findFirst()
                .orElse(null);
    }







    @Override
    public void delit(Newspaper sourse) {
        publicistics.removeIf(box -> box.getId()==(sourse.getId()));

    }



    @Override
    public ArrayList<Newspaper> print() {
        return new ArrayList<>(publicistics);
    }

    @Override
    public double sold(int id, int kolvo) {
        double price=0;
        Newspaper newspaper=find(id);
        int kolvoPer=newspaper.getKolvo();
        int raz=kolvoPer-kolvo;
        if(raz>0){
            newspaper.setKolvo(raz);
            price=kolvo*newspaper.getPrice();
        }
        if (raz==0){
            price=kolvo* newspaper.getPrice();
            delit(newspaper);


        }
        if(raz<0){
            return 0;
        }
        return price;

    }

    @Override
    public Newspaper update(Newspaper newspaper) {



        return newspaper;
    }
}
