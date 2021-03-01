package com.incubyte.coding.task;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {StringCalculator.class})
class StringCalculatorTest {

    @Test
    public void addZero() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    void addOne() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    void addTwo() {
        assertEquals(3, StringCalculator.add("1,2"));
    }

    @Test
    void addAnyNumber() {
        assertEquals(15, StringCalculator.add("1,2,5,7"));
        assertEquals(6, StringCalculator.add("1\n2,3"));
        assertEquals(3, StringCalculator.add("//;\n1;2"));
    }

    @Test
    public final void negativeNumber() {
        RuntimeException exception = null;
        try {
            StringCalculator.add("3,-6,15,-18,46,33");
        } catch (RuntimeException e) {
            exception = e;
        }
        assertNotNull(exception);
        assertEquals("negatives not allowed : -6", exception.getMessage());
    }
}