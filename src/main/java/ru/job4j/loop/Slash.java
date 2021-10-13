package ru.job4j.loop;

public class Slash {
    public static void draw(int size) {
        for (int row = 0; row < size; row++) {
            for (int cell = 0; cell < size; cell++) {
                boolean left = false; /* добавить условие, по которому нужно определить ставить ли символ или нет. */
                boolean right = false; /* добавить условие, что нужно ставить элемент в правый угол. */
                if (row == cell) {
                    left = true;
                }
                if (row == size - 1 - cell) {
                    right = true;
                }
                /*4,0  3,1  2,2  1,3  0,4 */
                if (left) {
                    System.out.print("0");
                } else if (right) {
                    System.out.print("0");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Draw by 3");
        draw(3);
        System.out.println("Draw by 5");
        draw(5);
        System.out.println("Draw by 7");
        draw(7);
    }
}



