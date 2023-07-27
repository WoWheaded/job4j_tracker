package ru.job4j.poly;

public interface Transport {

    void run();

    void seatPassengers(int passengers);

    int refill(int oil);
}
