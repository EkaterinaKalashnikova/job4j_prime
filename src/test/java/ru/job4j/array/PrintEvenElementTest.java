package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

public class PrintEvenElementTest {
    @Test
    public  void whenPrintEvenElement() {
        PrintEvenElement printEvenElements = new PrintEvenElement();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        int[] expected = {15, 13, 11, 9, 7, 5, 3};
        int[] ints = printEvenElements.printEvenElement(numbers);
        Assert.assertThat(ints, is(expected));
    }
}