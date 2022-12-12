package com.example.zad;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import static java.lang.Integer.parseInt;

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
    private TableColumn<List, String> autor_colomn;

    @FXML
    private Button buttom_apdate_newspaper;

    @FXML
    private Button button_add;

    @FXML
    private Button button_print;

    @FXML
    private TextField id;

    @FXML
    private TableColumn<List, Integer> id_colomn;

    @FXML
    private TextField name;

    @FXML
    private TextField name2;

    @FXML
    private TableColumn<List, String> name_colomn;

    @FXML
    private TextField price2;

    @FXML
    private TextField price;

    @FXML
    private TableColumn<List, Double> price_colomn;
    @FXML
    private TableColumn<List,Integer> kolvo_kolomn;
    @FXML
    private TableView table;
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


    Repozitory<Newspaper> repozitory=new SqlNewspaperRepozitory(new DataBaseConnector());
    Repozitory<Books> booksRepozitory=new SqlBooksRepozitory(new DataBaseConnector());
    Repozitory<Magazins>magazinsRepozitory=new SqlMagazinsRepozitory(new DataBaseConnector());
    Servis<Newspaper> newspaperServis=new NewspServis(repozitory);
    Servis<Books> booksServis=new BooksServis(booksRepozitory);
    Servis<Magazins>magazinsServis=new MagazinServis(magazinsRepozitory);








    @FXML




        public void initialize() {

            Newspaper newspaper =new Newspaper(name.getText(),0, Integer.parseInt(price.getText()), Integer.parseInt(add_kolvo_newspaper.getText()),autor.getText());
            newspaperServis.add(newspaper);
        }

         public void update(){

            Newspaper newspaper=new Newspaper(name2.getText(),parseInt(id.getText()), Integer.parseInt(price2.getText()),parseInt(update_newspaper_kolvo.getText()),autor2.getText());
            newspaperServis.update(newspaper);



        }
    public  <T extends Newspaper> ObservableList<T> convert (List<T> tArrayList){
            ObservableList<T> list=FXCollections.observableArrayList(tArrayList);

        return list;

    }
        public void print_table(){
            id_colomn.setCellValueFactory(new PropertyValueFactory<List,Integer>("id"));
            name_colomn.setCellValueFactory(new PropertyValueFactory<List,String>("name"));
            autor_colomn.setCellValueFactory(new PropertyValueFactory<List,String>("autor"));
            price_colomn.setCellValueFactory(new PropertyValueFactory<List,Double>("price"));
            kolvo_kolomn.setCellValueFactory(new PropertyValueFactory<List,Integer>("kolvo"));
            String vibor=chose_box.getValue();
            if(vibor.equals("Газеты")){

                table.setItems(convert(newspaperServis.printAll()));
            }
            if(vibor.equals("Журналы")){
                table.setItems(convert(magazinsServis.printAll()));

            }
            if(vibor.equals("Книги")){
                table.setItems(convert(booksServis.printAll()));
            }



        }
        public void addmagazine(){
            Magazins magazins=new Magazins(add_name_magazine.getText(),0, parseInt(add_price_magazine.getText()),parseInt(add_kolvo_magazine.getText()),add_autor_magazine.getText());
            magazinsServis.add(magazins);

        }
        public void addbooks(){
        Books books=new Books(add_name_books.getText(),0, parseInt(add_price_books.getText()),parseInt(add_kolvo_books.getText()),add_autor_books.getText());
        booksServis.add(books);
        }


        public void chenge_magazine(){
            Magazins magazins =new Magazins(chenge_name_magazine.getText(),parseInt(chenge_id_magazine.getText()), parseInt(chenge_price_magazine.getText()),parseInt(update_magazins_kolvo.getText()),chenge_autor_magazine.getText());
            magazinsServis.update(magazins);
        }
        public void chenge_books(){
            Books books=new Books(chenge_name_books.getText(),parseInt(chenge_id_books.getText()), parseInt(chenge_price_books.getText()), parseInt(update_books_kolvo.getText()),chenge_autor_books.getText());
            booksServis.update(books);

        }
        public void delit_newspaper(){
            newspaperServis.delit(newspaperServis.findItem(Integer.parseInt(delit_id_newspaper.getText())));

        }
        public void delit_magazine(){
            magazinsServis.delit(magazinsServis.findItem( parseInt(delit_id_magazine.getText())));
        }
        public void delit_books(){
            booksServis.delit(booksServis.findItem( parseInt(delit_id_books.getText())));

        }
        public void Sold_newspapers(){
            double priceN=0;
            priceN=newspaperServis.sold(parseInt(sold_newspapers_id.getText()), parseInt(sold_newspapers_kolvo.getText()));
            label_newspaers_price.setText("Цена = "+String.valueOf(priceN));
        }
    public void Sold_magazins(){
        double priceM=0;
        priceM=magazinsServis.sold( parseInt(sold_magazin_id.getText()), parseInt(sold_magazins_kolvo.getText()));
        label_magazins_price.setText("Цена = "+String.valueOf(priceM));
    }
    public void Sold_books(){
            double priceB=0;
            priceB=booksServis.sold(parseInt(sold_bboks_id.getText()), parseInt(sold_books_kolvo.getText()));
            label_books_price.setText("Цена = "+String.valueOf(priceB));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        chose_box.getItems().addAll(choises);
    }

}








