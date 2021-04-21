package statistics;

import statistics.matcher.*;

public class Main {
    public static void main(String[] args) {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players.txt";

        Statistics stats = new Statistics(new PlayerReaderImpl(url));

        /* 
        Matcher m = new And(new HasAtLeast(5, "goals"), new HasAtLeast(5, "assists"), new PlaysIn("PHI"));
        Matcher a = new All();
        Matcher n = new And(new Not(new HasAtLeast(1, "goals")), new PlaysIn("NYR"));
        Matcher b = new And(new HasFewerThan(1, "goals"), new PlaysIn("NYR"));
        Matcher c = new Or(new HasAtLeast(40, "goals"), new HasAtLeast(60, "assists"));
        Matcher d = new And(new HasAtLeast(50, "points"),
                new Or(new PlaysIn("NYR"), new PlaysIn("NYI"), new PlaysIn("BOS")));
        
        System.out.println(stats.matches(new All()).size());

        */

        QueryBuilder q1 = new QueryBuilder();
        QueryBuilder q2 = new QueryBuilder();
        // Matcher m = query.build();
        // Matcher m = query.playsIn("NYR").build();
        // Matcher m = query.playsIn("NYR").hasAtLeast(5, "goals").hasFewerThan(10, "goals").build();

        Matcher m1 = q1.playsIn("PHI").hasAtLeast(10, "assists").hasFewerThan(5, "goals").build();
        Matcher m2 = q2.playsIn("EDM").hasAtLeast(40, "points").build();
        Matcher m = q1.oneOf(m1, m2).build();

        for (Player player : stats.matches(m)) {
            System.out.println(player);
        }

    }
}
