package repozitory.InMemmoryrep;

import domen.Books;

import java.util.ArrayList;

public class StorageB {
    private static StorageB instanse;
    public ArrayList<Books> books;

    public static StorageB getInstance(){
        if(instanse==null){
            instanse =new StorageB();

        }
        return instanse;
    }



    private StorageB(){
        this.books=new ArrayList<>();

    }
}
