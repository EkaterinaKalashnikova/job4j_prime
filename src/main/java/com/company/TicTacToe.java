package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;


public class TicTacToe extends JComponent {
    private static final int FIELD_EMPTY = 0; //пустое поле
    private static final int FIELD_X = 10; //поле с крестиком
    private static final int FIELD_0 = 200; //поле с ноликом
    private int[][] field; //обьявляем массив игрового поля
    private boolean isXturn;

    public TicTacToe() {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK); //получение событий от мыши
        field = new int[3][3]; //ыделяем память под массив при создания компонента
        initGame();
    }

    public void initGame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                field[i][j] = FIELD_EMPTY; //очищаем массив и заполняем его 0
            }
        }
        isXturn = true;
    }

    @Override
    protected void processMouseEvent(MouseEvent mouseEvent) { //здесь получаем эти события от мыши
        super.processMouseEvent(mouseEvent);
        if (mouseEvent.getButton() == MouseEvent.BUTTON1) { //проверяем что нажата левая клавиша
            int x = mouseEvent.getX(); //координата x клика
            int y = mouseEvent.getY(); //координата y клика
            // переведем координаты в индексы ячейки
            int i = (int) ((float) x / getWidth() * 3);
            int j = (int) ((float) y / getHeight() * 3);
            //проверяем что выбранная ячейка пуста
            if (field[i][j] == FIELD_EMPTY) {
                //проверка чей ход, если X то ставим крестик, если 0 то ставим нолик
                field[i][j] = isXturn ? FIELD_X : FIELD_0;
                isXturn = !isXturn; //меняем флаг хода
                repaint(); //перерисовка компонента из метода paintComponent()
               int res = chackState();
                if(res != 0) {
                    if (res == FIELD_0*3) { //победил 0
                        JOptionPane.showMessageDialog(this, "нолики выиграли!", "Победа!", JOptionPane.INFORMATION_MESSAGE);
                    } else if (res == FIELD_X*3) { //победил Х
                        JOptionPane.showMessageDialog(this, "крестики выиграли!", "Победа!", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "ничья!", "Ничья!", JOptionPane.INFORMATION_MESSAGE);
                    }
                    initGame(); //перезапускаем игру
                    repaint(); //перерисовываем поле
                }
            }
        }
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        //graphics.setColor(Color.RED);
        //graphics.drawOval(10, 10, 100, 100);
        super.paintComponent(graphics);
        graphics.clearRect(0, 0, getWidth(), getHeight());
        drawGrid(graphics);
        drawX0(graphics);
    }

    private void drawGrid(Graphics graphics) {
        int w = getWidth(); //ширина игрового поля
        int h = getHeight(); //высота игрового поля
        int dw = w / 3; //ширина одной ячейки
        int dh = h / 3; //высота одной ячейки
        graphics.setColor(Color.BLUE); //цвет линий
        for (int i = 1; i < 3; i++) { //пробегает значения от 1 до 2 и выходит из цикла
            graphics.drawLine(0, dh * i, w, dh * i); //горизонтальная линия
            graphics.drawLine(dw * i, 0, dw * i, h); //вертикальная линия
        }
    }

    void drawX(int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        //линия от верхнего левого в правый нижний
        graphics.drawLine(x, y, x + dw, y + dh);
        //линия от левого нижнего в правый верхний
        graphics.drawLine(x, x + dw, y + dh, y);
    }

    void draw0(int i, int j, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int dw = getWidth() / 3;
        int dh = getHeight() / 3;
        int x = i * dw;
        int y = j * dh;
        //отрисовка овала
        graphics.drawOval(x + 5 * dw / 100, y, dw * 9 / 10, dh);
    }

    void drawX0(Graphics graphics) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (field[i][j] == FIELD_X) {
                    drawX(i, j, graphics);
                } else if (field[i][j] == FIELD_0) {
                    draw0(i, j, graphics);
                }
            }
        }
    }

    int chackState() {
        //проверяем диагонали
        int diag1 = 0;
        int diag2 = 0;
        for (int i = 0; i < 3; i++) {
            //сумма значений по диагонали от левого угла
            diag1 += field[i][i];
            //сумма значений по диагонали от правго угла
            diag2 += field[i][2 - i];
        }
        //если по диагонали стоят одни крестики или нолики выходим из метода
        if (diag1 == FIELD_0 * 3 || diag1 == FIELD_X * 3) {
            return diag1;
        }
        //то же самое и по другой диагонали
        if (diag2 == FIELD_0 * 3 || diag2 == FIELD_X * 3) {
            return diag2;
        }
        int chack_i, chack_j;
        boolean hasEmpty = false;
        //будем бегать по всем рядам
        for (int i = 0; i < 3; i++) {
            chack_i = 0;
            chack_j = 0;
            for (int j = 0; j < 3; j++) {
                //суммируем знаки в текущем ряду
                if (field[i][j] == 0) {
                    hasEmpty = true;
                }
                chack_i += field[i][j];
                chack_j += field[j][i];
            }
            //если выигрыш крестика или нолика, то выходим
            if(chack_i == FIELD_0*3 || chack_i == FIELD_X) {
                return chack_i;
            }
            if(chack_j == FIELD_0*3 || chack_j == FIELD_X) {
                return chack_j;
            }
        }
        if (hasEmpty) {
            return  0;
        } else  return -1;
    }
}
