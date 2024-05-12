import br.com.levieber.screenmatch.domain.*;
import br.com.levieber.screenmatch.utils.WatchTimeCalculator;

public class Main {
    public static void main(String[] args) {
        System.out.println("*".repeat(30));
        System.out.println("*".repeat(8) + " SCREEN MATCH " + "*".repeat(8));
        System.out.println("*".repeat(30));

        RecommendationFilter recommendationFilter = new RecommendationFilter();
        WatchTimeCalculator watchTimeCalculator = new WatchTimeCalculator();

        Movie duna = new Movie("Duna 2", 2024, 250, false, "Villeneuve");
        duna.addRating(9.8);
        duna.addRating(10);
        duna.addRating(90);
        System.out.println(duna);
        System.out.println("*".repeat(30));
        Series tensura = new Series("Tensura", 2014, true, 3, 24, 25,false);
        tensura.addRating(9.8);
        System.out.println(tensura);
        System.out.println("*".repeat(30));

        Movie avatar = new Movie("Avatar", 2023, 120, true, "James Cameron");

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
        topEpisode.setTotalViews(1500);
        System.out.println(topEpisode.getRating());
        System.out.println(recommendationFilter.isRecommended(topEpisode));
        System.out.println("*".repeat(30));

        Music peacekeeper = new Music("Peacekeeper", 2024, 3, false, "STEREO DIVE FOUNDATION", "PEACEKEEPER", "J-POP");
        Podcast hipsters = new Podcast("Hipsters Podcast", 2017, 100, false, "Paulo Silveira", "O seu podcast de tecnologia");
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
    }
}
