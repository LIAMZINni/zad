package servis;

import domen.Books;
import repozitory.Repozitory;

import java.util.List;

public class BooksServis implements Servis<Books>{
    private final Repozitory<Books> booksRepozitory;

    public BooksServis(Repozitory<Books> booksRepozitory) {
        this.booksRepozitory = booksRepozitory;
    }

    @Override
    public Books findItem(int id) {
        return booksRepozitory.find(id);
    }

    @Override
    public List<Books> printAll() {
        return booksRepozitory.print();
    }

    @Override
    public double sold(int id, int kolvo) {
        return booksRepozitory.sold(id,kolvo);
    }

    @Override
    public Books update(Books books) {
        return booksRepozitory.update(books);
    }

    @Override
    public void add(Books target) {
        booksRepozitory.add(target);

    }

    @Override
    public void delit(Books target) {
        booksRepozitory.delit(target);

    }
}
