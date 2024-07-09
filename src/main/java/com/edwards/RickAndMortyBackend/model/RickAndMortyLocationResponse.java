package com.edwards.RickAndMortyBackend.model;

public class RickAndMortyLocationResponse {
    private Info info;
    private Location[] results;

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }

    public Location[] getResults() {
        return results;
    }

    public void setResults(Location[] results) {
        this.results = results;
    }
}
