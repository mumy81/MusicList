package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.Playlist;

import org.devcrew.repository.PlaylistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	@Autowired
	PlaylistRepository playlistRepository;
	@GetMapping("/all")
	public List<Playlist> getAllPlaylist(){
		return playlistRepository.findAll();
		
	}
	@PostMapping("/add")
	public Playlist savePlaylist(@RequestBody Playlist playlist){
		return playlistRepository.save(playlist);
	}

}
