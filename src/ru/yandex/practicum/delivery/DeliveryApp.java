package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.parcel.FragileParcel;
import ru.yandex.practicum.delivery.parcel.Parcel;
import ru.yandex.practicum.delivery.parcel.PerishableParcel;
import ru.yandex.practicum.delivery.parcel.StandardParcel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
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
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Выберите тип посылки: 1 - Обычная, 2 - Скоропортящаяся, 3 - Хрупкая.");
        int type = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите описание посылки:");
        String description = scanner.nextLine();
        System.out.println("Укажите вес посылки:");
        int weight = Integer.parseInt(scanner.nextLine());
        System.out.println("Укажите адрес доставки:");
        String deliveryAddress = scanner.nextLine();
        System.out.println("Укажите сегодняшнюю дату:");
        byte sendDay = Byte.parseByte(scanner.nextLine());

        if (type == 1) {
            StandardParcel parcel = new StandardParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
        } else if (type == 2) {
            System.out.println("Укажите срок годности в днях:");
            byte timeToLive = Byte.parseByte(scanner.nextLine());
            PerishableParcel parcel = new PerishableParcel(description, weight, deliveryAddress, sendDay, timeToLive);
            allParcels.add(parcel);
        } else if (type == 3) {
            FragileParcel parcel = new FragileParcel(description, weight, deliveryAddress, sendDay);
            allParcels.add(parcel);
        }

        System.out.println("Посылка: " + allParcels.getLast().toString() + " добавлена,");
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
    }

}

