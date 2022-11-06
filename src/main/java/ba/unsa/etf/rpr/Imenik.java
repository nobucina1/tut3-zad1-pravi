package ba.unsa.etf.rpr;
import java.util.*;

public class Imenik {

    private String ime;
    private TelefonskiBroj broj;
    private HashMap<String, TelefonskiBroj> m = new HashMap<String, TelefonskiBroj>();

    public void dodaj(String ime, TelefonskiBroj broj) {
        m.put(ime, broj);
    }

    public String dajBroj(String ime) {
        return m.get(ime).ispisi();
    }

    public String dajIme(TelefonskiBroj broj) {
        for (Map.Entry<String, TelefonskiBroj> clan : m.entrySet()) {
            if (clan.getValue().equals(broj))
                return clan.getKey();
        }
        return ("Nema!");
    }

    public String naSlovo(char s) {
        String povratni = "";
        int index = 1;
        for (Map.Entry<String, TelefonskiBroj> clan : m.entrySet()) {
            if (clan.getKey().charAt(0) == s) {
                povratni = povratni + index + ". " + clan.getKey() + " - " + clan.getValue().ispisi() + "\n";
                index++;
            }
        }
        return povratni;
    }

    public Set<String> izGrada(Grad g) {
        Set<String> s = new TreeSet();
        for (Map.Entry<String, TelefonskiBroj> clan : m.entrySet()) {
            if (clan.getValue() instanceof FiksniBroj && ((FiksniBroj) clan.getValue()).getGrad().equals(g))
                s.add(clan.getKey());
        }
        return s;
    }

    public Set<TelefonskiBroj> izGradaBrojevi(Grad g) {
        Set<TelefonskiBroj> s = new TreeSet<TelefonskiBroj>(new Comparator<TelefonskiBroj>() {
            @Override
            public int compare(TelefonskiBroj o1, TelefonskiBroj o2) {
                if (o1 instanceof FiksniBroj && o2 instanceof FiksniBroj)
                    return o1.ispisi().compareTo(o2.ispisi());
                return 0;
            }
        });
        for (Map.Entry<String, TelefonskiBroj> clan : m.entrySet()) {
            if (clan.getValue() instanceof FiksniBroj && ((FiksniBroj) clan.getValue()).getGrad().equals(g))
                s.add(clan.getValue());
        }
        return s;
    }
}
