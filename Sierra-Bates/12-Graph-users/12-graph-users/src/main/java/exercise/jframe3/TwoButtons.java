package exercise.jframe3;

import exercise.jframe.MyDrawPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// в данный момент главный класс GUI не реализует интерфейс ActionListener
public class TwoButtons {

    JFrame frame;
    JLabel label;

    public static void main(String[] args) {
        TwoButtons gui = new TwoButtons();
        gui.go();
    }

    public void go() {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // вместо передачи слушателя, передаём экземпляр соответствующего слушателя
        JButton labelButton = new JButton("Change Label");
        labelButton.addActionListener(new LabelListener());

        JButton colorButton = new JButton("Change Circle");
        colorButton.addActionListener(new ColorListener());

        label = new JLabel("I'm a Label");
        MyDrawPanel drawPanel = new MyDrawPanel();

        frame.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame.getContentPane().add(BorderLayout.CENTER, drawPanel);
        frame.getContentPane().add(BorderLayout.EAST, labelButton);
        frame.getContentPane().add(BorderLayout.WEST, label);

        frame.setSize(300, 300);
        frame.setVisible(true);
    }

    // теперь не будет 2 слушателя в одном классе
    class LabelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            label.setText("Ouch!"); // внутренний класс знает о lable
        }
    }

    class ColorListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            frame.repaint();    // внутренний класс использует frame без явной на объект внешнего класса
        }
    }
}
