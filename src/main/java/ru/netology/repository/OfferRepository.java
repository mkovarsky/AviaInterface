package ru.netology.repository;

import lombok.Data;
import ru.netology.domain.Offer;

@Data
public class OfferRepository {

    Offer[] offers = {
            new Offer(1, 1000, "LED", "PRG", 150),
            new Offer(2, 2300, "LED", "DME", 65),
            new Offer(3, 2100, "LED", "DME", 65),
            new Offer(4, 3000, "SVO", "JFK", 720),
            new Offer(5, 4000, "CUN", "VKO", 660),
            new Offer(6, 3500, "CUN", "VKO", 670),
    };

    public Offer[] getAll() {
        return offers;
    }
}
