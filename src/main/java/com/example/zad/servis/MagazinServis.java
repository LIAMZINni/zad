package com.example.zad.servis;

import com.example.zad.domen.Magazins;
import com.example.zad.repozitory.Repozitory;


import java.util.List;

public class MagazinServis implements Servis<Magazins>{
    private final Repozitory<Magazins> magazinsRepozitory;

    public MagazinServis(Repozitory<Magazins>magazinsRepozitory) {
        this.magazinsRepozitory=magazinsRepozitory;
    }

    @Override
    public Magazins findItem(int id) {
        return magazinsRepozitory.find(id);
    }

    @Override
    public List<Magazins> printAll() {
        return magazinsRepozitory.print();
    }

    @Override
    public double sold(int id, int kolvo) {
        return magazinsRepozitory.sold(id,kolvo);
    }

    @Override
    public Magazins update(Magazins magazins) {
        return magazinsRepozitory.update(magazins);
    }

    @Override
    public void add(Magazins target) {
        magazinsRepozitory.add(target);

    }

    @Override
    public void delit(Magazins target) {
        magazinsRepozitory.delit(target);

    }
}
