package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.Artist;
import org.devcrew.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/artist")
public class ArtistController {
	
	@Autowired
	ArtistRepository artistRepository;
	@RequestMapping(value="/all", method=RequestMethod.GET)
	public List<Artist> getAllArtist(){
		return artistRepository.findAll();
	}
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Artist getArtist(@PathVariable long id) {
		return artistRepository.findById(id);
	}
	@PostMapping("/add")
	public Artist saveTrack(@RequestBody Artist artist ){
		return artistRepository.save(artist);
	}
	@DeleteMapping("/delete/{id}")
	public void deleteTrack(@PathVariable long id) {
		artistRepository.deleteById(id);
	}

}
