package br.com.levieber.screenmatch.utils;

import br.com.levieber.screenmatch.domain.Title;

public class WatchTimeCalculator {
    private int totalTime = 0;

    public int getTotalTime() {
        return totalTime;
    }

    public void add(Title title) {
        totalTime += title.getDurationInMinutes();
    }
}
