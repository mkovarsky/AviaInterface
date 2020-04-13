package ru.netology.repository;

import ru.netology.domain.Offer;

public class OfferRepository {

    private Offer[] offers = new Offer[0];

    public void save(Offer offer) {
        int length = offers.length + 1;
        Offer[] tmp = new Offer[length];
        System.arraycopy(offers, 0, tmp, 0, offers.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = offer;
        offers = tmp;
    }

    public Offer[] getAll() {
        return offers;
    }
}
