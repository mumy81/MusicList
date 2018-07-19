package org.devcrew.service;

import org.devcrew.model.Playlist;
import org.devcrew.model.User;

public interface PlaylistService {
	Playlist addPlaylist(Playlist playlist, long userId);
}
