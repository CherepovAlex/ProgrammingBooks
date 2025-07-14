package exercise.makeLightMessage;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;

public class MiniMusicPlayer3 {
    // Создается главное окно приложения с заголовком "My first music clip"
    static JFrame f = new JFrame("My first music clip");
    // Объявляется панель для рисования ml (типа MyDrawPanel)
    static MyDrawPanel ml;

    public static void main(String[] args) {
        // Создается экземпляр класса MiniMusicPlayer3
        MiniMusicPlayer3 mini = new MiniMusicPlayer3();
        // Вызывается метод go()
        mini.go();
    }

    public void setUpGui() {
        // Создается экземпляр панели для рисования
        ml = new MyDrawPanel();
        // Устанавливается как содержимое окна
        f.setContentPane(ml);
        // Задаются размеры и положение окна
        f.setBounds(30, 30, 300, 300);
        // Окно делается видимым
        f.setVisible(true);
    }

    public void go() {
        // Сначала настраивается GUI вызовом setUpGui()
        setUpGui();

        try {
            // Получаем MIDI-секвенсер и открываем его
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            // Регистрируем панель ml как слушателя событий контроллера (для события с номером 127)
            sequencer.addControllerEventListener(ml, new int[] {127});
            // Создаем новую MIDI-последовательность с разрешением 4 импульса на четверть ноты
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            // Создаем трек в этой последовательности
            Track track = seq.createTrack();

            int r = 0;
            // В цикле создаем 15 нот (шаг 4, всего 60/4=15 итераций)
            for (int i = 0; i < 60; i+=4) {
                // Генерируется случайная высота тона (1-50)
                r = (int)((Math.random()*50) + 1);
                // Добавляется событие "начало ноты" (144)
                track.add(makeEvent(144, 1, r, 100, i));
                // Добавляется событие контроллера (176) с номером 127 (которое будет триггерить визуальный эффект)
                track.add(makeEvent(176, 1, 127, 0, i));
                // Добавляется событие "конец ноты" (128) через 2 тика после начала
                track.add(makeEvent(128, 1, r, 100, i + 2));
            }
            // Устанавливаем последовательность в секвенсер
            sequencer.setSequence(seq);
            // Запускаем воспроизведение
            sequencer.start();
            // Устанавливаем темп 120 ударов в минуту
            sequencer.setTempoInBPM(120);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    // Вспомогательный метод для создания MIDI-событий
    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            // Создает сообщение ShortMessage с указанными параметрами и упаковывает его в MidiEvent с заданным временем (tick)
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }

}
// Кастомная панель, которая также является слушателем MIDI-событий контроллера
                                 // панель для рисования - это слушатель
class MyDrawPanel extends JPanel implements ControllerEventListener {
    // присваиваем флагу значение false и будем устанавливать true, когда получим событие
    // Флаг, указывающий, было ли получено событие контроллера
    boolean msg = false;
    // Вызывается при получении события контроллера
    public void controlChange(ShortMessage event) {
        // мы получили событие, поэтому присваиваем флагу значение true и вызываем repoint()
        msg = true;
        // Устанавливает флаг msg в true и вызывает перерисовку панели
        repaint();
    }

    public void paintComponent(Graphics g) {
        // Мы должны использовать флаг, потому что другие объекты могут запустить repaint()
        // а мы хотим рисовать только тогда, когда произойдет событие ControllerEvent
        // Проверяем флаг msg - рисуем только если было событие
        if (msg) {
            Graphics2D g2 = (Graphics2D) g;
            // Генерируем случайный цвет
            int r = (int) (Math.random() * 250);
            int gr = (int) (Math.random() * 250);
            int b = (int) (Math.random() * 250);

            g.setColor(new Color(r, gr, b));

            // оставшийся код нужен для генерации случайного цвета и рисования произвольного прямоугольника
            // Генерируем случайные параметры для прямоугольника (размеры и положение)
            int ht = (int) ((Math.random() * 120) + 10);
            int width = (int) ((Math.random() * 120) + 10);
            int x = (int) ((Math.random() * 40) + 10);
            int y = (int) ((Math.random() * 40) + 10);
            // Рисуем заполненный прямоугольник
            g.fillRect(x, y, ht, width);
            // Сбрасываем флаг msg после отрисовки
            msg = false;
        }
    }
}