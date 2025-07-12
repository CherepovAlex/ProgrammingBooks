package exercise.jframe2;

import exercise.jframe.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleGui3C implements ActionListener {

    JFrame frame;

    public static void main(String[] args) {
        SimpleGui3C gui = new SimpleGui3C();
        gui.go();
    }

    public void go() {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton button = new JButton("Change color");
        button.addActionListener(this); // добавляем слушателя (this) к кнопке

        MyDrawPanel1 drawPanel = new MyDrawPanel1();

        // Добавляем два виджета
        frame.getContentPane().add(BorderLayout.SOUTH, button);     // кнопку
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel); // панель для рисования
        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent event) {
        frame.repaint();    // при нажатии кнопки вызывается этот метод
    }

}

class MyDrawPanel1 extends JPanel {
    public void paintComponent(Graphics g) {

        // заполнение овала произвольным цветом
        int red = (int) (Math.random() * 255);
        int green = (int) (Math.random() * 255);
        int blue = (int) (Math.random() * 255);

        // задание цвета
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        // отступ 10 пикселов слева и сверху, 100 - ширина и высота
        g.fillOval(70, 70, 100, 100);
    }
}
