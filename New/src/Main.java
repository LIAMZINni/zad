
import domen.Books;
import domen.Magazins;
import domen.Newspaper;
import repozitory.DataBase.DataBaseConnector;
import repozitory.DataBase.SqlBooksRepozitory;
import repozitory.DataBase.SqlMagazinsRepozitory;
import repozitory.DataBase.SqlNewspaperRepozitory;
import repozitory.InMemmoryrep.InMemmoryMagazins;
import repozitory.InMemmoryrep.InMemoryBooks;
import repozitory.Repozitory;
import servis.BooksServis;
import servis.MagazinServis;
import servis.NewspServis;
import servis.Servis;
import view.Menu;

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
