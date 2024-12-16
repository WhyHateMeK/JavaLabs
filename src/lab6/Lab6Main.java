package lab6;

import java.util.*;

/**
 * Клас Lab6Main демонструє використання Lab6Task.
 */
public class Lab6Main {
    public static void main(String[] args) {
        // Створення порожньої колекції
        Lab6Task<String> collection = new Lab6Task<>();

        // Додавання елементів
        collection.add("Яблуко");
        collection.add("Банан");
        collection.add("Апельсин");

        // Спроба додати дублікат
        collection.add("Яблуко"); // Не додасться

        // Виведення колекції
        System.out.println("Колекція: " + collection);

        // Видалення елемента
        collection.remove("Банан");
        System.out.println("Після видалення: " + collection);

        // Перевірка наявності елемента
        System.out.println("Містить Апельсин? " + collection.contains("Апельсин"));

        // Використання конструктора з колекцією
        List<String> list = Arrays.asList("Вишня", "Виноград", "Яблуко");
        Lab6Task<String> newCollection = new Lab6Task<>(list);
        System.out.println("Нова колекція: " + newCollection);
    }
}
