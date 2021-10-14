package ru.job4j.array;

public class Square {
    public static int[] calculate(int bound) {
        int[] rst = new int[bound];
        /* заполнить массив через цикл элементами от 1 до bound возведенными в квадрат */
        for (int i = 0; i < rst.length; i++) {
            /* rst[i] = (int) Math.pow(i + 1, 2); */
            rst[i] = i * i;
        }
        return rst;
    }

    public static void main(String[] args) {
        int[] array = calculate(4);
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }
}
