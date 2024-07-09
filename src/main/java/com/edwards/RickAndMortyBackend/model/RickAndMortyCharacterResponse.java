package com.edwards.RickAndMortyBackend.model;

public class RickAndMortyCharacterResponse {
    private Info info;
    private Character[] results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Character[] getResults() {
        return results;
    }

    public void setResults(Character[] results) {
        this.results = results;
    }
}
