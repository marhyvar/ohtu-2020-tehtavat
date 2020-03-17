package statistics.matcher;

public class QueryBuilder {
	Matcher matcher;
	
	public QueryBuilder() {
		matcher = new All();
	}

	public Matcher build() {
		return matcher;
	}
	
	public QueryBuilder playsIn(String team) {
		this.matcher = new And(matcher, new PlaysIn(team));
		return this;
	}
	
	public QueryBuilder hasAtLeast(int value, String category) {
		this.matcher = new And(matcher, new HasAtLeast(value, category));
		return this;
	}
	
	public QueryBuilder Not(Matcher matcher) {
		this.matcher = new And(matcher, new Not(matcher));
		return this;
	}

	public QueryBuilder hasFewerThan(int value, String category) {
		this.matcher = new And(matcher, new HasFewerThan(value, category));
		return this;
	}
	
	public QueryBuilder oneOf(Matcher...matchers) {
		this.matcher = new Or(matcher, new Or(matchers));
		return this;
	}

}
