package pl.pragmatists.groovybootstrap.java;

import java.text.Collator;
import java.util.Comparator;

class CountryComparator implements Comparator<Country> {
    private Comparator comparator;

    CountryComparator() {
        comparator = Collator.getInstance();
    }

    public int compare(Country o1, Country o2) {
        return comparator.compare(o1.name, o2.name);
    }
}
