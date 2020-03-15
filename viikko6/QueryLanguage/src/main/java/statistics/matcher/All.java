package statistics.matcher;

import statistics.Player;

public class All implements Matcher {
	boolean condition;
	
	public All() {
		condition = true;
	}
	
	@Override
	public boolean matches(Player p) {
		return condition;
	}

}
