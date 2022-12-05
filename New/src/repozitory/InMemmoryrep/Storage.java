package repozitory.InMemmoryrep;

import domen.Newspaper;

import java.util.ArrayList;

public class Storage {
    private static Storage instanse;


    public static Storage getInstance(){
        if(instanse==null){
            instanse =new Storage();

        }
        return instanse;
    }
    ArrayList<Newspaper> newspapers;


    private Storage(){
        this.newspapers=new ArrayList<>();

    }





}
