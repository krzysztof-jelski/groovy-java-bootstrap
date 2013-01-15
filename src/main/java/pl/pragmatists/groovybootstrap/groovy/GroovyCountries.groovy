package pl.pragmatists.groovybootstrap.groovy

class GroovyCountries {

    def cachedCountries = []

    boolean contains(String country) {
        all().find { it.name.equals(country) }
    }

    def allNames() {
        all().collect { c -> c.name }
    }

    GroovyCountry byName(String name) {
        all().find { it.name.equals(name) }
    }

    def all() {
        if (cachedCountries.isEmpty())
            cachedCountries = loadCountries()
        cachedCountries;
    }

    private def loadCountries() {
        def countries = Locale.availableLocales.collect({ locale ->
            new GroovyCountry(
                    iso: getIsoCode(locale),
                    code: locale.country,
                    name: locale.getDisplayCountry(Locale.ENGLISH)
            )
        })
        countries.removeAll { it.name.isEmpty() }
        countries;
    }

    private String getIsoCode(Locale locale) {
        try {
            locale.getISO3Country()
        } catch (ignored) {
            "unknown"
        }
    }
}
