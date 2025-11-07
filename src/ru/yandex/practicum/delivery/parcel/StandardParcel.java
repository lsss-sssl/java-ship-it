package ru.yandex.practicum.delivery.parcel;

public final class StandardParcel extends Parcel {

    private static final int deliveryCostModifier = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, byte sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getDeliveryCostModifier() {
        return deliveryCostModifier;
    }


}
