package ru.yandex.practicum.delivery.parcel;

public class PerishableParcel extends Parcel {

    private static final int deliveryCostModifier = 3;
    private final byte timeToLive;

    public PerishableParcel (String description, int weight, String deliveryAddress, byte sendDay, byte timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getDeliveryCostModifier() {
        return deliveryCostModifier;
    }

    public boolean isExpired() {
        return getSendDay() + timeToLive < 0;
    }

}
