package com.example.zad;
import java.util.Scanner;

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
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 879, 629);
        stage.setTitle("Newsstand!");

        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();










    }
}