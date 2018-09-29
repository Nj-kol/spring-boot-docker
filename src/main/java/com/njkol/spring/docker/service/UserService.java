package com.njkol.spring.docker.service;

import com.njkol.spring.docker.model.User;

public interface UserService {

	public void addUser(User p) throws Exception;
	public void updateUser(User p) throws Exception;
	public User getUser(int userID) throws Exception;
	public void deleteUser(int userID) throws Exception;
	public User getUserByName(String name);
}