package com.techmeskills.task_1;

import static com.techmeskills.task_1.DocumentNumberView.*;

/**
 * Write a program with the following functionality:
 * Enter a string at the input (we will assume that this is the document number).
 * The document number is in the format xxxx-yyy-xxxx-yyy-xyxy, where x is a number and y is a letter.
 * Display in one line the first two blocks of 4 digits
 * Display the document number, but replace blocks of three letters with each letter by)
 * Display only one letter from the document number in yyy / yyy / y / y format in lower case
 * Display letters from the document number in the format "Letters: yyy / yyy / y / y" in uppercase
 * (implement using the StringBuilder class)
 * Check whether the document number contains the abc sequence and whether the message contains or not
 * (moreover, abc and ABC are considered the same sequence).
 * Check if the document number starts with sequential 555.
 * Check whether the end of the document number is 1a2b.
 * All these methods are implemented in a separate class in static methods,
 * which are accepted as input to the input of the input program.
 */

public class Task1 {
    public static void main(String[] args) {
        String firstDocumentNumber = "5554-aBc-1458-SSH-9c9c";
        String secondDocumentNumber = "4444-SSH-8888-SSH-1a2b";
        String notDocumentNumber = "some string";

        System.out.println("First document number: " + firstDocumentNumber);
        testDocumentNumberView(firstDocumentNumber);
        System.out.println();

        System.out.println("Second document number: " + secondDocumentNumber);
        testDocumentNumberView(secondDocumentNumber);
        System.out.println();

        System.out.println("Not document number: " + notDocumentNumber);
        testDocumentNumberView(notDocumentNumber);
    }

    private static void testDocumentNumberView(String documentNumber) {
        try {
            displayDelimiter();
            displayDigitBlocks(documentNumber);
            displayDocumentNumberSafely(documentNumber);
            displayDocumentLetters(documentNumber);
            displayDocumentLetters(documentNumber, true);
            String sequence = "abc";
            searchSequence(documentNumber, sequence);
            String startSequence = "555";
            checkStartSequence(documentNumber, startSequence);
            String endSequence = "1a2b";
            checkEndSequence(documentNumber, endSequence);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        } finally {
            displayDelimiter();
        }
    }

    private static void displayDelimiter() {
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}