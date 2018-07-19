package org.devcrew.repository;

import org.devcrew.model.Playlist;
import org.devcrew.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Long> {
	Playlist findByName(String name);
	Playlist findById(long id);
	void deleteById(long id);
	//@Query("instert into u.userName from User u inner join u.area ar where ar.idArea = :idArea")
	//void saveTrack(Track track);
}
