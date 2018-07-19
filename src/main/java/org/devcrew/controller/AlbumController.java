package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.Album;
import org.devcrew.model.Artist;
import org.devcrew.repository.AlbumRepository;
import org.devcrew.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/album")
public class AlbumController {
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	ArtistRepository artistRepository;

	@GetMapping("/all")
	public List<Album> getAll() {
		return albumRepository.findAll();
	}

	@PostMapping("/add")
	public Album saveAlbum(@RequestBody Album album) {
		Artist artistByName = artistRepository.findByName(album.getArtist().getName());
		if (artistByName != null) {
			album.setArtist(artistByName);
		}
		return albumRepository.save(album);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteAlbumByYear(@PathVariable("id") long id) {
		albumRepository.deleteById(id);
	}
}
