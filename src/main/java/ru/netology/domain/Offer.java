package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Offer implements Comparable<Offer> {

    int id;
    int price;
    public String depAirport;
    public String arrAirport;
    int flightTime;

    @Override
    public int compareTo(Offer o) {
        return price - o.getPrice();
    }
}
