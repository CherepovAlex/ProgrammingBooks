package exercise.makeLightMessage;

import javax.sound.midi.*;

// регистрируем и получаем ControllerEvent
// нам нужно отслеживать события ControllerEvent, поэтому мы реализуем интерфейс слушателя
public class MiniMusicPlayer2 implements ControllerEventListener {

    public static void main(String[] args) {
        MiniMusicPlayer2 mini =  new MiniMusicPlayer2();
        mini.go();
    }

    private void go() {

        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            sequencer.open();
            // регистрируем события синтезатором: принимает объект слушателя
            //              и массив целых чисел - список событий ControllerEvent, которые нам нужны - #127
            int[] eventsIWant = {127};
            sequencer.addControllerEventListener(this, eventsIWant);

            Sequence seq =  new Sequence(Sequence.PPQ, 4);
            Track track = seq.createTrack();

            for (int i = 5; i < 60; i += 4) {
                track.add(makeEvent(176, 1, 127, 0, i));
                // так ловим ритм: добавляем собственное событие ControllerEvent с аругментом для события номер #127:
                //  (176 - тип события ControllerEvent)
                track.add(makeEvent(128, 1, i, 100, i + 2));
                // оно ничего не будет делать, а только сможет реагировать на воспроизведение каждой ноты
            }

            sequencer.setSequence(seq);
            sequencer.setTempoInBPM(220);
            sequencer.start();

        } catch (Exception ex) {ex.printStackTrace();}
    }
    // метод обработки события - пишет "la" при каждом получении события
    public void controlChange(ShortMessage event) {
        System.out.println("la");
    }

    public MidiEvent makeEvent(int comd, int chan, int one, int two, int tick) {
        MidiEvent event = null;

        try {
            ShortMessage a = new ShortMessage();
            a.setMessage(comd, chan, one, two);
            event = new MidiEvent(a, tick);
        } catch (Exception e) {}
        return event;
    }
}
