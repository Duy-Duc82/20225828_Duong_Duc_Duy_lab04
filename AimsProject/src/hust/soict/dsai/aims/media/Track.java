package hust.soict.dsai.aims.media;

import java.util.Objects;

public class Track implements Playable {
    private String title;
    private int length;

    // Constructor
    public Track(String title, int length) {
        this.title = title;
        this.length = length;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Override equals() để so sánh hai track
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Track track = (Track) obj;
        return length == track.length && title.equals(track.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, length);
    }

    // Implement phương thức play()
    @Override
    public void play() {
        if (length > 0) {
            System.out.println("Playing track: " + title);
            System.out.println("Track length: " + length);
        } else {
            System.out.println("Track " + title + " cannot be played due to invalid length.");
        }
    }
}
