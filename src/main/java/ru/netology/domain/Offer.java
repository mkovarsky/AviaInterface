package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Offer implements Comparable<Offer> {

    private int id;
    private int price;
    private String depAirport;
    private String arrAirport;
    private int flightTime;

    @Override
    public int compareTo(Offer o) {
        return price - o.getPrice();
    }
}
