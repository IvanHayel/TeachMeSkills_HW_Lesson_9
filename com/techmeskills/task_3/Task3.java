package com.techmeskills.task_3;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You are given a string of arbitrary length with arbitrary words.
 * Find a word with the minimum number of distinct characters.
 * The word can contain letters and numbers.
 * If there are several such words, find the first one.
 * For example, in the line "fffff ab f 1234 jkjk" the word found should be "fffff".
 */

public class Task3 {
    public static void main(String[] args) {
        String text = "Then Minerva said, “Father, son of Saturn, King of kings, " +
                "it served Aegisthus right, and so it would any one else who does as he did; " +
                "but Aegisthus is neither here nor there; it is for Ulysses that my heart bleeds, " +
                "when I think of his sufferings in that lonely sea-girt island, far away, poor man, " +
                "from all his friends.";
        displaySpecialWord(text);

        String example = "fffff ab f 1234 jkjk";
        displaySpecialWord(example);

        String anotherExample = "rrrrrrrrrrrrr ACR oooo aaaaa dddd asdsaf";
        displaySpecialWord(anotherExample);
    }

    private static void displaySpecialWord(String text) {
        LinkedList<String> words = getListOfWords(text);
        words.sort(Comparator.comparingInt(Task3::getQuantityOfDistinctSymbols));
        System.out.println("Special word: " + words.getFirst());
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

    private static int getQuantityOfDistinctSymbols(String word) {
        Set<Character> distinctSymbols = new HashSet<>();
        for (Character symbol : word.toCharArray()) {
            distinctSymbols.add(symbol);
        }
        return distinctSymbols.size();
    }
}