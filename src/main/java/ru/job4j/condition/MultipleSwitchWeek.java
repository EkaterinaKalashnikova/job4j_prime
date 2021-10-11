package ru.job4j.condition;

public class MultipleSwitchWeek {
    public static int numberOfDay(String name) {
      /**  return switch (name) {
            case "Понедельник" ,"Monday" -> 1;
            case "Вторник" ,"Tuesday" -> 2;
            case "Среда" ,"Wednesday" -> 3;
            case "Четверг" ,"Thursday" -> 4;
            case "Пятница" ,"Friday" -> 5;
            case "Суббота" ,"Saturday" -> 6;
            case "Воскресенье" ,"Sunday" -> 7;
            default -> -1;
        };*/

        switch (name) {
            case "Понедельник":
            case "Monday":
                return 1;
            case "Вторник":
            case "Tuesday":
                return 2;
            case "Среда":
            case "Wednesday":
                return 3;
            case "Четверг":
            case "Thursday":
                return 4;
            case "Пятница":
            case "Friday":
                return 5;
            case "Суббота":
            case "Saturday":
                return 6;
            case "Воскресенье":
            case "Sunday":
                return 7;
            default:
                return -1;
        }

    }
}
