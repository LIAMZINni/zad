package com.example.zad;
import java.util.Scanner;
import java.util.ArrayList;
public class InMemmory {
    private ArrayList<Newspaper> newspaperArrayList = new ArrayList<>();

    private ArrayList<Books> booksArrayList = new ArrayList<>();
    private ArrayList<Magazine> magazineArrayList = new ArrayList<>();
    private ArrayList<Newspaper> per;


    public void addnewspaper(Newspaper newspaper){
        newspaperArrayList.add(newspaper);
    }
    public void addbooks(Books books){
        booksArrayList.add(books);
    }
    public void addmagazins(Magazine magazine){
        magazineArrayList.add(magazine);
    }
    Database database = new Database();


    public <T extends Newspaper> void add(T sourse){
        String klass = String.valueOf(sourse.getClass());
        System.out.println(klass);
        Scanner in =new Scanner(System.in);



        int num=in.nextInt();
        switch (num){
            case 1->newspaperArrayList.add(sourse);
            case 2->booksArrayList.add((Books) sourse);
            case 3->magazineArrayList.add((Magazine) sourse);

        }




    }

    public  void additem(){
        Scanner scan=new Scanner(System.in);
        System.out.println(" 1-Газеты 2-Книги 3-Журналы");
        int num=scan.nextInt();
        System.out.print("name= ");
        String name=scan.next();
        System.out.print("id= ");
        int id=scan.nextInt();
        System.out.print("autor= ");
        String autor=scan.next();
        System.out.print("kolvo= ");
        int kolvo=scan.nextInt();
        System.out.print("price ");
        double price= scan.nextInt();


        if(num==1){

            newspaperArrayList.add(new Newspaper( name,  id, price,kolvo, autor));



        }
        else if(num==2){
            booksArrayList.add(new Books(name,id,price,kolvo,autor));
        }
        else if(num==3){
            magazineArrayList.add(new Magazine(name,id,price,kolvo,autor));
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
    public void printitems(){
        Scanner in =new Scanner(System.in);
        System.out.print("1-Газеты 2-Книги 3-Журналы");
        int num = in.nextInt();
        if(num==1){
            print(newspaperArrayList);
        }
        if(num==2){
            print(booksArrayList);
        }
        if(num==3){
            print(magazineArrayList);
        }
    }






    ArrayList<Double>Alaasum=new ArrayList<>();

    public void solditem() {
        double priceM=0,priceB=0 ,priceN=0;


        Scanner scan = new Scanner(System.in);
        System.out.print("1-Газеты 2-Книги 3-Журналы");
        int num = scan.nextInt();


        System.out.print("Номер в списке= ");
        int num1 = scan.nextInt();


        if (num == 1) {
            try{

            Newspaper newspaper = newspaperArrayList.get(num1);

            int kolvoN=exseption(newspaper);
            if (newspaper.getKolvo()==0){
                newspaperArrayList.remove(num1);
            }
            priceN=kolvoN*newspaper.getPrice();
            }
            catch (IndexOutOfBoundsException e){
                System.err.println("Такой газеты  нет");

            }

        }
        if (num == 2) {
            try{
            Books books=booksArrayList.get(num1);
            int kolvoB=exseption(books);
            if(books.getKolvo()==0){
                booksArrayList.remove(num1);}
            priceB = kolvoB*books.getPrice();
            }
            catch (IndexOutOfBoundsException e){
                System.err.println("Такой книги нет");
            }

        }

        if (num == 3) {
            try{
            Magazine magazine=magazineArrayList.get(num1);
            int kolvoM=exseption(magazine);
            if(magazine.getKolvo()==0){
                magazineArrayList.remove(num1);}
            priceM =kolvoM*magazine.getPrice();}
            catch (IndexOutOfBoundsException e){
                System.err.println("Такого журнала нет");
            }


        }



        double sum = priceM+priceB+priceN;
        Alaasum.add(sum);
        double finalsum=0;
        for (double n:Alaasum){
            finalsum+=n;

        }


        System.out.println("Общая сумма ="+finalsum);

    }


    public void chengenespaper(){
        Scanner scan=new Scanner(System.in);
        System.out.print("1-Газеты 2-Книги 3-Журналы");
        int num = scan.nextInt();
        System.out.print("Номер в списке= ");
        int num1=scan.nextInt();
        System.out.print("name= ");
        String name=scan.next();
        System.out.print("id= ");
        int id=scan.nextInt();
        System.out.print("autor= ");
        String autor=scan.next();
        int kolvo=scan.nextInt();
        System.out.print("price");
        double price=scan.nextInt();
        if(num==1){
            Newspaper newspaper=new Newspaper(name,  id, price,kolvo,  autor);
            newspaperArrayList.set(num1,newspaper);
        }
        if (num==2){
            Books books=new Books(name,id,price,kolvo,autor);
            booksArrayList.set(num1,books);
        }
        if(num==3){
            Magazine magazine=new Magazine(name,id,price,kolvo,autor);
            magazineArrayList.set(num1,magazine);
        }


    }
    public void findbyid(){
        Scanner in= new Scanner(System.in);
        System.out.print("1-Газеты 2-Книги 3-Журналы");
        int num=in.nextInt();
        System.out.print("id= ");
        int id=in.nextInt();
        if(num==1){
            Newspaper newspaper =find(newspaperArrayList,id);
            System.out.println(newspaper.tostring());
        }
        if(num==2){
            Magazine magazine =find(magazineArrayList,id);
            System.out.println(magazine.tostring());
        }
        if(num==3){
            Books books =find(booksArrayList,id);
            System.out.println(books.tostring());
        }
    }

    public <T extends Newspaper> int exseption(T t){
        Scanner in =new Scanner(System.in);
        System.out.print("Сколько штук ");
        int kolvo=in.nextInt();
        int kolvo_per=t.getKolvo();
        int raz=kolvo_per-kolvo;


        if(raz>=0){
            t.setKolvo(raz);
            return kolvo;

        }
        else {
            System.out.println("Недостаточно предметов ");
            return 0;

        }

    }
    public <T extends Newspaper> T find (ArrayList<T>rere ,int id){
        for (T t: rere){
            if(id==t.getId()){
                return t;


            }

        }
        return null;
    }





}
