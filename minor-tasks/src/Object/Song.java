package Object;

import java.util.Objects;

public class Song {
    public String title;
    public String artist;
    public String songwriter;

    public Song(String title, String artist, String songwriter) {
        this.title = title;
        this.artist = artist;
        this.songwriter = songwriter;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (otherObject == null || otherObject.getClass() != getClass()) return false;
        Song song = (Song) otherObject;
        return Objects.equals(title, song.title) && Objects.equals(artist, song.artist) && Objects.equals(songwriter, song.songwriter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, artist, songwriter);
    }
}

