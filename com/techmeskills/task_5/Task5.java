package com.techmeskills.task_5;

/**
 * An arbitrary string is given.
 * Print to the console a new line, which duplicates each letter from the initial line.
 * For example, "Hello" -> "HHeelllloo"
 */

public class Task5 {
    public static void main(String[] args) {
        String text = "Some text";
        System.out.println("Text: " + text);
        String textWithRepeatedLetters = getTextWithRepeatedLetters(text);
        System.out.println("Text with repeated letters: " + textWithRepeatedLetters);
    }

    private static String getTextWithRepeatedLetters(String text) {
        StringBuilder newText = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                newText.append(character);
                newText.append(character);
            } else {
                newText.append(character);
            }
        }
        return newText.toString();
    }
}