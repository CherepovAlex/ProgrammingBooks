package exercise;

import javax.sound.midi.*;

public class MusicTest1 {

    public void play() {
        try {
            Sequencer sequencer = MidiSystem.getSequencer();
            System.out.println("We got sequencer");
        } catch (MidiUnavailableException e) {
            System.out.println("Fault");
        }
    }

    public static void main(String[] args) {
        MusicTest1 mt = new MusicTest1();
        mt.play();
//        player.open();
//        Sequencer seq = new Sequencer(timing, 4);
//        Track t = seq.createTrack();
//        t.add(myMidiEvent1);
//        player.setSequence(seq);
//        player.start();
    }
}
