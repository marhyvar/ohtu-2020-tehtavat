package statistics.matcher;

import statistics.Player;

public class QueryBuilder implements Matcher{
	Matcher matcher;
	private Matcher[] matchers;
	
	public QueryBuilder() {
		matcher = new All();
	}

	public Matcher build() {
		return matcher;
	}
	
	public Matcher playsIn(String team) {
		this.matcher = new PlaysIn(team);
		matchers[matchers.length] = this.matcher;
		return this;
	}
	
	public Matcher hasAtLeast(int value, String category) {
		this.matcher = new HasAtLeast(value, category);
		matchers[matchers.length] = this.matcher;
		return this;
	}
	
	public Matcher Not(Matcher matcher) {
		this.matcher = new Not(matcher);
		return this;
	}

	public Matcher hasFewerThan(int value, String category) {
		this.matcher = new HasFewerThan(value, category);
		matchers[matchers.length] = this.matcher;
		return this;
	}

	@Override
	public boolean matches(Player p) {
		for (Matcher matcher : matchers) {
            if (!matcher.matches(p)) {
                return false;
            }
        }

        return true;
	}

}
