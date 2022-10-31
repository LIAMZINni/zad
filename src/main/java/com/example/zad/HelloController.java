package com.example.zad;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField autor;

    @FXML
    private TextField autor2;

    @FXML
    private Button buttom_apdate_newspaper;

    @FXML
    private Button button_add;

    @FXML
    private Button button_print;

    @FXML
    private TextField id;

    @FXML
    private TextField name;

    @FXML
    private TextField name2;

    @FXML
    private TextField nubresofpages;

    @FXML
    private TextField nubresofpages2;

    @FXML
    private TableView<?> table;

    @FXML


    Database dbhendler= new Database();
        public void initialize() {

            button_add.setOnAction(actionEvent -> {
                dbhendler.singnewspaper(Const.tablenewspapers, autor.getText(), name.getText(), Integer.parseInt(nubresofpages.getText()));
            });
        }

         public void update(){
            buttom_apdate_newspaper.setOnAction(actionEvent -> {
            dbhendler.apeit(Const.tablenewspapers,name2.getText(),autor2.getText(), Integer.parseInt(nubresofpages2.getText()),Integer.parseInt(id.getText()));


        });

        }


    }



