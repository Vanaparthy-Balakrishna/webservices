package com.bala.rest.webservices.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bala.rest.webservices.exception.BadRequestExcetion;

@Service
public class UserDaoService {

	private static List<User> users = new ArrayList<>();
	private static int usersCount = 3;

	private static List<Post> posts = new ArrayList<>();
	private static int postCount = 3;
	
	static {
		users.add(new User(1, "Vanaparthy", LocalDate.now()));
		users.add(new User(2, "Balakrishna", LocalDate.now()));
		users.add(new User(3, "Vanaparthy Balakrishna", LocalDate.now()));
	}

	static {
		posts.add(new Post(1, 1, "Vanaparthy"));
		posts.add(new Post(2, 1, "Vanaparthy"));
		posts.add(new Post(3, 1, "Vanaparthy"));

		posts.add(new Post(3, 2, "Balakrishna"));
		posts.add(new Post(4, 2, "Balakrishna"));
		posts.add(new Post(5, 2, "Balakrishna"));

		posts.add(new Post(6, 3, "Vanaparthy Balakrishna"));
		posts.add(new Post(7, 3, "Vanaparthy Balakrishna"));
		posts.add(new Post(8, 3, "Vanaparthy Balakrishna"));
	}

	public List<User> findAllUsers() {
		return users;
	}

	public User findUserById(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

	public User saveUser(User user) {
		if (user.getName().length() < 2) {
			throw new BadRequestExcetion("Name should be at least 2 characters");
		}
		if (user.getId() == 0) {
			user.setId(++usersCount);
		}
		usersCount = user.getId();
		users.add(user);
		return user;
	}

	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	public List<Post> findAllPostsByUserId(int userId) { 
		List<Post> postsByUserId = new ArrayList<>();
		for (Post data : posts) {
			if (userId == data.getUserId()) {
				postsByUserId.add(data);
			}
		}
		return postsByUserId;
	}
}
