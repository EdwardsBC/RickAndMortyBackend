package com.edwards.RickAndMortyBackend.model;

public class CharacterDetails {
    private Character character;
    private String firstEpisodeName;

    public CharacterDetails(Character character, String firstEpisodeName) {
        this.character = character;
        this.firstEpisodeName = firstEpisodeName;
    }
}
