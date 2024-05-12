package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Podcast extends Audio implements Rateable {
    private String host;
    private String description;

    public Podcast(String name, int yearLaunch, int durationInMinutes, boolean planIncluded, String host, String description) {
        super(name, yearLaunch, durationInMinutes, planIncluded);
        this.host = host;
        this.description = description;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int getRating() {
        if (getLikes() >= 500) {
            return 5;
        }

        return (int) (Math.random() * 4);
    }
}
