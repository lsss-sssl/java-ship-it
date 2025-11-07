package ru.yandex.practicum.delivery.parcel;

public final class FragileParcel extends Parcel{

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

}
