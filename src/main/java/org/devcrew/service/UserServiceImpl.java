package org.devcrew.service;

import org.devcrew.model.Playlist;
import org.devcrew.model.User;
import org.devcrew.repository.PlaylistRepository;
import org.devcrew.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	PlaylistRepository playlistRepository;

	@Autowired
	UserRepository userRepository;

	@Override
	public Playlist addPlaylist(Playlist playlist, User user) throws Exception {
		return null;
	}

	@Override
	public boolean login(String username, String password) throws Exception, UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user != null) {
			if (user.getPassword().equals(password)) {
				return true;
			} else {
				throw new Exception("Login is failed.");
			}
		} else {
			throw new UsernameNotFoundException("User not found.");
		}

	}

}
