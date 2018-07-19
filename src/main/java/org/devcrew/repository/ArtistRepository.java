package org.devcrew.repository;

import org.devcrew.model.Album;
import org.devcrew.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
	Artist findByName(String name);
	Artist findById(long id);
	void deleteById(long id);
}
