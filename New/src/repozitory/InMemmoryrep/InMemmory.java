package repozitory.InMemmoryrep;

import domen.Newspaper;
import repozitory.Repozitory;

import java.util.ArrayList;
import java.util.Scanner;

public class InMemmory implements Repozitory<Newspaper> {
    private final ArrayList<Newspaper> publicistics;

    public InMemmory() {
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
    public Newspaper update(int id) {
        Scanner scan =new Scanner(System.in);
        Newspaper newspaper=find(id);
        System.out.print("name= ");
        String name=scan.next();

        System.out.print("autor= ");
        String autor=scan.next();
        System.out.print("kolvo= ");
        int kolvo=scan.nextInt();
        System.out.print("price ");
        double price= scan.nextInt();
        newspaper.setName(name);
        newspaper.setAutor(autor);
        newspaper.setKolvo(kolvo);
        newspaper.setPrice(price);


        return newspaper;
    }
}
