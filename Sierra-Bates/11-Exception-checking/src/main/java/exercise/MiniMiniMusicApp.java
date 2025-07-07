package exercise;

import javax.sound.midi.*;

public class MiniMiniMusicApp {

    public static void main(String[] args) {
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }

    public void play() {
        try {
            Sequencer player = MidiSystem.getSequencer();            // получаем синтезатор
            player.open();                                           // открываем синтезатор
            Sequence seq = new Sequence(Sequence.PPQ, 4);   // вставляем последовательность
            Track track = seq.createTrack();                         // запрашивает трек у последовательности

            ShortMessage a = new ShortMessage();                        // создаём сообщение
            a.setMessage(144, 1, 44, 100); // вносим данные (инструкцию) - 44 нота, 100 - скорость и сила нажатия
                                                                        // 144/128 - начать/закончить проигрывать ноту, 1 - канал
            MidiEvent noteOn = new MidiEvent(a, 1);                // создаём midi-событие и помещаем сообщение (1 такт или бит 1)
            track.add(noteOn);                                          // помещаем событие в трек

            ShortMessage b = new ShortMessage();                        // аналогично
            b.setMessage(128, 1, 44, 100);
            MidiEvent noteOff = new MidiEvent(b, 16);
            track.add(noteOff);

            a.setMessage(144, 1, 20, 100);
            b.setMessage(128, 1, 44, 100);
//            MidiEvent noteOff1 = new MidiEvent(b, 3);
//            first.serMessage(192, 1, 102,0);                            // меняем инструмент: 102 - новый

            player.setSequence(seq);                                    // передаём последовательность синтезатору

            player.start();                                             // запускаем синтезатор
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

