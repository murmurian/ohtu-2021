package statistics;

import statistics.matcher.All;
import statistics.matcher.And;
import statistics.matcher.HasAtLeast;
import statistics.matcher.HasFewerThan;
import statistics.matcher.Matcher;
import statistics.matcher.Or;
import statistics.matcher.PlaysIn;

public class QueryBuilder {
    Matcher query;

    public QueryBuilder() {
        this.query = new All();
    }

    public Matcher build() {
        return query;
    }

    public QueryBuilder playsIn(String team) {
        this.query = new And(this.query, new PlaysIn(team));
        return this;
    }

    public QueryBuilder hasAtLeast(int i, String string) {
        this.query = new And(this.query, new HasAtLeast(i, string));
        return this;
    }

    public QueryBuilder hasFewerThan(int i, String string) {
        this.query = new And(this.query, new HasFewerThan(i, string));
        return this;
    }

    public QueryBuilder oneOf(Matcher m1, Matcher m2) {
        this.query = new Or(m1, m2);
        return this;
    }
}
