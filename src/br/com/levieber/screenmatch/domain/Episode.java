package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Episode implements Rateable {
    private int number;
    private String title;
    private Series series;
    private int totalViews;

    public Episode(int number, String title, Series series) {
        this.number = number;
        this.title = title;
        this.series = series;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }

    public int getTotalViews() {
        return totalViews;
    }

    public void setTotalViews(int totalViews) {
        this.totalViews = totalViews;
    }

    @Override
    public int getRating() {
        if (totalViews >= 1000) {
            return 5;
        }

        return (int) (Math.random() * 4);
    }
}
