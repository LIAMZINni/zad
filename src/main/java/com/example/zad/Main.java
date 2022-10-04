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




        do {
            System.out.println("1-Добавить товар  2-Вывести список газет 3-Вывести список книг 4-Вывести список журналов " +
                    "5-Продать товары"+" 6-Изменить товар 0-Закрыть "+"\n");
            num = in.nextInt();
            if (num == 1) {
                list.additem();


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
                list.soldnewspaper();
            }
            if(num==6){
                list.chengenespaper();
            }

        }
        while (num!=0);








    }

}
