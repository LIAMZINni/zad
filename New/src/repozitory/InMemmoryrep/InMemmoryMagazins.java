package repozitory.InMemmoryrep;

import domen.Books;
import domen.Magazins;
import repozitory.Repozitory;

import java.util.ArrayList;
import java.util.Scanner;

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
    public Magazins update(int id) {
        Scanner scan =new Scanner(System.in);
        Magazins magazins=find(id);
        System.out.print("name= ");
        String name=scan.next();

        System.out.print("autor= ");
        String autor=scan.next();
        System.out.print("kolvo= ");
        int kolvo=scan.nextInt();
        System.out.print("price ");
        double price= scan.nextInt();
        magazins.setName(name);
        magazins.setAutor(autor);
        magazins.setKolvo(kolvo);
        magazins.setPrice(price);


        return magazins;
    }
}
