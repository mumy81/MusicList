package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.Artist;
import org.devcrew.model.Track;
import org.devcrew.repository.ArtistRepository;
import org.devcrew.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/artist")
public class ArtistController {
	
	@Autowired
	ArtistRepository artistRepository;
	@GetMapping("/all")
	public List<Artist> getAllArtist(){
		return artistRepository.findAll();
	}
	@PostMapping("/add")
	public Artist saveTrack(@RequestBody Artist artist ){
		return artistRepository.save(artist);
	}

}
