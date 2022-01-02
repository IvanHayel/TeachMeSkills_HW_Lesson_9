package com.techmeskills.task_1;

public class DocumentNumberView {
    public static void displayDigitBlocks(String documentNumber) {
        if (!isDocumentNumber(documentNumber)) {
            throw new IllegalArgumentException("Invalid document number.");
        }
        String[] blocks = documentNumber.split("-");
        System.out.println("First digit block: " + blocks[0]);
        System.out.println("Second digit block: " + blocks[2]);
    }

    public static void displayDocumentNumberSafely(String documentNumber) {
        if (!isDocumentNumber(documentNumber)) {
            throw new IllegalArgumentException("Invalid document number.");
        }
        String secureDocumentNumber = documentNumber.replaceAll("[A-Za-z]{3}", "***");
        System.out.println("Document number: " + secureDocumentNumber);
    }

    public static void displayDocumentLetters(String documentNumber) {
        if (!isDocumentNumber(documentNumber)) {
            throw new IllegalArgumentException("Invalid document number.");
        }
        StringBuilder builder = new StringBuilder();
        String[] blocks = documentNumber.split("-");
        builder.append(blocks[1].toLowerCase() + '/' + blocks[3].toLowerCase() + '/');
        builder.append(blocks[4].toLowerCase().charAt(1) + "/" + blocks[4].toLowerCase().charAt(3));
        System.out.println(builder);
    }

    public static void displayDocumentLetters(String documentNumber, boolean toUpperCase) {
        if (!isDocumentNumber(documentNumber)) {
            throw new IllegalArgumentException("Invalid document number.");
        }
        if (toUpperCase) {
            StringBuilder builder = new StringBuilder();
            String[] blocks = documentNumber.split("-");
            builder.append("Letters: ");
            builder.append(blocks[1].toUpperCase() + '/' + blocks[3].toUpperCase() + '/');
            builder.append(blocks[4].toUpperCase().charAt(1) + "/" + blocks[4].toUpperCase().charAt(3));
            System.out.println(builder);
        } else {
            displayDocumentLetters(documentNumber);
        }
    }

    public static void searchSequence(String documentNumber, String sequence) {
        if (!isDocumentNumber(documentNumber)) {
            throw new IllegalArgumentException("Invalid document number.");
        }
        if (documentNumber.toLowerCase().contains(sequence)) {
            System.out.println("Document number contains this sequence: " + sequence);
        } else {
            System.out.println("Document number doesn't contain this sequence: " + sequence);
        }
    }

    public static void checkStartSequence(String documentNumber, String startSequence) {
        if (!isDocumentNumber(documentNumber)) {
            throw new IllegalArgumentException("Invalid document number.");
        }
        if (documentNumber.startsWith(startSequence)) {
            System.out.println("Document number starts with this sequence: " + startSequence);
        } else {
            System.out.println("Document number doesn't start with this sequence: " + startSequence);
        }
    }

    public static void checkEndSequence(String documentNumber, String endSequence) {
        if (!isDocumentNumber(documentNumber)) {
            throw new IllegalArgumentException("Invalid document number.");
        }
        if (documentNumber.endsWith(endSequence)) {
            System.out.println("Document number ends with this sequence: " + endSequence);
        } else {
            System.out.println("Document number doesn't end with this sequence: " + endSequence);
        }
    }

    public static boolean isDocumentNumber(String documentNumber) {
        return documentNumber.matches("\\d{4}-[A-Za-z]{3}-\\d{4}-[A-Za-z]{3}-\\d[A-Za-z]\\d[A-Za-z]");
    }
}