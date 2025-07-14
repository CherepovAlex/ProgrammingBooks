package exercise.simpleAnimation;

import exercise.jframe.MyDrawPanel;

import javax.swing.*;
import java.awt.*;

public class SimpleAnimation {
    // создаем 2 поля в главном классе GUI для координат x и y круга
    int x = 70;
    int y = 70;

    public static void main(String[] args) {
        SimpleAnimation gui = new SimpleAnimation();
        gui.go();
    }

    public void go() {
        // создаём новый фрейм
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(drawPanel);
        frame.setSize(300, 300);
        frame.setVisible(true);
        // повторяем 130 раз
        for (int i = 0; i < 130; i++) {
            x++;
            y++;
            // Говорим панели, чтобы она себя перерисовывала
            drawPanel.repaint();
            // замедляем процесс
            try {
                Thread.sleep(50);
            } catch (Exception ex) {}
        }
    }
    // используем внутренний класс
    class MyDrawPanel extends JPanel {
        // используем постоянно обновляющиеся координаты x и y внешнего класса
        public void paintComponent(Graphics g) {
            // закрашиваем панель перед каждой перерисовкой
            g.setColor(Color.white);
            g.fillRect(x, y, this.getWidth(), this.getHeight());

            g.setColor(Color.green);
            g.fillOval(x, y, 40, 40);
        }
    }
}
