package org.devcrew.repository;

import org.devcrew.model.Artist;
import org.devcrew.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrackRepository extends JpaRepository<Track, Long>{
	Track findByName(String name);
	Track findById(long id);
	void deleteById(long id);
}