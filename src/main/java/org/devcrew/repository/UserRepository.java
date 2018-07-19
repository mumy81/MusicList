package org.devcrew.repository;

import org.devcrew.model.Track;
import org.devcrew.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
	User findById(long id);
	void deleteById(long id);
}
