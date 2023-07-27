package ru.job4j.poly;

public class Bus implements Transport {

    @Override
    public void run() {
        System.out.println("Автобус едет");
    }

    @Override
    public void seatPassengers(int passengers) {
        System.out.println("Загрузил " + passengers + " пассажиров");
    }

    @Override
    public int refill(int oil) {
        return oil * 45;
    }
}
