package ru.netology.manager;

import lombok.AllArgsConstructor;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import java.util.Arrays;

@AllArgsConstructor
public class OfferManager {

    OfferRepository repository;

    public Offer[] findAll(String from, String to) {
        Offer[] result = new Offer[0];
        for (Offer offer : repository.getAll()) {
            if (offer.getArrAirport().equals(to) & offer.getDepAirport().equals(from)) {
                Offer[] tmp = new Offer[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = offer;
                result = tmp;
            }
        }
        Arrays.sort(result);
        return result;
    }
}
