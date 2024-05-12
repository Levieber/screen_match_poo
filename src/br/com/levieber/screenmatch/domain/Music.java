package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Music extends Audio implements Rateable {
    private String author;
    private String album;
    private String genre;

    public Music(String name, int yearLaunch, int durationInMinutes, boolean planIncluded, String author, String album, String genre) {
        super(name, yearLaunch, durationInMinutes, planIncluded);
        this.author = author;
        this.album = album;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public int getRating() {
        if (getTotalPlays() >= 1000) {
            return 5;
        }

        return (int) (Math.random() * 4);
    }
}
