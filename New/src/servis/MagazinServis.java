package servis;

import domen.Magazins;
import repozitory.Repozitory;

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
    public Magazins update(int id) {
        return magazinsRepozitory.update(id);
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
