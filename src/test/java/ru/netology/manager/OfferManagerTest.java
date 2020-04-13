package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.domain.OfferComparator;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class OfferManagerTest {

    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);
    OfferComparator comparator = new OfferComparator();

    Offer first = new Offer(1, 1000, "LED", "PRG", 150);
    Offer second = new Offer(2, 2100, "LED", "DME", 65);
    Offer third = new Offer(3, 2300, "LED", "DME", 65);
    Offer fourth = new Offer(4, 3000, "SVO", "JFK", 720);
    Offer fifth = new Offer(5, 4000, "CUN", "VKO", 660);
    Offer sixth = new Offer(6, 3500, "CUN", "VKO", 670);
    Offer seventh = new Offer(7, 2300, "LED", "DME", 64);
    @BeforeEach
    public void setUp() {
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        repository.save(sixth);
        repository.save(seventh);
    }

    @Test
    void shouldFindOffersFromLEDToDMEAndSort() {
        Offer[] expected = new Offer[]{seventh, second, third};
        Offer[] actual = manager.findAll("LED", "DME", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldNotFindNotExistedAirports() {
        Offer[] expected = {};
        Offer[] actual = manager.findAll("CDG", "AMS", comparator);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSingleOffer() {
        Offer[] expected = new Offer[]{fourth};
        Offer[] actual = manager.findAll("SVO", "JFK", comparator);
        assertArrayEquals(expected, actual);
    }
}
