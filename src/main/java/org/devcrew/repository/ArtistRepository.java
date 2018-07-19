package org.devcrew.repository;

import java.util.List;

import org.devcrew.model.Album;
import org.devcrew.model.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArtistRepository extends JpaRepository<Artist,Long> {
	Artist findByName(String name);
	Artist findById(long id);
	void deleteById(long id);
	@Query("Select a FROM Artist a where a.name LIKE CONCAT('%',:name,'%')") 
    List<Album> searchByName(@Param("name") String name);
}
