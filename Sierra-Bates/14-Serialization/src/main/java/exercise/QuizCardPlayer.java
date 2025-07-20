package exercise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class QuizCardPlayer {

    private JTextArea display;          // Область для отображения вопросов/ответов
    private ArrayList<QuizCard> cardList; // Список карточек
    private QuizCard currentCard;       // Текущая карточка
    private int currentCardIndex;       // Индекс текущей карточки
    private JFrame frame;               // Главное окно
    private JButton nextButton;         // Кнопка "Далее"
    private boolean isShowAnswer;       // Флаг: показывать вопрос или ответ

    public static void main(String[] args) {
        QuizCardPlayer reader = new QuizCardPlayer();
        reader.go();
    }

    // код создания GUI
    public void go() {
        // формируем gui

        // Создаём главное окно
        frame = new JFrame("Quiz card Player");
        JPanel mainPanel = new JPanel();
        Font bigFont = new Font("sanserif", Font.BOLD, 24); // Большой шрифт

        // Настраиваем текстовую область
        display = new JTextArea(10, 20);
        display.setFont(bigFont);

        display.setLineWrap(true);      // Перенос строк
        display.setEditable(false);     // Запрет редактирования

        // Добавляем скролл для текстовой области
        JScrollPane qScroller = new JScrollPane(display);
        qScroller.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        qScroller.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        // Создаем кнопку и добавляем слушателя
        nextButton = new JButton("Show Question");
        mainPanel.add(qScroller);
        mainPanel.add(nextButton);
        nextButton.addActionListener(new NextCardListener());

        // Создаем меню
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem loadMenuItem = new JMenuItem("Load card set");
        loadMenuItem.addActionListener(new OpenMenuListener());        // Слушатель для загрузки файла
        fileMenu.add(loadMenuItem);
        menuBar.add(fileMenu);

        // Завершаем настройку GUI
        frame.setJMenuBar(menuBar);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setSize(640, 500);
        frame.setVisible(true);
    }

    // проверяем значение флага isShowAnswer, чтобы узнать, что сейчас отображается - вопрос или ответ
    // и в зависимости от результата выполняем соответствующие действия
    public class NextCardListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            if (isShowAnswer) {
                // показываем ответ, так как вопрос уже был увиден
                display.setText(currentCard.getAnswer());
                nextButton.setText("Next Card");
                isShowAnswer = false;
            } else {
                // показываем следующий вопрос
                if (currentCardIndex < cardList.size()) {
                    showNextCard();
                } else {
                    // Больше карточек нет!
                    display.setText("That was last card");
                    nextButton.setEnabled(false);
                }
            }
        }

    }

    // вызываем файловое окно, позволяющее выбирать файл для открытия
    public class OpenMenuListener implements ActionListener {
        public void actionPerformed(ActionEvent ev) {
            JFileChooser fileOpen = new JFileChooser();
            fileOpen.showOpenDialog(frame);          // Показываем диалог выбора файла
            loadFile(fileOpen.getSelectedFile());   // Загружаем выбранный файл
        }
    }

    public void loadFile(File file) {

        cardList = new ArrayList<QuizCard>();
        try {   // вызывает буфер, подставляет файл для открытия
            // Читаем файл построчно
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) { // читаем по одной строке и передаём в makeCard для разделения и преобразования в
                makeCard(line); // Создаем карточку из каждой строки // настоящий объект QuizCard, а затем добавляет в ArrayList
            }
            reader.close();
        } catch (Exception ex) {
            System.out.println("couldn't read the card file");
            ex.printStackTrace();
        }
        // пришло время показать первую карточку
        showNextCard();
    }

    private void makeCard(String lineToParse) {
        // Разделяем строку по "/" на вопрос и ответ
        String[] result = lineToParse.split("/");       // каждая строка текста - одна флешкарта, но нам нужно разделить вопрос и ответ
        QuizCard card = new QuizCard(result[0], result[1]);
        cardList.add(card); // Добавляем карточку в список
        System.out.println("made a card");
    }

    private void showNextCard() {
        currentCard = cardList.get(currentCardIndex);  // Получаем текущую карточку
        currentCardIndex++;  // Увеличиваем индекс
        display.setText(currentCard.getQuestion());  // Показываем вопрос
        nextButton.setText("Show Answer");  // Меняем текст кнопки
        isShowAnswer = true;  // Устанавливаем флаг, что сейчас показан вопрос
    }
}
