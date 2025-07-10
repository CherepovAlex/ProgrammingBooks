
package exercise.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

// наследуем JPanel
public class MyDrawPanel extends JPanel {
    // Graphics - поверхность для рисования
    @Override
    public void paintComponent(Graphics g) {    // графический метод
        g.setColor(Color.orange);   // цвет фигуры
        g.fillRect(20, 50, 100, 100); // какая фигура и где

        Image image = new ImageIcon("catzilla.jpg").getImage();
        // отступ 3 и 4 пикселов слева и сверху, далее сам виджет
        g.drawImage(image, 3, 4, (ImageObserver) this);

        // закрасим всю панель черным по умолчанию; x, y,- координаты, далее ширина и высота как у панели
//        g.fillRect(0, 0, this.getWidth(), this.getHeight());

        int red = (int)(Math.random() * 255);
        int green = (int)(Math.random() * 255);
        int blue = (int)(Math.random() * 255);

        // задание цвета
        Color randomColor = new Color(red, green, blue);
        g.setColor(randomColor);
        // отступ 10 пикселов слева и сверху, 100 - ширина и высота
        g.fillOval(70, 70, 100, 100);
    }

}

