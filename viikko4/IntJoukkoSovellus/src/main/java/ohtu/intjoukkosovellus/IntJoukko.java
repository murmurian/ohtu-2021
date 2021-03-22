package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
            OLETUSKASVATUS = 5; // luotava uusi taulukko on näin paljon isompi kuin vanha.
    private int kasvatusKoko; // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] joukko; // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenMaara; // Tyhjässä joukossa alkioiden määrä on nolla.

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatusKoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetin täytyy olla positiivinen.");
        }
        if (kasvatusKoko < 0) {
            throw new IndexOutOfBoundsException("Joukon kokoa on kasvatettava positiivisella luvulla");
        }
        this.joukko = new int[kapasiteetti];
        this.alkioidenMaara = 0;
        this.kasvatusKoko = kasvatusKoko;

    }

    public boolean lisaa(int luku) {
        if (!kuuluu(luku)) {
            joukko[alkioidenMaara] = luku;
            alkioidenMaara++;
            if (alkioidenMaara % joukko.length == 0) {
                kasvataKokoa(joukko);
            }
            return true;
        }
        return false;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == joukko[i]) {
                return true;
            }
        }
        return false;
    }

    public boolean poista(int luku) {
        int kohta = -1;
        for (int i = 0; i < alkioidenMaara; i++) {
            if (luku == joukko[i]) {
                kohta = i;
                break;
            }
        }
        if (kohta != -1) {
            for (int j = kohta; j < alkioidenMaara - 1; j++) {
                joukko[j] = joukko[j + 1];
            }
            alkioidenMaara--;
            return true;
        }
        return false;
    }

    private void kasvataKokoa(int[] vanha) {
        joukko = new int[alkioidenMaara + kasvatusKoko];
        for (int i = 0; i < vanha.length; i++) {
            joukko[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenMaara;
    }

    @Override
    public String toString() {
        if (alkioidenMaara == 0) {
            return "{}";
        } else {
            String tulostettavaJoukko = "{";
            for (int i = 0; i < alkioidenMaara - 1; i++) {
                tulostettavaJoukko += joukko[i] + ", ";
            }
            tulostettavaJoukko += joukko[alkioidenMaara - 1];
            tulostettavaJoukko += "}";
            return tulostettavaJoukko;
        }
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenMaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = joukko[i];
        }
        return taulu;
    }

    public static IntJoukko yhdiste(IntJoukko joukko1, IntJoukko joukko2) {        
        for (Integer alkio : joukko2.toIntArray()) {
            joukko1.lisaa(alkio);
        }
        return joukko1;
    }

    public static IntJoukko leikkaus(IntJoukko joukko1, IntJoukko joukko2) {
        IntJoukko leikkaus = new IntJoukko();
        for (Integer alkio1 : joukko1.toIntArray()) {
            for (Integer alkio2 : joukko2.toIntArray()) {
                if (alkio1 == alkio2) {
                    leikkaus.lisaa(alkio1);
                }
            }
        }
        return leikkaus;
    }

    public static IntJoukko erotus(IntJoukko joukko1, IntJoukko poistettavaJoukko) {
        for (Integer alkio : poistettavaJoukko.toIntArray()) {
            joukko1.poista(alkio);
        }
        return joukko1;
    }

}
