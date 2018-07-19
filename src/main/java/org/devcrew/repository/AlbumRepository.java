package org.devcrew.repository;

import java.util.List;
import java.util.Optional;

import org.devcrew.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	Album findByName(String name);
	Album findById(long id);
	void deleteById(long id);
	@Query("Select a FROM Album a where a.name LIKE CONCAT('%',:name,'%')") 
    List<Album> searchByName(@Param("name") String name);
}