package statistics.matcher;

import statistics.Player;

public class Not implements Matcher {
    Matcher matcher;
    public Not(Matcher matcher) {
        this.matcher = matcher;
    }

    public boolean matches(Player p) {
        return !matcher.matches(p);
    }
}
