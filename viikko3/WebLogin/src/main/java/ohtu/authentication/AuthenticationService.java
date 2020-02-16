package ohtu.authentication;

import ohtu.data_access.UserDao;
import ohtu.domain.User;
import ohtu.util.CreationStatus;

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

    public CreationStatus createUser(String username, String password, String passwordConfirmation) {
        CreationStatus status = new CreationStatus();
        
        if (userDao.findByName(username) != null) {
            status.addError("username is already taken");
        }

        if (username.length()<3 ) {
            status.addError("username should have at least 3 characters");
        }
		
		if (password.length()<8 ) {
			status.addError("password should have at least 8 characters");
		}
		
		if (invalid(username, password) ) {
			status.addError("invalid username or password");
		}

        if (status.isOk()) {
            userDao.add(new User(username, password));
        }
        
        return status;
    }
	
	private boolean invalid(String username, String password) {
        // validity check of username and password
    	String name = username.trim();
    	String pwd = password.trim();
    	char[] array = pwd.toCharArray();

    		//if there are some other than lowercase letters, invalid!
    		if (name.matches("[^a-z]")) {
    			return true;
    		}

    		for (int i = 0; i< array.length; i++) {
    			//if contains something else than alphabetic letters
    			if (pwd.charAt(i)<64 || pwd.charAt(i) > 122) {
    				return false;
    			}
    			//some other special letters ok, too
    			if (pwd.charAt(i)>90 && pwd.charAt(i)<=96) {
    				return false;
    			}
    		}
    		return true;
    }

}
