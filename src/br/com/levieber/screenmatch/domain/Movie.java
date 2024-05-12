package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Movie extends Title implements Rateable {
    private String director;

    public Movie(String name, int yearLaunch, int durationInMinutes, boolean planIncluded, String director) {
        super(name, yearLaunch, durationInMinutes, planIncluded);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    @Override
    public int getRating() {
        return Math.clamp((int)getAverageRating() / 2, 0, 5);
    }

    public String toString() {
        return """
                Nome: %s
                Ano de lançamento: %d
                Quantidade de avaliações: %d
                Média de avaliação: %.1f
                Incluído no plano: %s
                Duração: %d minutos
                Dirigido por: %s""".formatted(
                getName(),
                getYearLaunch(),
                getTotalRating(),
                getAverageRating(),
                isPlanIncluded() ? "sim" : "não",
                getDurationInMinutes(),
                director
        );
    }
}
