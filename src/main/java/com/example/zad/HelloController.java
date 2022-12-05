package com.example.zad;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class HelloController implements Initializable {

    @FXML
    private ResourceBundle resources;


    @FXML
    private Button button_add_magazine;
    @FXML
    private TextField add_autor_magazine;

    @FXML
    private TextField add_name_magazine;

    @FXML
    private TextField add_price_magazine;

    @FXML
    private URL location;

    @FXML
    private TextField autor;

    @FXML
    private TextField autor2;

    @FXML
    private TableColumn<Newspaper, String> autor_colomn;

    @FXML
    private Button buttom_apdate_newspaper;

    @FXML
    private Button button_add;

    @FXML
    private Button button_print;

    @FXML
    private TextField id;

    @FXML
    private TableColumn<Newspaper, Integer> id_colomn;

    @FXML
    private TextField name;

    @FXML
    private TextField name2;

    @FXML
    private TableColumn<Newspaper, String> name_colomn;

    @FXML
    private TextField price2;

    @FXML
    private TextField price;

    @FXML
    private TableColumn<Newspaper, Double> price_colomn;
    @FXML
    private TableColumn<Newspaper,Integer> kolvo_kolomn;
    @FXML
    private TableView<Newspaper> table;
    @FXML
    private Label test_label;
    @FXML
    private TextField add_autor_books;
    @FXML
    private TextField add_name_books;
    @FXML
    private TextField add_price_books;
    @FXML
    private Button buttom_apdate_magazine;
    @FXML
    private TextField chenge_autor_magazine;

    @FXML
    private TextField chenge_id_magazine;

    @FXML
    private TextField chenge_name_magazine;

    @FXML
    private TextField chenge_price_magazine;
    @FXML
    private TextField chenge_autor_books;
    @FXML
    private TextField chenge_id_books;
    @FXML
    private TextField chenge_name_books;
    @FXML
    private TextField chenge_price_books;
    @FXML
    private TextField delit_id_newspaper;
    @FXML
    private TextField delit_id_magazine;
    @FXML TextField delit_id_books;
    @FXML
    TextField add_kolvo_newspaper;
    @FXML
    TextField add_kolvo_magazine;
    @FXML
    TextField add_kolvo_books;
    @FXML
    TextField update_newspaper_kolvo;
    @FXML
    TextField update_magazins_kolvo;
    @FXML
    TextField update_books_kolvo;
    @FXML
    private TextField sold_bboks_id;

    @FXML
    private TextField sold_books_kolvo;

    @FXML
    private TextField sold_magazin_id;

    @FXML
    private TextField sold_magazins_kolvo;

    @FXML
    private TextField sold_newspapers_id;

    @FXML
    private TextField sold_newspapers_kolvo;
    @FXML
    private Label label_books_price;

    @FXML
    private Label label_magazins_price;

    @FXML
    private Label label_newspaers_price;
    @FXML
    private Button button_books_sold;

    @FXML
    private Button button_magazins_sold;

    @FXML
    private Button button_newspapers_sold;


    @FXML
    private ChoiceBox<String> chose_box;
    private String[] choises={"Газеты","Журналы","Книги"};

    @FXML


    Database dbhendler= new Database();
        public void initialize() {

            dbhendler.singnewspaper(Const.tablenewspapers, autor.getText(), name.getText(),Integer.parseInt(add_kolvo_newspaper.getText()), Integer.parseInt(price.getText()));

        }

         public void update(){
            buttom_apdate_newspaper.setOnAction(actionEvent -> {
            dbhendler.updete(Const.tablenewspapers,name2.getText(),autor2.getText(),Integer.parseInt(update_newspaper_kolvo.getText()), Integer.parseInt(price2.getText()),Integer.parseInt(id.getText()));


        });
        }
        public void print_table(){
            id_colomn.setCellValueFactory(new PropertyValueFactory<Newspaper,Integer>("id"));
            name_colomn.setCellValueFactory(new PropertyValueFactory<Newspaper,String>("name"));
            autor_colomn.setCellValueFactory(new PropertyValueFactory<Newspaper,String>("autor"));
            price_colomn.setCellValueFactory(new PropertyValueFactory<Newspaper,Double>("price"));
            kolvo_kolomn.setCellValueFactory(new PropertyValueFactory<Newspaper,Integer>("kolvo"));
            String vibor=chose_box.getValue();
            if(vibor.equals("Газеты")){
            table.setItems(dbhendler.print(Const.tablenewspapers));}
            if(vibor.equals("Журналы")){
                table.setItems(dbhendler.print(Const.tablemagazins));

            }
            if(vibor.equals("Книги")){
                table.setItems(dbhendler.print(Const.tablebooks));
            }



        }
        public void addmagazine(){
            dbhendler.singnewspaper(Const.tablemagazins,add_name_magazine.getText(),add_autor_magazine.getText(),Integer.parseInt(add_kolvo_magazine.getText()),Integer.parseInt(add_price_magazine.getText()));

        }
        public void addbooks(){
            dbhendler.singnewspaper(Const.tablebooks, add_name_books.getText(), add_autor_books.getText(),Integer.parseInt(add_kolvo_books.getText()),Integer.parseInt(add_price_books.getText()));
        }
        public void chenge_magazine(){
            dbhendler.updete(Const.tablemagazins, chenge_name_magazine.getText(),chenge_autor_magazine.getText(),Integer.parseInt(update_magazins_kolvo.getText()),Integer.parseInt(chenge_price_magazine.getText()),Integer.parseInt(chenge_id_magazine.getText()));
        }
        public void chenge_books(){
            dbhendler.updete(Const.tablebooks,chenge_name_books.getText(),chenge_autor_books.getText(),Integer.parseInt(chenge_price_books.getText()),Integer.parseInt(update_books_kolvo.getText()),Integer.parseInt(chenge_id_books.getText()));

        }
        public void delit_newspaper(){
            dbhendler.delit(Const.tablenewspapers,Integer.parseInt(delit_id_newspaper.getText()));

        }
        public void delit_magazine(){
            dbhendler.delit(Const.tablemagazins,Integer.parseInt(delit_id_magazine.getText()));
        }
        public void delit_books(){
            dbhendler.delit(Const.tablebooks,Integer.parseInt(delit_id_books.getText()));

        }
        public void Sold_newspapers(){
            double priceN=0;
            priceN=dbhendler.sold(Const.tablenewspapers,Integer.parseInt(sold_newspapers_id.getText()),Integer.parseInt(sold_newspapers_kolvo.getText()));
            label_newspaers_price.setText("Цена = "+String.valueOf(priceN));
        }
    public void Sold_magazins(){
        double priceM=0;
        priceM=dbhendler.sold(Const.tablemagazins,Integer.parseInt(sold_magazin_id.getText()),Integer.parseInt(sold_magazins_kolvo.getText()));
        label_magazins_price.setText("Цена = "+String.valueOf(priceM));
    }
    public void Sold_books(){
            double priceB=0;
            priceB=dbhendler.sold(Const.tablebooks,Integer.parseInt(sold_bboks_id.getText()),Integer.parseInt(sold_books_kolvo.getText()));
            label_books_price.setText("Цена = "+String.valueOf(priceB));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chose_box.getItems().addAll(choises);
    }
}









