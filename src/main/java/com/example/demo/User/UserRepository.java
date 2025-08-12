package com.example.demo.User;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long>{

	Optional<SiteUser> findByUsername(String username); // <entity, 참조타입> 무조건 참조타입으로, db와의 호환을 위해서

}
