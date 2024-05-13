package br.com.levieber.screenmatch.presentation;

import br.com.levieber.screenmatch.domain.FutureYearLaunchException;
import br.com.levieber.screenmatch.domain.Title;
import br.com.levieber.screenmatch.utils.Env;
import br.com.levieber.screenmatch.utils.TitleOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainWithSearch {
    public static void main(String[] args) throws IOException {
        Env env = new Env();
        String apiKey = env.get("OMDB_API_KEY");
        List<Title> titles = new ArrayList<>();

        var scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Busque por um filme:");
            var search = scanner.nextLine();

            if (search.equals("-1")) {
                break;
            }

            var apiUrl = "https://www.omdbapi.com/?t=%s&apikey=%s".formatted(URLEncoder.encode(search, StandardCharsets.UTF_8), apiKey);

            try (var client = HttpClient.newHttpClient(); var fileWriter = new FileWriter("movies.json")) {
                var request = HttpRequest.newBuilder().uri(URI.create(apiUrl)).build();
                HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

                var gson = new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).setPrettyPrinting().create();

                TitleOmdb titleOmdb = gson.fromJson(response.body(), TitleOmdb.class);
                Title title = new Title(titleOmdb);

                titles.add(title);

                fileWriter.write(gson.toJson(titles));
            } catch (IOException | InterruptedException e) {
                System.out.println("Erro ao consultar a API!");
                System.out.println(e.getMessage());
            } catch (FutureYearLaunchException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Finalizado com sucesso!");
    }
}
