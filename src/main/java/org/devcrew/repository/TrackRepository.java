package org.devcrew.repository;

import java.util.List;

import org.devcrew.model.Album;
import org.devcrew.model.Artist;
import org.devcrew.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TrackRepository extends JpaRepository<Track, Long>{
	Track findByName(String name);
	Track findById(long id);
	void deleteById(long id);
	@Query("Select t FROM Track t where t.name LIKE CONCAT('%',:name,'%')") 
    List<Album> searchByName(@Param("name") String name);
}