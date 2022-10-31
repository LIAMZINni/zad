package com.example.zad;

public class Newspaper {
    private String autor;
    private String name;
    private int id;
    private int nubberOfPage;

    public Newspaper(String name, int id, int nubberOfPage,String autor) {
        this.name = name;
        this.id = id;
        this.nubberOfPage = nubberOfPage;
        this.autor=autor;
    }




    public void setId(int newid){
        this.id=id;
    }
    public int getId() {
        return id;
    }
    public void setName(String newname){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setNubberOfPage(int newnumbers){
        this.nubberOfPage=nubberOfPage;
    }
    public int getNubberOfPage(){
        return nubberOfPage;
    }
    public void setAutor(String newautor){
        this.autor=autor;
    }
    public String getAutor(){
        return  autor;
    }


    public String tostring() {
        return "id= "+id+"\n"+
                "name= "+name+"\n"+
                "autor= "+autor+"\n"+
                 "numberofpages= "+nubberOfPage+"\n";

    }
}


