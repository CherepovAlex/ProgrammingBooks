package exercise.makeLightMessage;

import javax.sound.midi.*;
// пример: используем новый статический метод makeEvent()
public class MiniMusicPlayer1 {

    public static void main(String[] args) {

        try{    // создаём и открываем синтезатор
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            // создаём последовательность и дорожку
            Sequence seq = new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();
            // создаём группу событий, чтобы ноты продолжали подниматься (от ноты фортепиано 5 до ноты 61)
            for (int i = 5; i <= 61; i+=4) {
                // вызываем метод, чтобы создать сообщение и событие, затем добавляем в дорожку:
                // они представляют собой пару включения (144) и отключения (128) воспроизведения
                track.add(makeEvent(144, 1, i, 100, i));
                track.add(makeEvent(128, 1, i, 100, i + 2));
            }
            // запускаем его
            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }
}
