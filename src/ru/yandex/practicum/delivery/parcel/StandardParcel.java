package ru.yandex.practicum.delivery.parcel;

public class StandardParcel extends Parcel {

    private static final int DELIVERY_COST_MODIFIER = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getDeliveryCostModifier() {
        return DELIVERY_COST_MODIFIER;
    }

    @Override
    public String toString() {
        return "StandardParcel{" +
                "description='" + getDescription() + '\'' +
                ", weight=" + getWeight() +
                ", deliveryAddress='" + getDeliveryAddress() + '\'' +
                ", sendDay=" + getSendDay() + '\'' +
                ", deliveryCostModifier=" + DELIVERY_COST_MODIFIER + '\'' +
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
