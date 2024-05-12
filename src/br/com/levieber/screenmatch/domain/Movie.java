package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class Movie extends Title implements Rateable {
    private final String director;

    public Movie(String name, int yearLaunch, int durationInMinutes, boolean planIncluded, String director) {
        super(name, yearLaunch, durationInMinutes, planIncluded);
        this.director = director;
    }

    public String getDirector() {
        return director;
    }

    @Override
    public int getRating() {
        return Math.clamp((int)getAverageRating() / 2, 0, 5);
    }

    @Override
    public void showTechnicalSheet() {
        System.out.printf("""
                Nome: %s
                Ano de lançamento: %d
                Quantidade de avaliações: %d
                Média de avaliação: %.1f
                Incluído no plano: %s
                Duração: %d minutos
                Dirigido por: %s%n""",
                getName(),
                getYearLaunch(),
                getTotalRating(),
                getAverageRating(),
                isPlanIncluded() ? "sim" : "não",
                getDurationInMinutes(),
                director
        );
    }

    @Override
    public String toString() {
        return "Filme: %s".formatted(super.toString());
    }
}
