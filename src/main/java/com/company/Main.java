package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("запускаем игру");
        JFrame window = new JFrame("TicTacToe"); //Наше главное окно
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //Добавляем кнопку Х, закрывающую окно
        window.setSize(400, 400); //Размер окна
        window.setLayout(new BorderLayout()); //Менеджер компоновки
        window.setLocationRelativeTo(null); //Чтобы окно было по центру экрана
        window.setVisible(true); //Включаем видимость окна

        TicTacToe game = new TicTacToe(); //Создаем обьект класса
        window.add(game); //Добавляем его в окно
        System.out.println("конец игры");
    }
}
