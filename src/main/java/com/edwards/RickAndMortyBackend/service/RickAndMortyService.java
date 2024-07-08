package com.edwards.RickAndMortyBackend.service;

import com.edwards.RickAndMortyBackend.model.Character;
import com.edwards.RickAndMortyBackend.model.CharacterDetails;
import com.edwards.RickAndMortyBackend.model.Episode;
import com.edwards.RickAndMortyBackend.model.Location;
import com.edwards.RickAndMortyBackend.model.RickAndMortyCharacterResponse;
import com.edwards.RickAndMortyBackend.model.RickAndMortyLocationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Service
public class RickAndMortyService {
    private final RestTemplate restTemplate;
    private final String API_URL = "https://rickandmortyapi.com/api";

    public RickAndMortyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Character[] getAllCharacters() {
        String url = API_URL + "/character";
        RickAndMortyCharacterResponse response = restTemplate.getForObject(url, RickAndMortyCharacterResponse.class);
        return response != null ? response.getResults() : new Character[0];
    }

    public Character getCharacterById(int id) {
        String url = API_URL + "/character/" + id;
        return restTemplate.getForObject(url, Character.class);
    }

    public Character[] getCharactersByIds(int[] ids) {
        String idsString = String.join(",", Arrays.stream(ids).mapToObj(String::valueOf).toArray(String[]::new));
        String url = API_URL + "/character/" + idsString;
        return restTemplate.getForObject(url, Character[].class);
    }

    public Location[] getAllLocations() {
        String url = API_URL + "/location";
        RickAndMortyLocationResponse response = restTemplate.getForObject(url, RickAndMortyLocationResponse.class);
        return response != null ? response.getResults() : new Location[0];
    }

    public Location getLocationById(int id) {
        String url = API_URL + "/location/" + id;
        return restTemplate.getForObject(url, Location.class);
    }

    public Location[] getLocationsByIds(int[] ids) {
        String idsString = String.join(",", Arrays.stream(ids).mapToObj(String::valueOf).toArray(String[]::new));
        String url = API_URL + "/location/" + idsString;
        return restTemplate.getForObject(url, Location[].class);
    }

    public CharacterDetails getCharacterDetails(int id) {
        Character character = getCharacterById(id);
        String firstEpisodeUrl = character.getEpisode()[0];
        String firstEpisodeName = getFirstEpisodeName(firstEpisodeUrl);

        return new CharacterDetails(character, firstEpisodeName);
    }

    private String getFirstEpisodeName(String episodeUrl) {
        Episode episode = restTemplate.getForObject(episodeUrl, Episode.class);
        return episode != null ? episode.getName() : "Unknown";
    }
}
