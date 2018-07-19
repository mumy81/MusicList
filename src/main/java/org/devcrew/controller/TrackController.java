package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.Album;
import org.devcrew.model.Track;
import org.devcrew.repository.AlbumRepository;
import org.devcrew.repository.TrackRepository;
import org.devcrew.service.TrackServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/track")
public class TrackController {
	
	@Autowired
	TrackRepository trackRepository;
	@Autowired
	AlbumRepository albumRepository;
	@Autowired
	TrackServiceImpl trackServiceImpl;
	
	@GetMapping("/all")
	public List<Track> getAllTrack(){
		return trackRepository.findAll();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Track getTrack(@PathVariable("id") long id){
		return trackRepository.findById(id);
	}
	
	@RequestMapping(value = "/add/", method = RequestMethod.POST)
	public Track addTrack(@RequestBody Track track){
		Album albumByName = albumRepository.findByName(track.getAlbum().getName());
		if(albumByName != null) {
			track.setAlbum(albumByName);		
		}
		return trackRepository.save(track);
	}
	@RequestMapping(value = "/save/album/{id}", method = RequestMethod.POST)
	public Track saveTrackToAlbum(@RequestBody Track track, @PathVariable long id) {
		return null;		
	}
	@RequestMapping(value = "/save/playlist/{id}", method = RequestMethod.POST)
	public Track saveTrackToPlaylist(@RequestBody Track track, @PathVariable("id") long playlistId) {
			return trackServiceImpl.saveTrack(trackRepository.save(track), playlistId);
	}
	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public void deleteTrack(@PathVariable("id") long id) {
		trackRepository.deleteById(id);
	}

}
