package ru.yandex.practicum.delivery.parcel;

import java.util.Objects;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final int sendDay;

    public Parcel (String description, int weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }



    public void packageItem() {
        System.out.println("Посылка <<<" + description + ">>> упакована.");
    }

    public void deliver() {
        System.out.println("Посылка <<<" + description + ">>> доставлена по адресу: " + deliveryAddress + ".");
    }

    protected abstract int getDeliveryCostModifier();

    public int calculateDeliveryCost() {
        return weight * getDeliveryCostModifier();
    }

    public String getDescription() {
        return description;
    }

    public int getSendDay() {
        return sendDay;
    }

    public int getWeight() {
        return weight;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Parcel parcel = (Parcel) o;
        return getWeight() == parcel.getWeight() &&
                getSendDay() == parcel.getSendDay() &&
                Objects.equals(getDescription(), parcel.getDescription()) &&
                Objects.equals(deliveryAddress, parcel.deliveryAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getDescription(), getWeight(), deliveryAddress, getSendDay());
    }
}
