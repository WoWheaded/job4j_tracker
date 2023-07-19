package ru.job4j.pojo;

public class Book {

    private String name;

    private int countsPepper;

    public Book(String name, int countsPepper) {
        this.name = name;
        this.countsPepper = countsPepper;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountsPepper() {
        return countsPepper;
    }

    public void setCountsPepper(int countsPepper) {
        this.countsPepper = countsPepper;
    }
}
