package com.incubyte.coding.task;

public class StringCalculator {

    public int add(String numbers) {

        int sum = 0;
        if (numbers.isEmpty()) {
            return 0;
        }else if(numbers.length() == 1){
            return Integer.parseInt(numbers);
        }
        return sum;
    }
}
