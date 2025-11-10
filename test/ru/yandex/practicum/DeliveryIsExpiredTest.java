package ru.yandex.practicum;

import ru.yandex.practicum.delivery.parcel.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class DeliveryIsExpiredTest {

    @Test
    public void shouldReturnTrueWhenPerishableParcelIsExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("abc", 10, "abc", 1, 10);
        boolean expectedResult = true;
        boolean actualResult = perishableParcel.isExpired(20);
        Assertions.assertEquals(expectedResult, actualResult);
    }
    @Test
    public void shouldReturnFalseWhenPerishableParcelINotExpired() {
        PerishableParcel perishableParcel = new PerishableParcel("abc", 10, "abc", 1, 10);
        boolean expectedResult = false;
        boolean actualResult = perishableParcel.isExpired(5);
        Assertions.assertEquals(expectedResult, actualResult);
    }
}
