package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.Playlist;
import org.devcrew.model.Track;
import org.devcrew.repository.PlaylistRepository;
import org.devcrew.repository.TrackRepository;
import org.devcrew.service.PlaylistServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {
	@Autowired
	PlaylistRepository playlistRepository;
	@Autowired
	PlaylistServiceImpl playlistServiceImpl;

	@GetMapping("/all")
	public List<Playlist> getAllPlaylist() {
		return playlistRepository.findAll();
	}

	@RequestMapping(value = "/save/{user_id}", method = RequestMethod.POST)
	public Playlist savePlaylist(@RequestBody Playlist playlist, @PathVariable("user_id") long userId) {
		return playlistServiceImpl.addPlaylist(playlistRepository.save(playlist), userId);
	}

	@RequestMapping(value = "/add/{playlist_id}", method = RequestMethod.POST)
	public void addPlaylist(@PathVariable("playlist_id") long playlistId, @RequestBody Track track) {
		Playlist playlist = playlistRepository.findById(playlistId);
		playlist.getTracks().add(track);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Playlist getPlaylist(@PathVariable("id") long id) {
		return playlistRepository.findById(id);
	}
}
