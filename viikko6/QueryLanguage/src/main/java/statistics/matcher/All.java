package statistics.matcher;

import statistics.Player;

public class All implements Matcher {
	
	private Matcher[] matchers;
	
	public All(Matcher...matchers) {
		this.matchers = matchers;
	}
	
	@Override
	public boolean matches(Player p) {
		int times = 0;
		int matchedPlayers = 0;
		for (Matcher matcher : matchers) {
            if (matcher.matches(p)) {
                times++;
                matchedPlayers++;
            } else {
            	times++;
            }
        }
		if (times == matchedPlayers) {
			return true;
		} else {
			return false;
		}
	}

}
