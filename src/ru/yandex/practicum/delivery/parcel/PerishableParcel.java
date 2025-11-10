package ru.yandex.practicum.delivery.parcel;

import java.util.Objects;

public class PerishableParcel extends Parcel {

    private static final int DELIVERY_COST_MODIFIER = 3;
    private final int timeToLive;

    public PerishableParcel (String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    public int getDeliveryCostModifier() {
        return DELIVERY_COST_MODIFIER;
    }

    public boolean isExpired(int currentDay) {
        return getSendDay() + timeToLive < currentDay;
    }

    @Override
    public String toString() {
        return "PerishableParcel{" +
                "description='" + getDescription() + '\'' +
                ", weight=" + getWeight() +
                ", deliveryAddress='" + getDeliveryAddress() + '\'' +
                ", sendDay=" + getSendDay() + '\'' +
                ", deliveryCostModifier=" + DELIVERY_COST_MODIFIER + '\'' +
                ", timeToLive=" + timeToLive + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        PerishableParcel that = (PerishableParcel) o;
        return timeToLive == that.timeToLive;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timeToLive);
    }
}
