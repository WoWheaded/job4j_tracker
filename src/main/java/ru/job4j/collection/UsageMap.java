package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("a@ya.ru", "Dmitry Ar");
        map.put("b@ya.ru", "Misha Or");
        map.put("c@ya.ru", "Vera Ev");
        map.put("a@ya.ru", "Sveta Ig");
        for (String key : map.keySet()) {
            System.out.println(key + " = " + map.get(key));
        }
    }
}
