package ru.job4j.collection;

import java.util.ArrayList;

public class UsageArrayList {
    public static void main(String[] args) {
        ArrayList<String> user = new ArrayList<>();
        user.add("Petr");
        user.add("Ivan");
        user.add("Stepan");
        for (String users : user) {
            System.out.println(users);
        }
    }
}
