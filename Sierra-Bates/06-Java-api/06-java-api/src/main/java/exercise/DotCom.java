package exercise;

import java.util.ArrayList;

public class DotCom {
    // переменные эксземпляра класса
    private ArrayList<String> locationCells;    // ArrayList с ячейками, где находится сайт
    private String name;                        // имя сайта
    // сеттер, обновляющий местоположение сайта (адрес предоставляется placeDotCom)
    public void setLocationCells(ArrayList<String> loc) {
        locationCells = loc;
    }

    public void setName(String n) {
        name = n;
    }

    public String checkYourself(String userInput) {
        String result = "Мимо";
        // вернёт местоположение по вводу, или -1 если нет такого
        int index = locationCells.indexOf(userInput);
        // применяем remove, если совпало и нужно удалить из AL
        if (index >= 0) {
            locationCells.remove(index); // применение remove
        }
        // используем для проверки наличия адресов
        if (locationCells.isEmpty()) {
            result = "Потопил";
            System.out.println("Ой! Вы потопили " + name + " : ("); // пишем результат проверки
        } else {
            result = "Попал";
        }
        return result; //  вернём мимо, попал или потопил
    }
}
