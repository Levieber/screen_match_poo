package br.com.levieber.screenmatch.domain;

public class Series extends Title {
    private int seasons;
    private int episodesPerSeason;
    private int durationInMinutesPerEpisode;
    private boolean finished;

    public Series(String name, int yearLaunch, boolean planIncluded, int seasons, int episodesPerSeason, int durationInMinutesPerEpisode, boolean finished) {
        super(name, yearLaunch, seasons * episodesPerSeason * durationInMinutesPerEpisode, planIncluded);
        this.seasons = seasons;
        this.episodesPerSeason = episodesPerSeason;
        this.durationInMinutesPerEpisode = durationInMinutesPerEpisode;
        this.finished = finished;
    }

    public int getSeasons() {
        return seasons;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }

    public int getDurationInMinutesPerEpisode() {
        return durationInMinutesPerEpisode;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public void setDurationInMinutesPerEpisode(int durationInMinutesPerEpisode) {
        this.durationInMinutesPerEpisode = durationInMinutesPerEpisode;
    }

    @Override
    public int getDurationInMinutes() {
        return seasons * episodesPerSeason * durationInMinutesPerEpisode;
    }

    @Override
    public String toString() {
        return """
                Nome: %s
                Ano de lançamento: %d
                Quantidade de avaliações: %d
                Média de avaliação: %.1f
                Incluído no plano: %s
                Duração: %d minutos
                Quantidade de temporadas: %d
                Média de duração por episódio: %d minutes
                Finalizada: %s""".formatted(
                getName(),
                getYearLaunch(),
                getTotalRating(),
                getAverageRating(),
                isPlanIncluded() ? "sim" : "não",
                getDurationInMinutes(),
                seasons,
                durationInMinutesPerEpisode,
                finished ? "sim" : "não"
        );
    }
}
