package com.example.zad;

public class Person {
    protected String name;
    protected int age;
    public Person(String name, int age){
        this.age= this.age;
        this.name= this.name;
    }
    public void setName(){
        this.name=name;

    }
    public String getName(){
        return name;
    }
    public void setAge(){
        this.age=age;
    }
    public int getAge(){
        return age;
    }


    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
