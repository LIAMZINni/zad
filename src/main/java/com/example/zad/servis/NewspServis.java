package com.example.zad.servis;

import com.example.zad.domen.Newspaper;
import com.example.zad.repozitory.Repozitory;


import java.util.List;

public class NewspServis implements Servis<Newspaper>{

    private final Repozitory<Newspaper> repozitory;


    public NewspServis(Repozitory<Newspaper> repozitory) {
        this.repozitory = repozitory;
    }

    @Override
    public Newspaper findItem(int id) {
        return repozitory.find(id);


    }

    @Override
    public List<Newspaper> printAll() {
        return repozitory.print();
    }

    @Override
    public double sold(int id,int kolvo) {
        return repozitory.sold(id,kolvo);
    }
    @Override
    public void add(Newspaper newspaper){
        repozitory.add(newspaper);

    }

    @Override
    public Newspaper update(Newspaper newspaper) {
        return repozitory.update(newspaper);
    }
    @Override
    public void delit(Newspaper newspaper){
        repozitory.delit(newspaper);

    }
}
