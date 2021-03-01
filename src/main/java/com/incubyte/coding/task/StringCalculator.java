package com.incubyte.coding.task;

import java.util.ArrayList;

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
        ArrayList<String> negativeNumbersList = new ArrayList<>();
        for (String arrayOfNumber : arrayOfNumbers) {
            if(Integer.parseInt(arrayOfNumber) < 0){
                negativeNumbersList.add(arrayOfNumber);
            }
            sum += Integer.parseInt(arrayOfNumber);
        }

        if (negativeNumbersList.size() > 0) {
            throw new RuntimeException("Negatives not allowed : " + negativeNumbersList);
        }

        return sum;
    }
}