package com.example.zad;

import com.example.zad.domen.Books;
import com.example.zad.domen.Magazins;
import com.example.zad.domen.Newspaper;
import com.example.zad.repozitory.DataBase.DataBaseConnector;
import com.example.zad.repozitory.DataBase.SqlBooksRepozitory;
import com.example.zad.repozitory.DataBase.SqlMagazinsRepozitory;
import com.example.zad.repozitory.DataBase.SqlNewspaperRepozitory;
import com.example.zad.repozitory.Repozitory;
import com.example.zad.servis.BooksServis;
import com.example.zad.servis.MagazinServis;
import com.example.zad.servis.NewspServis;
import com.example.zad.servis.Servis;
import com.example.zad.view.Menu;
import javafx.stage.Stage;

public class Main {
    public static void main(String[] args) {
        Repozitory<Newspaper> repozitory=new SqlNewspaperRepozitory(new DataBaseConnector());
        Repozitory<Books> booksRepozitory=new SqlBooksRepozitory(new DataBaseConnector());
        Repozitory<Magazins>magazinsRepozitory=new SqlMagazinsRepozitory(new DataBaseConnector());
        Servis<Newspaper> servis=new NewspServis(repozitory);
        Servis<Books> booksServis=new BooksServis(booksRepozitory);
        Servis<Magazins>magazinsServis=new MagazinServis(magazinsRepozitory);

        Menu menu=new Menu(servis,booksServis,magazinsServis);


        while (true){
            menu.menu();

        }


    }
}
