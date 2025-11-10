package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.parcel.*;
import ru.yandex.practicum.delivery.parcelBox.ParcelBox;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<Trackable> trackableParcels = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standardBox = new ParcelBox<>(100);
    private static final ParcelBox<PerishableParcel> perishableBox = new ParcelBox<>(60);
    private static final ParcelBox<FragileParcel> fragileBox = new ParcelBox<>(80);


    public static void main(String[] args) {
        while (true) {
            showMenu();
            int command = Integer.parseInt(scanner.nextLine());
            switch (command) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    showParcelsByType();
                    break;
                case 5:
                    showTrackable();
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 - Показать содержимое коробки");
        System.out.println("5 - Проверить статус отправлений поддерживающих трекинг.");
        System.out.println("0 — Завершить");
    }

    private static void addParcel() {
        System.out.println("Выберите тип посылки: 1 - Обычная, 2 - Скоропортящаяся, 3 - Хрупкая.");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Укажите вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите адрес доставки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Укажите дату отправки:");
        byte sendDay = Byte.parseByte(scanner.nextLine());

        if (type == 1) {
            StandardParcel parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            if (standardBox.addParcel(parcel)) allParcels.add(parcel);
        } else if (type == 2) {
            System.out.println("Укажите срок годности в днях:");
            byte timeToLive = Byte.parseByte(scanner.nextLine());
            PerishableParcel parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            if (perishableBox.addParcel(parcel)) allParcels.add(parcel);
        } else if (type == 3) {
            FragileParcel parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            if (fragileBox.addParcel(parcel)) {
                allParcels.add(parcel);
                trackableParcels.add(parcel);
            }
        }
    }

    private static void sendParcels() {
        if (allParcels.isEmpty()) {
            System.out.println("Список отправлений пуст");
        } else {
            for (Parcel parcel : allParcels) {
                parcel.packageItem();
                if (parcel instanceof StandardParcel || parcel instanceof FragileParcel) {
                    parcel.deliver();
                } else {
                    System.out.println("Введите дату получения посылки:");
                    if (((PerishableParcel) parcel).isExpired(Integer.parseInt(scanner.nextLine()))) {
                        parcel.deliver();
                    } else {
                        System.out.println("Посылка прибыла с опозданием - содержимое испорчено.");
                    }
                }

            }
        }
    }

    private static void calculateCosts() {
        int totalCost = 0;
        for(Parcel parcel : allParcels) {
            totalCost += parcel.calculateDeliveryCost();
        }
        System.out.println("Общая стоимость всех отправленных посылок составляет: " + totalCost);
    }

    private static void showParcelsByType() {
        System.out.println("Выберите тип посылки: 1 - Обычная, 2 - Скоропортящаяся, 3 - Хрупкая.");
        int type = Integer.parseInt(scanner.nextLine());

        switch (type) {
            case 1 -> {
                if (standardBox.isEmpty()) {
                    System.out.println("Коробка Стандартных отправлений пуста");
                    return;
                }
                List<StandardParcel> parcels = standardBox.getAllParcels();
                for (Parcel parcel : parcels) {
                    System.out.println(parcel.toString());
                }
            }
            case 2 -> {
                if (perishableBox.isEmpty()) {
                    System.out.println("Коробка Скоропортящихся отправлений пуста");
                    return;
                }
                List<PerishableParcel> parcels = perishableBox.getAllParcels();
                for (Parcel parcel : parcels) {
                    System.out.println(parcel.toString());
                }
            }
            case 3 -> {
                if (fragileBox.isEmpty()) {
                    System.out.println("Коробка Хрупких отправлений пуста");
                    return;
                }
                List<FragileParcel> parcels = fragileBox.getAllParcels();
                for (Parcel parcel : parcels) {
                    System.out.println(parcel.toString());
                }
            }
        }
    }

    private static void showTrackable() {
        if (trackableParcels.isEmpty()) {
            System.out.println("Список отправлений с поддержкой трекинга пуст");
            return;
        }
        for (Trackable parcel : trackableParcels) {
            System.out.println("Введите новую локацию.");
            parcel.reportStatus(scanner.nextLine());
        }
    }
}

