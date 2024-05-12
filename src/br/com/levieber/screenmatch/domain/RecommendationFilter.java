package br.com.levieber.screenmatch.domain;

import br.com.levieber.screenmatch.domain.interfaces.Rateable;

public class RecommendationFilter {
    public boolean isRecommended(Rateable rateable) {
        return rateable.getRating() >= 4;
    }
}
