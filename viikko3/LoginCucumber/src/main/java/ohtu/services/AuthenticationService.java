package ohtu.services;

import ohtu.domain.User;
import java.util.ArrayList;
import java.util.List;
import ohtu.data_access.UserDao;

public class AuthenticationService {

    private UserDao userDao;

    public AuthenticationService(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean logIn(String username, String password) {
        for (User user : userDao.listAll()) {
            if (user.getUsername().equals(username)
                    && user.getPassword().equals(password)) {
                return true;
            }
        }

        return false;
    }

    public boolean createUser(String username, String password) {
        if (userDao.findByName(username) != null) {
            return false;
        }

        if (invalid(username, password)) {
            return false;
        }

        userDao.add(new User(username, password));

        return true;
    }

    private boolean invalid(String username, String password) {
        // validity check of username and password
    	String name = username.trim();
    	String pwd = password.trim();
    	if (name.length() >= 3 && pwd.length() >= 8) {
    		if (name.matches("[^a-z]")) {
    			return false;
    		}
    		if (pwd.matches("[^A-z]")) {
    			return true;
    		} else {
    			return false;
    		}
    	} else {
    		return false;
    	}
    }
}
