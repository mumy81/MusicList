package org.devcrew.controller;

import java.util.List;
import java.util.Optional;

import org.devcrew.model.Album;
import org.devcrew.model.Artist;
import org.devcrew.repository.AlbumRepository;
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
@RequestMapping("/api/album")
public class AlbumController {
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	ArtistRepository artistRepository;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Album> getAll() {
		return albumRepository.findAll();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Album getAlbum(@PathVariable long id) {
		return albumRepository.findById(id);
	}
	
	@RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
	public List<Album> searchAlbum(@PathVariable String name) {
		System.out.println(albumRepository.searchByName(name));
		return albumRepository.searchByName(name);		
	}
	
	@PostMapping("/add")
	public Album saveAlbum(@RequestBody Album album) {
		Artist artistByName = artistRepository.findByName(album.getArtist().getName());
		if (artistByName != null && artistByName.getSurname() == album.getArtist().getSurname() ) {
			album.setArtist(artistByName);
		}
		return albumRepository.save(album);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAlbumByYear(@PathVariable("id") long id) {
		albumRepository.deleteById(id);
	}
}