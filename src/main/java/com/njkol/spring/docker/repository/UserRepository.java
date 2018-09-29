package com.njkol.spring.docker.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.njkol.spring.docker.model.User;

public interface UserRepository extends JpaRepository<User, Integer>  {

	User findByFirstName(String firstName);
}