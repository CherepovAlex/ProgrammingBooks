//package exercise;
//
//import javax.swing.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.io.File;
//import java.io.FileOutputStream;
//import java.io.ObjectOutputStream;
//
//public class MySendListener  implements ActionListener {
//    public void actionPerformed(ActionEvent e) { // все это происходит при нажатии кнопки, после чего срабатывает ActionEvent
//        boolean[] checkboxState = new boolean[256]; // создаём булев массив для хранения каждого флажка
//        for (int i = 0; i < 256; i++) {                         // пробегаем через checkboxList (ArrayList, содержащий состояния флажков)
//            JCheckBox check = (JCheckBox) checkboxList.get(i);  // считываем состояния и добавляем полученные значения в булева массив
//            if (check.isSelected()) {
//                checkboxState[i] = true;
//            }
//        }
//        try {
//            FileOutputStream fileStream = new FileOutputStream(new File("Checkbox.ser"));
//            ObjectOutputStream os = new ObjectOutputStream(fileStream);
//            os.writeObject(checkboxState); // это самая простоя часть. Просто запишите/сериализуйте булев массив
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//    }
//}