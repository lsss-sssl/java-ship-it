package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import ru.yandex.practicum.delivery.parcel.*;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.parcelBox.ParcelBox;

public class DeliveryParcelBoxTest {

    private StandardParcel standardParcel;
    private PerishableParcel perishableParcel;
    private FragileParcel fragileParcel;

    @BeforeEach
    public void beforeEach() {
        standardParcel = new StandardParcel("abc", 10, "abc", 10);
        perishableParcel = new PerishableParcel("abc", 10, "abc", 10, 1);
        fragileParcel = new FragileParcel("abc", 10, "abc", 10);
    }

    @Test
    public void shouldReturnTrueWhenParcelIsAddedToBox() {
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
        ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(100);
        ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(100);

        boolean expectedResultForStandardParcel = true;
        boolean actualResultForStandardParcel = standardBox.addParcel(standardParcel);
        boolean expectedResultForPerishableParcel = true;
        boolean actualResultForPerishableParcel = perishableBox.addParcel(perishableParcel);
        boolean expectedResultForFragileParcel = true;
        boolean actualResultForFragileParcel = fragileBox.addParcel(fragileParcel);

        Assertions.assertEquals(expectedResultForStandardParcel, actualResultForStandardParcel);
        Assertions.assertEquals(expectedResultForPerishableParcel, actualResultForPerishableParcel);
        Assertions.assertEquals(expectedResultForFragileParcel, actualResultForFragileParcel);
    }

    @Test
    public void shouldReturnFalseWhenParcelIsOverweight() {
        ParcelBox<StandardParcel> standardBox = new ParcelBox<>(1);
        ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(1);
        ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(1);

        boolean expectedResultForStandardParcel = false;
        boolean actualResultForStandardParcel = standardBox.addParcel(standardParcel);
        boolean expectedResultForPerishableParcel = false;
        boolean actualResultForPerishableParcel = perishableBox.addParcel(perishableParcel);
        boolean expectedResultForFragileParcel = false;
        boolean actualResultForFragileParcel = fragileBox.addParcel(fragileParcel);

        Assertions.assertEquals(expectedResultForStandardParcel, actualResultForStandardParcel);
        Assertions.assertEquals(expectedResultForPerishableParcel, actualResultForPerishableParcel);
        Assertions.assertEquals(expectedResultForFragileParcel, actualResultForFragileParcel);
    }
}