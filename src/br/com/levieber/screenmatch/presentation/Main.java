package br.com.levieber.screenmatch.presentation;

import br.com.levieber.screenmatch.domain.*;
import br.com.levieber.screenmatch.utils.WatchTimeCalculator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("*".repeat(30));
        System.out.println("*".repeat(8) + " SCREEN MATCH " + "*".repeat(8));
        System.out.println("*".repeat(30));

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        WatchTimeCalculator watchTimeCalculator = new WatchTimeCalculator();

        var duna = new Movie("Duna 2", 2024, 250, false, "Villeneuve");
        duna.addRating(9.8);
        duna.addRating(10);
        duna.addRating(90);
        duna.showTechnicalSheet();
        System.out.println("*".repeat(30));
        Series tensura = new Series("Tensura", 2014, true, 3, 24, 25,false);
        tensura.addRating(9.8);
        tensura.showTechnicalSheet();
        System.out.println("*".repeat(30));

        var avatar = new Movie("Avatar", 2023, 120, true, "James Cameron");

        watchTimeCalculator.add(duna);
        System.out.println(watchTimeCalculator.getTotalTime());
        watchTimeCalculator.add(avatar);
        System.out.println(watchTimeCalculator.getTotalTime());
        watchTimeCalculator.add(tensura);
        System.out.println(watchTimeCalculator.getTotalTime());
        System.out.println(duna.getRating());
        System.out.println(recommendationFilter.isRecommended(duna));

        Episode topEpisode = new Episode(56, "Aqueles que se aproximam", tensura);
        System.out.println(topEpisode.getRating());
        System.out.println(recommendationFilter.isRecommended(topEpisode));
        for (int i = 0; i < 1500; i++) {
            topEpisode.view();
        }
        System.out.println(topEpisode.getRating());
        System.out.println(recommendationFilter.isRecommended(topEpisode));
        System.out.println("*".repeat(30));

        var peacekeeper = new Music("Peacekeeper", 2024, 3, false, "STEREO DIVE FOUNDATION", "PEACEKEEPER", "J-POP");
        var hipsters = new Podcast("Hipsters Podcast", 2017, 100, false, "Paulo Silveira", "O seu podcast de tecnologia");
        for (int i = 0; i < 1000; i++) {
            peacekeeper.play();
        }
        for (int i = 0; i < 200; i++) {
            hipsters.like();
            peacekeeper.like();
            hipsters.play();
        }
        System.out.println(peacekeeper.getRating());
        System.out.println(recommendationFilter.isRecommended(peacekeeper));
        System.out.println(hipsters.getRating());
        System.out.println(recommendationFilter.isRecommended(hipsters));

        System.out.println("*".repeat(30));

        var scarletBond = new Movie("Tensura: Scarlet Bond", 2022, 160, false, "Fuse");
        scarletBond.addRating(8.9);

        ArrayList<Movie> movies = new ArrayList<>(3);
        movies.add(scarletBond);
        movies.add(duna);
        movies.add(avatar);

        System.out.println(movies.size());
        System.out.println(movies.getFirst().getName());
        System.out.println(movies.get(1).getName());
        System.out.println(movies.getLast().getName());
        System.out.println(movies);
    }
}
