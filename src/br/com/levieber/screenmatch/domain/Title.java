package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.utils.TitleOmdb;

import java.time.Year;

public class Title implements Comparable<Title> {
    private final String name;
    private final int yearLaunch;
    private final int durationInMinutes;
    private boolean planIncluded;
    private double sumRating = 0;
    private int totalRating = 0;

    public Title(String name, int yearLaunch, int durationInMinutes, boolean planIncluded) {
        var currentYear = Year.now().getValue();
        if (yearLaunch > currentYear) {
            throw new FutureYearLaunchException();
        }
        this.name = name;
        this.yearLaunch = yearLaunch;
        this.durationInMinutes = durationInMinutes;
        setPlanIncluded(planIncluded);
    }

    public Title(TitleOmdb titleOmdb) {
        this.name = titleOmdb.title();
        int yearLaunch;
        int durationInMinutes;
        try {
            var currentYear = Year.now().getValue();
            yearLaunch = Integer.parseInt(titleOmdb.year().replaceAll("\\D", ""));
            if (yearLaunch > currentYear) {
                throw new FutureYearLaunchException();
            }
            durationInMinutes = Integer.parseInt(titleOmdb.runtime().split(" ")[0]);
        } catch (NumberFormatException e) {
            durationInMinutes = 0;
            yearLaunch = 0;
        }
        this.durationInMinutes = durationInMinutes;
        this.yearLaunch = yearLaunch;
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

    public void setPlanIncluded(boolean planIncluded) {
        this.planIncluded = planIncluded;
    }

    public int getTotalRating() {
        return totalRating;
    }

    public double getAverageRating() {
        if (totalRating == 0 || sumRating == 0) {
            return 0;
        }
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

    @Override
    public String toString() {
        return "%s (%d / %d minutos) ".formatted(name, yearLaunch, durationInMinutes);
    }

    @Override
    public int compareTo(Title o) {
        return name.compareTo(o.getName());
    }
}
