package com.edwards.RickAndMortyBackend.controller;

import com.edwards.RickAndMortyBackend.model.Character;
import com.edwards.RickAndMortyBackend.model.CharacterDetails;
import com.edwards.RickAndMortyBackend.model.Location;
import com.edwards.RickAndMortyBackend.service.RickAndMortyService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RickAndMortyController {
    private final RickAndMortyService rickAndMortyService;

    public RickAndMortyController(RickAndMortyService rickAndMortyService) {
        this.rickAndMortyService = rickAndMortyService;
    }

    @GetMapping("/characters")
    public Character[] getAllCharacters() {
        return rickAndMortyService.getAllCharacters();
    }

    @GetMapping("/characters/{id}")
    public Character getCharacterById(@PathVariable int id) {
        return rickAndMortyService.getCharacterById(id);
    }

    @GetMapping("/characters/details/{id}")
    public CharacterDetails getCharacterDetails(@PathVariable int id) {
        return rickAndMortyService.getCharacterDetails(id);
    }

    @GetMapping("/locations")
    public Location[] getAllLocations() {
        return rickAndMortyService.getAllLocations();
    }

    @GetMapping("/locations/{id}")
    public Location getLocationById(@PathVariable int id) {
        return rickAndMortyService.getLocationById(id);
    }
}
