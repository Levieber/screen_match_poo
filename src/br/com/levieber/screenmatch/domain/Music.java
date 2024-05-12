package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Music extends Audio implements Rateable {
    private final String author;
    private final String genre;
    private String album;

    public Music(String name, int yearLaunch, int durationInMinutes, boolean planIncluded, String author, String album, String genre) {
        super(name, yearLaunch, durationInMinutes, planIncluded);
        this.author = author;
        this.genre =genre;
        setAlbum(album);
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public int getRating() {
        if (getTotalPlays() >= 1000) {
            return 5;
        }

        return (int) (Math.random() * 4);
    }
}
