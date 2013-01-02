package pl.pragmatists.groovybootstrap.java;

import java.util.*;

public class Countries {

    private final List<Country> countries = new ArrayList<Country>();

    public Countries() {
        loadCountriesFromLocale();
        Collections.sort(countries, new CountryComparator());
    }

    private void loadCountriesFromLocale() {
        Locale[] locales = Locale.getAvailableLocales();
        for (Locale locale : locales) {
            String iso;
            try {
                iso = locale.getISO3Country();
            } catch (MissingResourceException e) {
                iso = "unknown";
            }
            String code = locale.getCountry();
            String name = locale.getDisplayCountry(Locale.ENGLISH);

            Country country = new Country(iso, code, name);
            if (!countries.contains(country) && country.hasData())
                countries.add(country);
        }
        for (Country country : countries) {
            System.out.println(country);

        }
    }

    public boolean contains(String countryName) {
        for (Country country : countries) {
            if (country.name.equals(countryName))
                return true;
        }
        return false;
    }


    public boolean contains(Country country) {
        return countries.contains(country);
    }
}
