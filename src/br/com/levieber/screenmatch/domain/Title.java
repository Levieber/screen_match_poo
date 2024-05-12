package br.com.levieber.screenmatch.domain;

public class Title {
    private String name;
    private int yearLaunch;
    private int durationInMinutes;
    private boolean planIncluded;
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

    public void setName(String name) {
        this.name = name;
    }

    public void setYearLaunch(int yearLaunch) {
        this.yearLaunch = yearLaunch;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public void setPlanIncluded(boolean planIncluded) {
        this.planIncluded = planIncluded;
    }

    public double getAverageRating() {
        return sumRating / totalRating;
    }

    public void addRating(double rating) {
        sumRating += rating;
        totalRating++;
    }

    public String toString() {
        return """
                Nome: %s
                Ano de lançamento: %d
                Quantidade de avaliações: %d
                Média de avaliação: %.1f
                Incluído no plano: %s
                Duração: %d minutos""".formatted(
                name,
                yearLaunch,
                totalRating,
                getAverageRating(),
                planIncluded ? "sim" : "não",
                durationInMinutes
        );
    }
}
