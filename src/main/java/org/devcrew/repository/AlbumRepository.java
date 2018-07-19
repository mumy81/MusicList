package org.devcrew.repository;

import org.devcrew.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
	Album findByName(String name);
	Album findById(long id);
	void deleteById(long id);
}