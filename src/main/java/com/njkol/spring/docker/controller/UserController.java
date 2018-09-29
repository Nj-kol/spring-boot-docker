package com.njkol.spring.docker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.njkol.spring.docker.model.User;
import com.njkol.spring.docker.service.UserService;

import org.apache.log4j.Logger;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * Controller for User service
 * 
 * @author Nilanjan Sarkar
 *
 */
@Api(value = "User Service")
@RestController
@RequestMapping("/user")
public class UserController {

	private final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	private UserService service;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	@ApiOperation(value = "Creates a User")
	public void create(@RequestBody User book) throws Exception {
		logger.info("Creating new user");
		service.addUser(book);
	}

	@GetMapping("/getbyname/{name}")
	@ApiOperation(value = "Retrives a User by their first name")
	public User getUserByName(@PathVariable String name) throws Exception {
		logger.info("Fetching user " + name + " details");
		return service.getUserByName(name);
	}

	@GetMapping("/getbyid/{id}")
	@ApiOperation(value = "Retrives a User by their first id")
	public User getUserById(@PathVariable int id) throws Exception {
		logger.info("Fetching user with Id : " + id + " details");
		return service.getUser(id);
	}

	@PostMapping("/update")
	@ResponseStatus(HttpStatus.OK)
	@ApiOperation(value = "Updates a User")
	public void updateUser(@RequestBody User book) throws Exception {
		logger.info("Creating new user");
		service.updateUser(book);
	}

	@DeleteMapping("/delete/{id}")
	@ApiOperation(value = "Deletes a user by id")
	public void deleteUserById(@PathVariable int id) throws Exception {
		logger.info("Deleting user with Id : " + id + " details");
		service.deleteUser(id);
	}
}