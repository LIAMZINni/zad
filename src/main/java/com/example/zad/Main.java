/*1. Газетный киоск занимается продажей газет, журналов и книг.
Необходимо создать приложение, которое бы автоматизировало рабочее место продавца.
Приложение должно позволять производить приемку товара, отмечать факт продажи товара, а также позволять редактировать
неверно введенные данные о товаре. Необходимо предусмотреть возможность хранения нескольких экземпляров одного и того же товара
(например, несколько одинаковых номеров газет)*/
package com.example.zad;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int num=0;
        List list=new List();
        Database db=new Database();




        do {
            System.out.println("1-Добавить товар  2-Вывести список газет 3-Вывести список книг 4-Вывести список журналов " +
                    "5-Продать товары"+" 6-Изменить товар 7-Вывести информацию о персонале 8-Вывести информацию о покупателе 0-Закрыть "+"\n");
            num = in.nextInt();
            if (num == 1) {

                System.out.println(" 1-Газеты 2-Книги 3-Журналы");
                int n=in.nextInt();
                String per=in.nextLine();
                System.out.print("name= ");
                String name=in.nextLine();

                System.out.print("autor= ");
                String autor=in.nextLine();
                System.out.print("pages= ");
                int numberofpages=in.nextInt();
                if (n==1){
                    db.singnewspaper(Const.tablenewspapers,name,autor,numberofpages);

                }
                if(n==2){
                    db.singnewspaper(Const.tablebooks,name,autor,numberofpages);
                }
                if(n==3){
                    db.singnewspaper(Const.tablemagazins,name,autor,numberofpages);
                }

            }
            if(num==2){
                list.printnewspapers();
            }
            if(num==4){
                list.printmagazins();

            }
            if (num==3){
                list.printbooks();

            }

            if(num==5){
                list.solditem();
            }
            if(num==6){
                list.chengenespaper();
            }
            if(num==7){
                list.printpersonal();
            }
            if(num==8){
                list.printbuyer();
            }
            if(num==8){
                list.printbuyer();
            }
            if(num==9){
                db.print(Const.tablenewspapers);
            }
            if(num==10){
                int h=in.nextInt();
                db.delit(Const.tablenewspapers,h);
            }


        }
        while (num!=0);








    }

}
