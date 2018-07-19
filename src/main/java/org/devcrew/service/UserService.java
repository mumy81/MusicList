package org.devcrew.service;

import org.devcrew.model.Playlist;
import org.devcrew.model.User;

public interface UserService {
	Playlist addPlaylist(Playlist playlist, User user) throws Exception;
	boolean login(String username,String password) throws Exception;
}
