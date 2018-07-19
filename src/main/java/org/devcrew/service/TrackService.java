package org.devcrew.service;

import org.devcrew.model.Track;

public interface TrackService {
	Track saveTrack(Track track, long playlistId);
}
