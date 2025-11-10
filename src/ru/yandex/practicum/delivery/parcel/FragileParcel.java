package ru.yandex.practicum.delivery.parcel;

public final class FragileParcel extends Parcel implements Trackable{

    private static final int deliveryCostModifier = 4;

    public FragileParcel (String description, int weight, String deliveryAddress, byte sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getDeliveryCostModifier() {
        return deliveryCostModifier;
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка <<<" + getDescription() + ">>> обернута в защитную пленку.");
        super.packageItem();
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка <<" + getDescription() + ">> изменила местоположение на " + newLocation);
    }

    @Override
    public String toString() {
        return "FragileParcel{" +
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
