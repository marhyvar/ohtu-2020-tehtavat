package statistics.matcher;

public class QueryBuilder {
	Matcher matcher;
	private Matcher[] matchers;
	
	public QueryBuilder() {
		matchers[matchers.length] = new All();
	}

	public Matcher build() {
		return new And(matchers);
	}
	
	public QueryBuilder playsIn(String team) {
		this.matcher = new PlaysIn(team);
		matchers[matchers.length] = this.matcher;
		return this;
	}
	
	public QueryBuilder hasAtLeast(int value, String category) {
		this.matcher = new HasAtLeast(value, category);
		matchers[matchers.length] = this.matcher;
		return this;
	}
	
	public QueryBuilder Not(Matcher matcher) {
		this.matcher = new Not(matcher);
		return this;
	}

	public QueryBuilder hasFewerThan(int value, String category) {
		this.matcher = new HasFewerThan(value, category);
		matchers[matchers.length] = this.matcher;
		return this;
	}

}
