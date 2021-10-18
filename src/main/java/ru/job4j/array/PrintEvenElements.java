package ru.job4j.array;

public class PrintEvenElements {
    public int[] printEvenElement(int[] numbers) {
        int evenNums = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 0) {
                evenNums++;
                System.out.println("Текущий элемент массива начиная с последнего: " + numbers[numbers.length - 1 - i]);
            }
        }
        int[] numbers1 = new int[evenNums];
        int index = 0;
        for (int i = numbers.length - 1; i > 0; i--) {
            if (numbers[i] % 2 == 0) {
                numbers1[index] = numbers[i];
                index++;
            }
        }
        return numbers1;
    }
}
