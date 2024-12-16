package lab4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Клас Letter представляє окрему літеру тексту.
 */
class Letter {
    private char value;

    public Letter(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public String toLowerCase() {
        return String.valueOf(value).toLowerCase();
    }

    public String toUpperCase() {
        return String.valueOf(value).toUpperCase();
    }
}

/**
 * Клас Word представляє слово як набір літер.
 */
class Word {
    private List<Letter> letters;

    public Word(String word) {
        letters = new ArrayList<>();
        for (char c : word.toCharArray()) {
            letters.add(new Letter(c));
        }
    }

    public List<Letter> getLetters() {
        return letters;
    }

    public String getText() {
        String result = "";
        for (Letter letter : letters) {
            result += letter.getValue();
        }
        return result;
    }

    /**
     * Видаляє всі попередні входження останньої літери у слові.
     */
    public void removePreviousOccurrencesOfLastLetter() {
        if (letters.isEmpty()) return;

        char lastChar = letters.get(letters.size() - 1).getValue();
        String lastCharLower = String.valueOf(lastChar).toLowerCase();

        List<Letter> updatedLetters = new ArrayList<>();
        for (int i = 0; i < letters.size(); i++) {
            Letter current = letters.get(i);
            String currentLower = String.valueOf(current.getValue()).toLowerCase();

            if (!currentLower.equals(lastCharLower) || i == letters.size() - 1) {
                updatedLetters.add(current);
            }
        }

        letters = updatedLetters;
    }
}

/**
 * Клас Sentence представляє речення як набір слів.
 */
class Sentence {
    private List<Word> words;

    public Sentence(String sentence) {
        words = new ArrayList<>();
        String[] splitWords = sentence.split(" ");
        for (String word : splitWords) {
            words.add(new Word(word));
        }
    }

    public List<Word> getWords() {
        return words;
    }

    public String getText() {
        String result = "";
        for (Word word : words) {
            result += word.getText() + " ";
        }
        return result.trim();
    }

    public void processWords() {
        for (Word word : words) {
            word.removePreviousOccurrencesOfLastLetter();
        }
    }
}

/**
 * Клас Text представляє текст як набір речень.
 */
class Text {
    private List<Sentence> sentences;

    public Text(String text) {
        sentences = new ArrayList<>();
        String[] splitSentences = text.split("(?<=[.!?])\s*");
        for (String sentence : splitSentences) {
            sentences.add(new Sentence(sentence));
        }
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public String getText() {
        String result = "";
        for (Sentence sentence : sentences) {
            result += sentence.getText() + " ";
        }
        return result.trim();
    }

    public void processText() {
        for (Sentence sentence : sentences) {
            sentence.processWords();
        }
    }

    public void normalizeWhitespace() {
        for (int i = 0; i < sentences.size(); i++) {
            Sentence sentence = sentences.get(i);
            String normalized = sentence.getText().replaceAll("\\s+", " ");
            sentences.set(i, new Sentence(normalized));
        }
    }
}

/**
 * Головний клас Lab4Task для виконання описаних операцій.
 */
public class Lab4Task {

    public void action() {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.print("Введіть текст: ");
            String inputText = scanner.nextLine();

            // Створення об'єкта Text і обробка
            Text text = new Text(inputText);
            text.normalizeWhitespace();
            text.processText();

            System.out.println("Результат: " + text.getText());
        } catch (Exception e) {
            System.err.println("Виникла помилка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    public static void main(String[] args) {
        Lab4Task task = new Lab4Task();
        task.action();
    }
}