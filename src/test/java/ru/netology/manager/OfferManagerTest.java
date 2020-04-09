package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Offer;
import ru.netology.repository.OfferRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ManagerTest {
    OfferRepository repository = new OfferRepository();
    OfferManager manager = new OfferManager(repository);

    @Test
    void shouldFindOffersFromLEDToDME() {
        Offer[] expected = {new Offer(3, 2100, "LED", "DME", 65),
                new Offer(2, 2300, "LED", "DME", 65),
        };
        Offer[] actual = manager.findAll("LED", "DME");
        assertArrayEquals(expected, actual);
    }
}
