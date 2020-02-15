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
    	char[] array = pwd.toCharArray();
    	if (name.length() >= 3 && pwd.length() >= 8) {
    		//if there are some other than lowercase letters, invalid!
    		if (name.matches("[^a-z]")) {
    			return true;
    		}

    		for (int i = 0; i< array.length; i++) {
    			/*if (Character.isDigit(array[i])) {
    				return false;
    			} */
    			//if contains something else than alphabetic letters
    			if (pwd.charAt(i)<64 || pwd.charAt(i) > 122) {
    				return false;
    			}
    			//some other special letters ok, too
    			if (pwd.charAt(i)>90 && pwd.charAt(i)<=97) {
    				return false;
    			}
    		}
    		return true;
    		
    	} else {
    		return true;
    	}
    }
}
