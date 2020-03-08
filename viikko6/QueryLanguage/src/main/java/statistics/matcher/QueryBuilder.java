package statistics.matcher;

public class QueryBuilder {
	Matcher matcher;
	
	public QueryBuilder() {
		matcher = new All();
	}

	public Matcher build() {
		return matcher;
	}
	
	public Matcher playsIn(String team) {
		this.matcher = new PlaysIn(team);
		return matcher;
	}
}
