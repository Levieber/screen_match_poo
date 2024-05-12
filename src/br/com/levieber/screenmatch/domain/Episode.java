package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Episode implements Rateable {
    private final int number;
    private final String title;
    private final Series series;
    private int totalViews;

    public Episode(int number, String title, Series series) {
        this.number = number;
        this.title = title;
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public String getTitle() {
        return title;
    }

    public Series getSeries() {
        return series;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void view() {
        this.totalViews++;
    }

    @Override
    public int getRating() {
        if (totalViews >= 1000) {
            return 5;
        }

        return (int) (Math.random() * 4);
    }
}
