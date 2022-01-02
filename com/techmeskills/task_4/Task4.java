package com.techmeskills.task_4;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * You are given a string of arbitrary length with arbitrary words.
 * Write a program to check if any selected word in a string is a palindrome.
 * For example, there is a line, the number 3 is entered, so it is necessary
 * to check whether the 3rd word in this line is a palindrome.
 * Provide warning messages in case of error situations: for example, there are 5 words in a line,
 * and the number 500 was passed to the program as input, etc. situations.
 */

public class Task4 {
    public static void main(String[] args) {
        String text = "Madam, I am Adam. Able was I, ere I saw Elba.";
        checkPalindromes(text);
    }

    private static void checkPalindromes(String text) {
        System.out.println("Text to search: " + text);
        LinkedList<String> words = getListOfWords(text);
        System.out.print("Enter the ordinal number of the word: ");
        int ordinalNumber = enterNumber();
        while (ordinalNumber < 1 || ordinalNumber > words.size()) {
            System.out.print("Wrong ordinal number! Try again: ");
            ordinalNumber = enterNumber();
        }
        String word = words.get(ordinalNumber - 1);
        if (isPalindrome(word)) {
            System.out.println('\'' + word + "' is a palindrome!");
        } else {
            System.out.println('\'' + word + "' is not a palindrome!");
        }
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

    private static int enterNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    private static boolean isPalindrome(String word) {
        StringBuilder reverseWord = new StringBuilder(word.toLowerCase());
        reverseWord.reverse();
        return word.toLowerCase().equals(reverseWord.toString());
    }
}