package ru.yandex.practicum.delivery;

public abstract class Parcel {
    private final String description;
    private final int weight;
    private final String deliveryAddress;
    private final byte sendDay;

    public Parcel (String description, int weight, String deliveryAddress, byte sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }



    protected void packageItem() {
        System.out.println("Посылка <<<" + description + ">>> упакована.");
    }

    protected void deliver() {
        System.out.println("Посылка <<<" + description + ">>> доставлена по адресу: " + deliveryAddress + ".");
    }

    protected abstract int getDeliveryCostModifier();

    protected int calculateDeliveryCost() {
        return weight * getDeliveryCostModifier();
    }

    public String getDescription() {
        return description;
    }
}
