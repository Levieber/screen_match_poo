package br.com.levieber.screenmatch.domain;

public class Title implements Comparable<Title> {
    private final String name;
    private final int yearLaunch;
    private final int durationInMinutes;
    private final boolean planIncluded;
    private double sumRating = 0;
    private int totalRating = 0;

    public Title(String name, int yearLaunch, int durationInMinutes, boolean planIncluded) {
        this.name = name;
        this.yearLaunch = yearLaunch;
        this.durationInMinutes = durationInMinutes;
        this.planIncluded = planIncluded;
    }

    public String getName() {
        return name;
    }

    public int getYearLaunch() {
        return yearLaunch;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public boolean isPlanIncluded() {
        return planIncluded;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public double getAverageRating() {
        return sumRating / totalRating;
    }

    public void addRating(double rating) {
        sumRating += rating;
        totalRating++;
    }

    public void showTechnicalSheet() {
        System.out.printf("""
                Nome: %s
                Ano de lançamento: %d
                Quantidade de avaliações: %d
                Média de avaliação: %.1f
                Incluído no plano: %s
                Duração: %d minutos%n""",
                name,
                yearLaunch,
                totalRating,
                getAverageRating(),
                planIncluded ? "sim" : "não",
                durationInMinutes
        );
    }

    public String toString() {
        return "%s (%d)".formatted(name, yearLaunch);
    }

    @Override
    public int compareTo(Title o) {
        return name.compareTo(o.getName());
    }
}
