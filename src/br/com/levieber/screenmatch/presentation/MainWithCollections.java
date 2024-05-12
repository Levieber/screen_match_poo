package br.com.levieber.screenmatch.presentation;

import br.com.levieber.screenmatch.domain.Movie;
import br.com.levieber.screenmatch.domain.Series;
import br.com.levieber.screenmatch.domain.Title;
import br.com.levieber.screenmatch.domain.interfaces.Rateable;

import java.util.*;

public class MainWithCollections {
    public static void main(String[] args) {
        var duna = new Movie("Duna 2", 2024, 250, false, "Villeneuve");
        var avatar = new Movie("Avatar", 2023, 120, true, "James Cameron");
        var scarletBond = new Movie("Tensura: Scarlet Bond", 2022, 160, false, "Fuse");

        var tensura = new Series("Tensura", 2014, true, 3, 24, 25,false);

        List<Title> watched = new ArrayList<>();

        watched.add(duna);
        watched.add(avatar);
        watched.add(scarletBond);
        watched.add(tensura);

        watched.forEach(System.out::println);
        (watched.stream().filter(t -> Rateable.class.isAssignableFrom(t.getClass()))).map(t -> ((Rateable) t).getRating()).forEach(System.out::println);

        System.out.println("*".repeat(30));

        List<String> actors = new LinkedList<>();
        actors.add("Adam Sandler");
        actors.add("Paulo");
        actors.add("Jacqueline");
        actors.add("Levi");
        System.out.println(actors);
        Collections.sort(actors);
        System.out.println(actors);

        System.out.println("*".repeat(30));

        System.out.println(watched);
        Collections.sort(watched);
        System.out.println(watched);
        watched.sort(Comparator.comparing(Title::getYearLaunch));
        System.out.println(watched);
    }
}
