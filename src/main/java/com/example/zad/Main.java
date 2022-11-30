/*1. Газетный киоск занимается продажей газет, журналов и книг.
Необходимо создать приложение, которое бы автоматизировало рабочее место продавца.
Приложение должно позволять производить приемку товара, отмечать факт продажи товара, а также позволять редактировать
неверно введенные данные о товаре. Необходимо предусмотреть возможность хранения нескольких экземпляров одного и того же товара
(например, несколько одинаковых номеров газет)*/
package com.example.zad;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner in=new Scanner(System.in);
        int num=0;

        InMemmory list =new InMemmory();

        Database db=new Database();




        do {
            System.out.println("1-Добавить товар  2-Вывести информацию о товаре " +
                    "3-Продать товары"+" 4-Изменить товар  5-Найти по id 0-Закрыть "+"\n");
            num = in.nextInt();
            switch (num){
                case 1->list.additem();
                case 2->list.printitems();
                case 3->list.solditem();
                case 4->list.chengenespaper();
                case 5->list.findbyid();
                default -> System.err.println("No command found");

            }



        }
        while (num!=0);








    }

}
