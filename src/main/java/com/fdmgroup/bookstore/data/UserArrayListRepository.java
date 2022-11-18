package com.fdmgroup.bookstore.data;

import java.util.ArrayList;
import java.util.List;

import com.fdmgroup.bookstore.model.User;

public class UserArrayListRepository implements UserRepository {

	private static int id = 1;

	private List<User> users;

	public UserArrayListRepository() {
		super();
	}

	public UserArrayListRepository(List<User> users) {
		this.users = users;
	}

	public boolean validate(String username, String password) {
		for (User user : users) {
			if (user.getUsername().equals(username) && user.getPassword().equals(password))
				return true;
		}
		return false;
	}

	public User findByUsername(String username) {
		for (User user : users) {
			if (user.getUsername().equals(username))
				return user;
		}
		return null;
	}

	public static int generateId() {
		return id++;
	}

	public User save(User user) {
		boolean isOldUser = false;
		User matchOldUser = null;
		for (User oldUser : users) {
			if (oldUser.getUsername().equals(user.getUsername())) {
				isOldUser = true;
				matchOldUser = oldUser;
				break;
			}
		}
		if (!isOldUser) {
			int userId = generateId();
			user.setUserId(userId);
			users.add(user);
		} else {
			user.setUserId(matchOldUser.getUserId());
			users.remove(matchOldUser);
			users.add(user);
		}
		return user;
	}

	public User delete(User user) {
		boolean isOldUser = false;
		User matchOldUser = null;
		for (User oldUser : users) {
			if (oldUser.getUsername().equals(user.getUsername())) {
				isOldUser = true;
				matchOldUser = oldUser;
				break;
			}
		}
		if (isOldUser) {
			users.remove(matchOldUser);
		}
		return null;
	}

	public User findById(int id) {
		for (User user : users) {
			if (user.getUserId() == id)
				return user;
		}
		return null;
	}

	public List<User> findAll() {
		return users;
	}

	
	@Override
	public String toString() {
		return "UserArrayListRepository [users=" + users + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((users == null) ? 0 : users.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserArrayListRepository other = (UserArrayListRepository) obj;
		if (users == null) {
			if (other.users != null)
				return false;
		} else if (!users.equals(other.users))
			return false;
		return true;
	}
	
	

}
