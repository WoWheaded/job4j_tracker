package ru.job4j.starategy;

public class Square implements Shape {
    @Override
    public String draw() {
        String ln = System.lineSeparator();
        return    " ___" + ln
                + "|   |" + ln
                + " ---" + ln;
    }
}
