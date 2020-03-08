package statistics.matcher;

import statistics.Player;

public class QueryBuilder implements Matcher{
	Matcher matcher;
	
	public QueryBuilder() {
		matcher = new All();
	}

	public Matcher build() {
		return matcher;
	}
	
	public Matcher playsIn(String team) {
		this.matcher = new PlaysIn(team);
		return this;
	}
	
	public Matcher hasAtLeast(int value, String category) {
		this.matcher = new HasAtLeast(value, category);
		return this;
	}
	
	public Matcher Not(Matcher matcher) {
		this.matcher = new Not(matcher);
		return this;
	}

	public Matcher hasFewerThan(int value, String category) {
		this.matcher = new HasFewerThan(value, category);
		return this;
	}

	@Override
	public boolean matches(Player p) {
		// TODO Auto-generated method stub
		return false;
	}

}
