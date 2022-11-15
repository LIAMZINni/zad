package com.example.zad;
import java.util.Scanner;
import java.util.ArrayList;
public class List {
    private ArrayList<Newspaper> newspaperArrayList = new ArrayList<>();

    private ArrayList<Books> booksArrayList = new ArrayList<>();
    private ArrayList<Magazine> magazineArrayList = new ArrayList<>();
    private ArrayList<Personal> personalArrayList=new ArrayList<>();
    private ArrayList<Buyer> buyerArrayList=new ArrayList<>();
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
    public void addpersonal(){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите имя ");
        String name=in.next();
        System.out.println("Возраст ");
        int age=in.nextInt();
        System.out.println("Должность ");
        String job=in.next();
        System.out.println("Время разгрузки ");
        int time=in.nextInt();
        System.out.println("Место разгрузки ");
        String place=in.next();
        System.out.println("\n");
        personalArrayList.add(new Personal(name,age,job,time,place));


    }
    public void printpersonal(){
        for(int i=0;i<personalArrayList.size();i++){
            System.out.println(personalArrayList.get(i).toString());

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
        System.out.print("price ");
        double price= scan.nextInt();


        if(num==1){

            newspaperArrayList.add(new Newspaper( name,  id, price,  autor));



        }
        else if(num==2){
            booksArrayList.add(new Books(name,id,price,autor));
        }
        else if(num==3){
            magazineArrayList.add(new Magazine(name,id,price,autor));
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
    public void addbuyer(){
        Scanner in=new Scanner(System.in);
        System.out.println("Введите имя ");
        String name=in.next();
        System.out.println("Возраст ");
        int age=in.nextInt();
        int bonus=0;

        Buyer pok=new Buyer (name,age,bonus);


        buyerArrayList.add(pok);



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
        addbuyer();
        System.out.print("Номер в списке= ");
        int num1 = scan.nextInt();

        if (num == 1) {
            Newspaper newspaper = newspaperArrayList.get(num1);
            newspaperArrayList.remove(num1);
            priceN=newspaper.getPrice();

        }
        if (num == 2) {
            Books books=booksArrayList.get(num1);
            booksArrayList.remove(num1);
            priceB = books.getPrice();

        }

        if (num == 3) {
            Magazine magazine=magazineArrayList.get(num1);
            magazineArrayList.remove(num1);
            priceM =magazine.getPrice();


        }



        double sum = priceM+priceB+priceN;
        Alaasum.add(sum);
        double finalsum=0;
        for (double n:Alaasum){
            finalsum+=n;

        }


        System.out.println("Общая сумма ="+finalsum);

    }
    public void printbuyer(){
        for (int i=0;i<buyerArrayList.size();i++){
            System.out.println(buyerArrayList.get(i).toString());

        }
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
        System.out.print("price");
        double price=scan.nextInt();
        if(num==1){
            Newspaper newspaper=new Newspaper(name,  id, price,  autor);
            newspaperArrayList.set(num1,newspaper);
        }
        if (num==2){
            Books books=new Books(name,id,price,autor);
            booksArrayList.set(num1,books);
        }
        if(num==3){
            Magazine magazine=new Magazine(name,id,price,autor);
            magazineArrayList.set(num1,magazine);
        }


    }




}
