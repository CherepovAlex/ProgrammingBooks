package exercise.jframe;

import javax.swing.*;
// тут хранятся ActionListener и ActionEvent
import java.awt.*;
import java.awt.event.*;
// реализуем интерфейс ActionListener
public class SimpleGui1B implements ActionListener {
    JButton button;

    public static void main(String[] args) {
        SimpleGui1B gui = new SimpleGui1B();
        gui.go();

    }

    public void go() {
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this); // регистрируем нашу заинтересованность в кнопке

        frame.getContentPane().add(BorderLayout.CENTER, button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setVisible(true);
    }
    // реализуем метод actionPerformed (инт ActionListener)- метод обработки событий
    public void actionPerformed(ActionEvent event) {
        button.setText("I've been clicked!"); // кнопка вызывает этот метод
    }

}
