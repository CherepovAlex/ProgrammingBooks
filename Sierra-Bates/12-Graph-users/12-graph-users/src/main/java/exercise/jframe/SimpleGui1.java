package exercise.jframe;

import javax.swing.*;
// реализация графического интерфейса
public class SimpleGui1 {
    public static void main(String[] args) {

        JFrame frame = new JFrame();                     // создаём фрейм и кнопку
        JButton button = new JButton("click me");   // передаём конструктору кнопки текст

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   // завершает работу программы при закрытии окна

        frame.getContentPane().add(button);     // добавляем кнопку на панель фрейма

        frame.setSize(300, 300);   // присваиваем фрейму размер (в пикселах)

        frame.setVisible(true);                // делаем фрейм видимым


    }



//    public void changeIt() {
//        button.setText("I've been clicked!");
//    }
}
