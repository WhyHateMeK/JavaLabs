package lab5;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Базовий клас Sweet, що представляє загальні властивості солодощів.
 */
class Sweet {
    private String name;
    private int weight; // вага в грамах

    /**
     * Конструктор для створення об'єкта Sweet.
     * @param name назва солодощів
     * @param weight вага солодощів у грамах
     */
    public Sweet(String name, int weight) {
        if (weight <= 0) {
            throw new IllegalArgumentException("Вага повинна бути додатньою.");
        }
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return name + " (" + weight + "г)";
    }
}

/**
 * Клас Candy, що успадковує Sweet, представляє солодощі з вмістом цукру.
 */
class Candy extends Sweet {
    private int sugarContent; // вміст цукру в %

    /**
     * Конструктор для створення об'єкта Candy.
     * @param name назва цукерки
     * @param weight вага цукерки у грамах
     * @param sugarContent вміст цукру у відсотках
     */
    public Candy(String name, int weight, int sugarContent) {
        super(name, weight);
        if (sugarContent < 0 || sugarContent > 100) {
            throw new IllegalArgumentException("Вміст цукру повинен бути в діапазоні від 0 до 100%.");
        }
        this.sugarContent = sugarContent;
    }

    public int getSugarContent() {
        return sugarContent;
    }

    @Override
    public String toString() {
        return super.toString() + ", вміст цукру " + sugarContent + "%";
    }
}

/**
 * Клас ChocolateCandy, що успадковує Candy, представляє шоколадні цукерки.
 */
class ChocolateCandy extends Candy {
    private int chocolateContent; // вміст шоколаду в %

    /**
     * Конструктор для створення об'єкта ChocolateCandy.
     * @param name назва шоколадної цукерки
     * @param weight вага у грамах
     * @param sugarContent вміст цукру у відсотках
     * @param chocolateContent вміст шоколаду у відсотках
     */
    public ChocolateCandy(String name, int weight, int sugarContent, int chocolateContent) {
        super(name, weight, sugarContent);
        if (chocolateContent < 0 || chocolateContent > 100) {
            throw new IllegalArgumentException("Вміст шоколаду повинен бути в діапазоні від 0 до 100%.");
        }
        this.chocolateContent = chocolateContent;
    }

    public int getChocolateContent() {
        return chocolateContent;
    }

    @Override
    public String toString() {
        return super.toString() + ", вміст шоколаду " + chocolateContent + "%";
    }
}

/**
 * Клас Lollipop, що успадковує Candy, представляє льодяники.
 */
class Lollipop extends Candy {
    private String flavor; // смак

    /**
     * Конструктор для створення об'єкта Lollipop.
     * @param name назва льодяника
     * @param weight вага у грамах
     * @param sugarContent вміст цукру у відсотках
     * @param flavor смак льодяника
     */
    public Lollipop(String name, int weight, int sugarContent, String flavor) {
        super(name, weight, sugarContent);
        if (flavor == null || flavor.isEmpty()) {
            throw new IllegalArgumentException("Смак не може бути порожнім.");
        }
        this.flavor = flavor;
    }

    public String getFlavor() {
        return flavor;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + flavor + " смак";
    }
}

/**
 * Клас GummyBear, що успадковує Candy, представляє жувальні ведмедики.
 */
class GummyBear extends Candy {
    private String color; // колір

    /**
     * Конструктор для створення об'єкта GummyBear.
     * @param name назва жувальних ведмедиків
     * @param weight вага у грамах
     * @param sugarContent вміст цукру у відсотках
     * @param color колір ведмедика
     */
    public GummyBear(String name, int weight, int sugarContent, String color) {
        super(name, weight, sugarContent);
        if (color == null || color.isEmpty()) {
            throw new IllegalArgumentException("Колір не може бути порожнім.");
        }
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return super.toString() + ", " + color + " колір";
    }
}

/**
 * Клас Gift для роботи з набором солодощів.
 */
class Gift {
    private List<Sweet> sweets;

    /**
     * Конструктор для створення порожнього подарунку.
     */
    public Gift() {
        this.sweets = new ArrayList<>();
    }

    /**
     * Додає солодощі до подарунку.
     * @param sweet об'єкт солодощів
     */
    public void addCandy(Sweet sweet) {
        if (sweet == null) {
            throw new IllegalArgumentException("Солодощі не можуть бути null.");
        }
        sweets.add(sweet);
    }

    /**
     * Розраховує загальну вагу подарунку.
     * @return загальна вага в грамах
     */
    public int getWeight() {
        return sweets.stream().mapToInt(Sweet::getWeight).sum();
    }

    /**
     * Сортує солодощі у подарунку за вагою.
     * @return список відсортованих солодощів
     */
    public List<Sweet> sortByWeight() {
        sweets.sort(Comparator.comparingInt(Sweet::getWeight));
        return new ArrayList<>(sweets);
    }

    /**
     * Знаходить шоколадні цукерки у заданому діапазоні вмісту шоколаду.
     * @param minContent мінімальний вміст шоколаду у відсотках
     * @param maxContent максимальний вміст шоколаду у відсотках
     * @return список відповідних шоколадних цукерок
     */
    public List<ChocolateCandy> findByChocolateContent(int minContent, int maxContent) {
        if (minContent < 0 || maxContent > 100 || minContent > maxContent) {
            throw new IllegalArgumentException("Неправильний діапазон вмісту шоколаду.");
        }
        List<ChocolateCandy> result = new ArrayList<>();
        for (Sweet sweet : sweets) {
            if (sweet instanceof ChocolateCandy) {
                ChocolateCandy chocolateCandy = (ChocolateCandy) sweet;
                if (chocolateCandy.getChocolateContent() >= minContent && chocolateCandy.getChocolateContent() <= maxContent) {
                    result.add(chocolateCandy);
                }
            }
        }
        return result;
    }
}

/**
 * Lab5Task клас програми для демонстрації функціоналу.
 */
public class Lab5Task {
    public static void main(String[] args) {
        try {
            Gift gift = new Gift();

            ChocolateCandy candy1 = new ChocolateCandy("КітКат", 50, 60, 40);
            Lollipop candy2 = new Lollipop("Чупа Чупс", 20, 80, "полуничний");
            GummyBear candy3 = new GummyBear("Зелені ведмедики Харібо", 30, 70, "зелений");

            // Додавання солодощів до подарунку
            gift.addCandy(candy1);
            gift.addCandy(candy2);
            gift.addCandy(candy3);

            // Виведення загальної ваги подарунку
            System.out.println("Вага подарунку: " + gift.getWeight() + "г");

            // Сортування солодощів за вагою
            System.out.println("Солодощі відсортовані за вагою:");
            for (Sweet sweet : gift.sortByWeight()) {
                System.out.println(sweet);
            }

            // Пошук шоколадних цукерок за вмістом шоколаду
            int minChocolateContent = 30;
            int maxChocolateContent = 50;
            System.out.println("Солодощі зі вмістом шоколаду від " + minChocolateContent + "% до " + maxChocolateContent + "%:");
            for (ChocolateCandy chocolateCandy : gift.findByChocolateContent(minChocolateContent, maxChocolateContent)) {
                System.out.println(chocolateCandy);
            }

        } catch (IllegalArgumentException e) {
            System.out.println("Помилка: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Невідома помилка: " + e.getMessage());
        }
    }
}