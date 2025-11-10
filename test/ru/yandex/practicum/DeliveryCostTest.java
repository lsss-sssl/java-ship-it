package ru.yandex.practicum;

import ru.yandex.practicum.delivery.parcel.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DeliveryCostTest {

    @Test
    public void shouldReturn20forStandardParcelOf10Kg() {
        StandardParcel standardParcel = new StandardParcel("abc", 10, "abc", 1);
        int expectedResult = 20;
        int actualResult = standardParcel.calculateDeliveryCost();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn30forPerishableParcelOf10Kg() {
        PerishableParcel perishableParcel = new PerishableParcel("abc", 10, "abc", 1, 10);
        int expectedResult = 30;
        int actualResult = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void shouldReturn40forFragileParcelOf10Kg() {
        FragileParcel fragileParcel = new FragileParcel("abc", 10, "abc", 1);
        int expectedResult = 40;
        int actualResult = fragileParcel.calculateDeliveryCost();
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
