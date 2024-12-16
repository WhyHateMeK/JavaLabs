package lab3;

import java.util.*;

/**
 * Клас, який представляє спортивний інвентар.
 * Кожен елемент інвентарю має назву, ціну, вагу, виробника, тип і кількість у наявності.
 */
public class Lab3Task {

    private String name;
    private double price;
    private double weight;
    private String manufacturer;
    private String type;
    private int quantity;

    /**
     * Конструктор для створення елемента спортивного інвентарю.
     *
     * @param name         назва предмету
     * @param price        ціна предмету
     * @param weight       вага предмету у кілограмах
     * @param manufacturer виробник предмету
     * @param type         тип предмету (наприклад, "М'яч", "Ракетка")
     * @param quantity     кількість предметів у наявності
     */
    public Lab3Task(String name, double price, double weight, String manufacturer, String type, int quantity) {
        this.name = name;
        this.price = price;
        this.weight = weight;
        this.manufacturer = manufacturer;
        this.type = type;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return String.format("Назва: %s, ціна: %.2f, вага: %.2f, виробник: %s, тип: %s, кількість: %d",
                name, price, weight, manufacturer, type, quantity);
    }

    public static void main(String[] args) {
        // Створення списку спортивного інвентарю
        List<Lab3Task> inventoryList = new ArrayList<>();
        inventoryList.add(new Lab3Task("Футбольний м'яч", 25.0, 0.45, "Adidas", "М'яч", 20));
        inventoryList.add(new Lab3Task("Тенісна ракетка", 120.0, 0.3, "Wilson", "Ракетка", 15));
        inventoryList.add(new Lab3Task("Баскетбольний м'яч", 30.0, 0.6, "Nike", "М'яч", 10));
        inventoryList.add(new Lab3Task("Хокейна ключка", 90.0, 0.8, "Bauer", "Ключка", 8));
        inventoryList.add(new Lab3Task("Бейсбольна рукавичка", 50.0, 0.7, "Rawlings", "Рукавичка", 12));

        // Загальна інформація про інвентар
        System.out.println("Загальна інформація про інвентар:");
        for (Lab3Task item : inventoryList) {
            System.out.println(item);
        }

        // Сортування за ціною за зростанням
        inventoryList.sort(Comparator.comparingDouble(Lab3Task::getPrice));
        System.out.println("\nВідсортовано за зростанням ціни:");
        for (Lab3Task item : inventoryList) {
            System.out.printf("Назва: %s, ціна: %.2f\n", item.getName(), item.getPrice());
        }

        // Сортування за кількістю за спаданням
        inventoryList.sort(Comparator.comparingInt(Lab3Task::getQuantity).reversed());
        System.out.println("\nВідсортовано за спаданням кількості:");
        for (Lab3Task item : inventoryList) {
            System.out.printf("Назва: %s, кількість: %d\n", item.getName(), item.getQuantity());
        }
    }
}