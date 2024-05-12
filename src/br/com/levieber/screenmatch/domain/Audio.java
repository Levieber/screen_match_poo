package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Audio extends Title implements Rateable {
    private int totalPlays;
    private int likes;

    public Audio(String name, int yearLaunch, int durationInMinutes, boolean planIncluded) {
        super(name, yearLaunch, durationInMinutes, planIncluded);
    }

    public int getTotalPlays() {
        return totalPlays;
    }

    public int getLikes() {
        return likes;
    }

    public void like() {
        likes++;
    }

    public void play() {
        totalPlays++;
    }

    @Override
    public int getRating() {
        if (likes >= 1000) {
            return 5;
        }

        return (int) (Math.random() * 4);
    }
}
