package exercise;

public class Song {
    String title;

    public Song(String title) {
        this.title = title;
    }

    public void play() {
        SoundPlayer player = new SoundPlayer();
        player.playSound(title);
    }

    public static int min(int a, int b) {
        return Math.min(a, b);
    }
}

class SoundPlayer {
    public void playSound(String title) {
        System.out.println("Playing " + title);
    }
}