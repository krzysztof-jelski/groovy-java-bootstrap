package pl.pragmatists.groovybootstrap.java;

import java.util.*;

public class JavaCountries {

    private List<JavaCountry> cachedCountries = new ArrayList<JavaCountry>();

    public boolean contains(String countryName) {
        for (JavaCountry country : all()) {
            if (country.name.equals(countryName))
                return true;
        }
        return false;
    }

    public List<String> allNames() {
        List<String> result = new ArrayList<String>();
        for (JavaCountry country : all()) {
            result.add(country.name);
        }
        return result;
    }

    public JavaCountry byName(String name) {
        for (JavaCountry country : all()) {
            if (country.name.equals(name))
                return country;
        }
        throw new RuntimeException("Not found");
    }

    public List<JavaCountry> all() {
        if (cachedCountries.isEmpty())
            return cachedCountries = loadCountries();
        return cachedCountries;
    }

    private List<JavaCountry> loadCountries() {
        Locale[] locales = Locale.getAvailableLocales();
        List<JavaCountry> countries = new ArrayList<JavaCountry>();
        for (Locale locale : locales) {
            String iso = getIsoCode(locale);
            String code = locale.getCountry();
            String name = locale.getDisplayCountry(Locale.ENGLISH);

            JavaCountry country = new JavaCountry(iso, code, name);
            if (!countries.contains(country) && country.hasData())
                countries.add(country);
        }
        return countries;
    }

    private String getIsoCode(Locale locale) {
        try {
            return locale.getISO3Country();
        } catch (MissingResourceException e) {
            return "unknown";
        }
    }
}
