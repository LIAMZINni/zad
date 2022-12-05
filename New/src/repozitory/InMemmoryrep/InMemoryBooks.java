package repozitory.InMemmoryrep;

import domen.Books;
import repozitory.Repozitory;

import java.util.ArrayList;
import java.util.Scanner;

public class InMemoryBooks implements Repozitory<Books> {
    private final ArrayList<Books> booksArrayList;


    public InMemoryBooks(){
        this.booksArrayList= StorageB.getInstance().books;
    }


    @Override
    public void add(Books sourse) {
        booksArrayList.add(sourse);


    }

    @Override
    public Books find(int id) {

        return booksArrayList.stream()
                .filter(b -> id==(b.getId()))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void delit(Books sourse) {
        booksArrayList.removeIf(box -> box.getId()==(sourse.getId()));

    }

    @Override
    public ArrayList<Books> print() {
        return new ArrayList<>(booksArrayList);
    }

    @Override
    public double sold(int id, int kolvo) {
        double price=0;
        Books books=find(id);
        int kolvoPer=books.getKolvo();
        int raz=kolvoPer-kolvo;
        if(raz>0){
            books.setKolvo(raz);
            price=kolvo*books.getPrice();
        }
        if (raz==0){
            price=kolvo* books.getPrice();
            delit(books);


        }
        if(raz<0){
            return 0;
        }
        return price;
    }

    @Override
    public Books update(int id) {
        Scanner scan =new Scanner(System.in);
        Books book=find(id);
        System.out.print("name= ");
        String name=scan.next();

        System.out.print("autor= ");
        String autor=scan.next();
        System.out.print("kolvo= ");
        int kolvo=scan.nextInt();
        System.out.print("price ");
        double price= scan.nextInt();
        book.setName(name);
        book.setAutor(autor);
        book.setKolvo(kolvo);
        book.setPrice(price);


        return book;
    }
}
