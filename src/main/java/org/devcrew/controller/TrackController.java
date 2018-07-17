package org.devcrew.controller;

import java.util.List;

import org.devcrew.model.Track;
import org.devcrew.model.User;
import org.devcrew.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/track")
public class TrackController {
	
	@Autowired
	TrackRepository trackRepository;
	@GetMapping("/all")
	public List<Track> getAllTrack(){
		return trackRepository.findAll();
	}
	@PostMapping("/add")
	public Track saveTrack(@RequestBody Track track ){
		return trackRepository.save(track);
	}
}
