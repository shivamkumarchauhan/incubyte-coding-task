package com.incubyte.coding.task;

public class StringCalculator {

    public static int add(String numbers) {

        if (numbers.isEmpty()) {
            return 0;
        } else if (numbers.length() == 1) {
            return Integer.parseInt(numbers);
        } else if (numbers.length() == 3) {
            return Integer.parseInt(String.valueOf(numbers.charAt(0))) + Integer.parseInt(String.valueOf(numbers.charAt(2)));
        } else {
            if (numbers.contains("\n")) {
                numbers = numbers.replace("\n", ",");
            }
            String del = ",";
            System.out.println(numbers);
            String newNumber = numbers;
            if (numbers.startsWith("//")) {
                del = ";";
                numbers = numbers.replaceAll(",", "");
                int delIndex = numbers.indexOf("//") + 2;
                newNumber = numbers.substring(delIndex + 1);
            }
            return add(newNumber, del);
        }
    }

    public static int add(String numbers, String del) {

        int sum = 0;
        String[] arrayOfNumbers = numbers.split(del);
        for (String arrayOfNumber : arrayOfNumbers) {
            sum += Integer.parseInt(arrayOfNumber);
        }

        return sum;
    }
}