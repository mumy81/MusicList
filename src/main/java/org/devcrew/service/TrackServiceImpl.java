package org.devcrew.service;

import org.devcrew.model.Playlist;
import org.devcrew.model.Track;
import org.devcrew.repository.PlaylistRepository;
import org.devcrew.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrackServiceImpl implements TrackService {
	
	@Autowired
	PlaylistRepository playlistRepository;
	
	@Autowired
	TrackRepository trackRepository;
		
	@Override
	public Track saveTrack(Track track, long playlistId) {
		Playlist playlist = playlistRepository.findById(playlistId);
		playlist.getTracks().add(track);
		playlistRepository.save(playlist);
		return track;
	}

}
