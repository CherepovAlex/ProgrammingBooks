package exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class QuizCardBuilder {

    private JTextArea question;
    private JTextArea answer;
    private ArrayList<QuizCard> cardList;
    private JFrame frame;

    public static void main(String[] args) {
        QuizCardBuilder builder = new QuizCardBuilder();
        builder.go();
    }

    //формирует и выводи на экран GUI, включая создание и регистрацию слушаталей для событий
    public void go() {
        // формируем м выводим на экран GUI

        frame = new JFrame("Quiz Card Builder");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24);
        question = new JTextArea(6, 20);
        question.setLineWrap(true);
        question.setWrapStyleWord(true);
        question.setFont(bigFont);

        JScrollPane qScroller = new JScrollPane(question);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        answer = new JTextArea(6, 20);
        answer.setLineWrap(true);
        answer.setWrapStyleWord(true);
        answer.setFont(bigFont);

        JScrollPane aScroller = new JScrollPane(answer);
        aScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        aScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        JButton nextButton = new JButton("Next Card");

        cardList = new ArrayList<QuizCard>();

        JLabel qLabel = new JLabel("Question:");
        JLabel aLabel = new JLabel("Answer:");

        mainPanel.add(qLabel);
        mainPanel.add(aScroller);
        mainPanel.add(aLabel);
        mainPanel.add(aScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        newMenuItem.addActionListener(new NewMenuListener());

        saveMenuItem.addActionListener(new SaveMenuListener());
        fileMenu.add(newMenuItem);
        fileMenu.add(saveMenuItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(500, 600);
        frame.setVisible(true);
    }
    // срабатывает при нажатии пользователем кнопки Next Card (Следующая карточка)
    private class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // добавляем текущую карточку в список и очищаем текстовые область
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            clearCard();
        }
    }
    // запускается при выборе команды Save (сохранить) из меню File (Файл). Означает, что пользователь хочет
    // сохранить все карточки в текущем списке в виде набора
    private class SaveMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // вызываем диалоговое окно, позволяющее пользователю называть и сохранять выбор
            QuizCard card = new QuizCard(question.getText(), answer.getText());
            cardList.add(card);
            // вызывает диалоговое окно и программа останавливает на этой строке, пока пользователь не выберет меню Save
            JFileChooser fileSave = new JFileChooser();
            fileSave.showSaveDialog(frame);
            saveFile(fileSave.getSelectedFile());
        }
    }
    // запускается при выборе команды New (Создать) из меню File (Файл).
    // означает, что пользователь хочет создать новый набор (очистив список карточек и текстовые области)
    private class NewMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // очищаем список карточек и текстовые области
            cardList.clear();
            clearCard();
        }
    }

    private void clearCard() {
        question.setText("");
        answer.setText("");
        question.requestFocus();
    }

    // вызывается классом SaveMenuListener. непосредственно записывает данные в файл.
    private void saveFile(File file) {
        // проходим по списку карточек и записываем каждый элемент в текстовый файл, который потом
        // можно будет прочитать (то есть с чистыми разделителями между частями)
        try {   // мы содениняем BufferedWrite с FileWrite для более эффективной записи
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for(QuizCard card : cardList) {
                writer.write(card.getQuestion() + "/");
                writer.write(card.getAnswer() + "\n");
            }
            writer.close();
        } catch (IOException ex){
            System.out.println("couldn't write the cardList out");
        }

    }
}
