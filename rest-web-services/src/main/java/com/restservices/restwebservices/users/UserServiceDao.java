package com.restservices.restwebservices.users;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public class UserServiceDao {

	private static int counter = 4;

	private static List<User> users = new ArrayList<User>();

	static {

		users.add(new User("Ram", 1, new Date()));
		users.add(new User("Shyam", 3, new Date()));
		users.add(new User("Mohan", 4, new Date()));
		users.add(new User("Rohan", 2, new Date()));
	}

	public List<User> getAllUser() {
		return users;
	}

	public User saveUser(User user) {
		if (user.getId() == null) {
			user.setId(++counter);
		}
		users.add(user);
		return user;
	}

	public User finById(int id) {
		for (User user : users)
			if (user.getId() == id) {
				return user;
			}
		return null;
	}

	public User deleteUser(int id) {
		Iterator<User> itr = users.iterator();
		while (itr.hasNext()) {
			User user = itr.next();
			if (user.getId() == id) {
				itr.remove();
				return user;
			}

		}
		return null;

	}

}
