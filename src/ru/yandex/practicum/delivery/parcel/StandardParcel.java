package ru.yandex.practicum.delivery.parcel;

public class StandardParcel extends Parcel {

    private static final int deliveryCostModifier = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getDeliveryCostModifier() {
        return deliveryCostModifier;
    }

    @Override
    public String toString() {
        return "StandardParcel{" +
                "description='" + getDescription() + '\'' +
                ", weight=" + getWeight() +
                ", deliveryAddress='" + getDeliveryAddress() + '\'' +
                ", sendDay=" + getSendDay() + '\'' +
                ", deliveryCostModifier=" + deliveryCostModifier + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
