package net.java.nlmp.blog.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import net.java.nlmp.blog.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	
	Optional<Role> findByName(String name);

}
