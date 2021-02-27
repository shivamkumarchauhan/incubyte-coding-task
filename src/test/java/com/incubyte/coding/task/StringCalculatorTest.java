package com.incubyte.coding.task;

import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StringCalculator.class})
class StringCalculatorTest {

    private static StringCalculator stringCalculator;

    @Test
    public void addZero() {
        stringCalculator = new StringCalculator();
        assertEquals(0, stringCalculator.add(""));
    }

    @Test
    void addOne() {
        stringCalculator = new StringCalculator();
        assertEquals(1, stringCalculator.add("1"));
    }

    @Test
    void addTwo() {
        stringCalculator = new StringCalculator();
        assertEquals(3, stringCalculator.add("1,2"));
    }

    @Test
    void addAnyNumber() {
        stringCalculator = new StringCalculator();
        assertEquals(15, stringCalculator.add("1,2,5,7"));
    }
}