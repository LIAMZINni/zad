package com.example.zad.view;

import com.example.zad.domen.Books;
import com.example.zad.domen.Magazins;
import com.example.zad.domen.Newspaper;
import com.example.zad.servis.Servis;
;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private final Servis<Newspaper> newspaperServis  ;
    private final Servis<Books>booksServis;
    private final Servis<Magazins>magazinsServis;

    public Menu(Servis<Newspaper> newspaperServis, Servis<Books>booksServis, Servis<Magazins> magazinsServis) {
        this.newspaperServis = newspaperServis;
        this.booksServis=booksServis;
        this.magazinsServis = magazinsServis;
    }
    public void menu(){
        Scanner in=new Scanner(System.in);
        System.out.println("1-Добавить товар  2-Вывести информацию о товаре " +
                "3-Продать товары"+" 4-Изменить товар  5-Найти по id 6-Удалить товар 0-Закрыть "+"\n");
        int num = in.nextInt();
        switch (num){
            case 1->additem();
            case 2->printItem();
            case 3->sold();
            case 4->updateItem();
            case 5->find();
            case 6->delit();
            case 0->System.exit(0);
            default -> System.err.println("No command found");
        }
    }


    public void additem() {
        Scanner scan = new Scanner(System.in);
        System.out.println(" 1-Газеты 2-Книги 3-Журналы");
        int num = scan.nextInt();
        System.out.print("name= ");
        String per=scan.nextLine();
        String name = scan.nextLine();
        System.out.print("id= ");
        int id = scan.nextInt();
        System.out.print("autor= ");
        String autor = scan.next();
        System.out.print("kolvo= ");
        int kolvo = scan.nextInt();
        System.out.print("price ");
        double price = scan.nextInt();
        if(num==1){
            Newspaper newspaper = new Newspaper(name, id, price, kolvo, autor);
            newspaperServis.add(newspaper);
    }
        if(num==2){
            Books books = new Books(name, id, price, kolvo, autor);
            booksServis.add(books);
        }
        if(num==3){
            Magazins magazins=new Magazins(name, id, price, kolvo, autor);
            magazinsServis.add(magazins);
        }




    }
    public  <T extends Newspaper > void print (ArrayList<T> tArrayList){
        int i=0;
        for (T o:tArrayList){
            System.out.println("Номер в списке-"+i);
            System.out.println(tArrayList.get(i).tostring());
            i+=1;


        }

    }

    public void printItem(){
        Scanner scan = new Scanner(System.in);
        ArrayList<Newspaper> newspapers= (ArrayList<Newspaper>) newspaperServis.printAll();
        ArrayList<Books> books= (ArrayList<Books>) booksServis.printAll();
        ArrayList<Magazins> magazins=(ArrayList<Magazins>) magazinsServis.printAll();
        System.out.println(" 1-Газеты 2-Книги 3-Журналы");
        int num = scan.nextInt();
        int i=0;
        if(num==1){
        print(newspapers);}
        int g=0;
        if(num==2){
            print(books);

        }
        if(num==3){
            print(magazins);
        }





    }



    public void find(){
        Scanner in=new Scanner(System.in);
        System.out.println(" 1-Газеты 2-Книги 3-Журналы");
        int num = in.nextInt();
        System.out.print("id= ");
        int id  = in.nextInt();
        if(num==1){
            Newspaper newspaper=newspaperServis.findItem(id);
            System.out.println(newspaper.tostring());

        }
        if(num==2){
        Books newspaper=booksServis.findItem(id);
        System.out.println(newspaper.tostring());}
        if(num==3){
            Magazins magazins=magazinsServis.findItem(id);
            System.out.println(magazins.tostring());
        }


    }
    public void sold(){

        Scanner in =new Scanner(System.in);
        System.out.println(" 1-Газеты 2-Книги 3-Журналы");
        int num = in.nextInt();
        System.out.print("id=");
        int id= in.nextInt();
        System.out.print("Количество =");
        int kolvo= in.nextInt();
        if(num==1){
            double price =newspaperServis.sold(id,kolvo);
            System.out.println(price);}
        if(num==2){
            double price =booksServis.sold(id,kolvo);
            System.out.println(price);
        }
        if(num==3){
            double price =magazinsServis.sold(id,kolvo);
            System.out.println(price);

        }
    }
    public <T extends Newspaper> T set(T target){
        Scanner in=new Scanner(System.in);
        System.out.print("name= ");

        String name = in.nextLine();
        System.out.print("autor= ");
        String autor = in.next();
        System.out.print("kolvo= ");
        int kolvo = in.nextInt();
        System.out.print("price ");
        double price=in.nextDouble();
        target.setAutor(autor);
        target.setName(name);
        target.setKolvo(kolvo);
        target.setPrice(price);

        return target;
    }
    public void updateItem(){
        Scanner in=new Scanner(System.in);
        System.out.println(" 1-Газеты 2-Книги 3-Журналы");
        int num = in.nextInt();
        System.out.print("id=");
        int id = in.nextInt();



        if(num==1){
            Newspaper newspaper=newspaperServis.findItem(id);
        newspaperServis.update(set(newspaper));}
        if(num==2){
            Books books=booksServis.findItem(id);
            booksServis.update(set(books));
        }
        if(num==3){
            magazinsServis.update(magazinsServis.findItem(id));
        }


    }
    public void delit(){
        Scanner in =new Scanner(System.in);
        System.out.println(" 1-Газеты 2-Книги 3-Журналы");
        int num = in.nextInt();
        System.out.print("id=");
        int id= in.nextInt();
        if(num==1){
        Newspaper newspaper=newspaperServis.findItem(id);
        newspaperServis.delit(newspaper);}
        if(num==2){
            Books books=booksServis.findItem(id);
            booksServis.delit(books);
        }
        if(num==3){
            Magazins magazins=magazinsServis.findItem(id);
            magazinsServis.delit(magazins);
        }


    }


}
