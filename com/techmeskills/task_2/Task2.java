package com.techmeskills.task_2;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You are given a string of arbitrary length with arbitrary words.
 * Find the shortest word in a string and display it on the screen.
 * Find the longest word in the string and display it.
 * If there are several such words, then output the last of them.
 */

public class Task2 {
    public static void main(String[] args) {
        String text = "Tell me, Muse, of that ingenious hero who travelled far and " +
                "wide after he had sacked the famous town of Troy.";
        System.out.println("Text: " + text);
        displayShortestWord(text);
        displayLongestWord(text);
    }

    private static void displayShortestWord(String text) {
        LinkedList<String> words = getListOfWords(text);
        String shortestWord = words.removeFirst();
        while (!words.isEmpty()) {
            if (shortestWord.length() >= words.getFirst().length()) {
                shortestWord = words.removeFirst();
            } else {
                words.removeFirst();
            }
        }
        System.out.println("Shortest word: " + shortestWord);
    }

    private static void displayLongestWord(String text) {
        LinkedList<String> words = getListOfWords(text);
        String longestWord = words.removeFirst();
        while (!words.isEmpty()) {
            if (longestWord.length() <= words.getFirst().length()) {
                longestWord = words.removeFirst();
            } else {
                words.removeFirst();
            }
        }
        System.out.println("Longest word: " + longestWord);
    }

    private static LinkedList<String> getListOfWords(String text) {
        Pattern pattern = Pattern.compile("\\w+");
        Matcher matcher = pattern.matcher(text);
        LinkedList<String> words = new LinkedList<>();
        while (matcher.find()) {
            words.add(matcher.group());
        }
        return words;
    }
}