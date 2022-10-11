package com.example.zad;
import java.util.Scanner;
import java.util.ArrayList;
public class List {
    private ArrayList<Newspaper> newspaperArrayList = new ArrayList<>();
    private ArrayList<Books> booksArrayList = new ArrayList<>();
    private ArrayList<Magazine> magazineArrayList = new ArrayList<>();
    public void addnewspaper(Newspaper newspaper){
        newspaperArrayList.add(newspaper);
    }
    public void addbooks(Books books){
        booksArrayList.add(books);
    }
    public void addmagazins(Magazine magazine){
        magazineArrayList.add(magazine);
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
        System.out.print("pages= ");
        int numberOfPages=scan.nextInt();

        if(num==1){

            newspaperArrayList.add(new Newspaper(name,id,numberOfPages,autor));
        }
        else if(num==2){
            booksArrayList.add(new Books(name,id,numberOfPages,autor));
        }
        else if(num==3){
            magazineArrayList.add(new Magazine(name,id,numberOfPages,autor));
        }


    }
    public void printnewspapers(){
        for(int i=0; i<newspaperArrayList.size();i++){
            System.out.println("Номер в списке-"+i);
            System.out.println(newspaperArrayList.get(i).tostring());

        }

    }
    public void printbooks(){
        for(int i=0; i<booksArrayList.size();i++){
            System.out.println("Номер в списке-"+i);
            System.out.println(booksArrayList.get(i).tostring());

        }

    }
    public void printmagazins(){
        for(int i=0; i<magazineArrayList.size();i++){
            System.out.println("Номер в списке-"+i);
            System.out.println(magazineArrayList.get(i).tostring());

        }

    }
    ArrayList<Double>Alaasum=new ArrayList<>();
    public void solditem() {
        double priceM=0,priceB=0 ,priceN=0;


        Scanner scan = new Scanner(System.in);
        System.out.print("1-Газеты 2-Книги 3-Журналы");
        int num = scan.nextInt();
        printnewspapers();
        printbooks();
        printmagazins();
        System.out.print("Номер в списке= ");
        int num1 = scan.nextInt();

        if (num == 1) {
            newspaperArrayList.remove(num1);
            System.out.print("price=");
            priceN = scan.nextDouble();

        }
        if (num == 2) {

            booksArrayList.remove(num1);
            System.out.print("price=");
            priceB = scan.nextDouble();

        }

        if (num == 3) {
            magazineArrayList.remove(num1);
            System.out.print("price=");
            priceM = scan.nextDouble();


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
        System.out.print("pages= ");
        int numberOfPages=scan.nextInt();
        if(num==1){
            Newspaper newspaper=new Newspaper(name,id,numberOfPages,autor);
            newspaperArrayList.set(num1,newspaper);
        }
        if (num==2){
            Books books=new Books(name,id,numberOfPages,autor);
            booksArrayList.set(num1,books);
        }
        if(num==3){
            Magazine magazine=new Magazine(name,id,numberOfPages,autor);
            magazineArrayList.set(num1,magazine);
        }


    }



}
