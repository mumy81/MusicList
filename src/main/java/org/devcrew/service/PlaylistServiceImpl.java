package org.devcrew.service;

import org.devcrew.model.Playlist;
import org.devcrew.model.User;
import org.devcrew.repository.PlaylistRepository;
import org.devcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PlaylistServiceImpl implements PlaylistService {
	
	@Autowired
	PlaylistRepository playlistRepository;
	
	@Autowired
	UserRepository userRepository;

	@Override
	public Playlist addPlaylist(Playlist playlist, long userId) {
		User userr = userRepository.findById(userId);
		userr.getPlaylists().add(playlist);
		System.out.println(userr);
		System.out.println(userr.getPlaylists());		
		userRepository.save(userr);
		return playlist;
	}

}
