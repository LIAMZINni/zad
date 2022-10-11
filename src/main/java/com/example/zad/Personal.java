package com.example.zad;

public class Personal extends Person{
    private String job;
    private int time;
    private String place;

    public Personal(String name, int age, String job, int time, String place) {
        super(name, age);

        this.job = job;
        this.time = time;
        this.place = place;
    }


    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }



    public String toString() {

        return  "name= "+name+"\n"+
                "age= "+age+"\n"+
                "job='" + job + '\n' +
                ", time=" + time +
                ", place='" + place + '\n'
                ;
    }
}
