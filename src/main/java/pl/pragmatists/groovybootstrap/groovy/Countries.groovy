package pl.pragmatists.groovybootstrap.groovy

class Countries {

    def countries = []

    Countries() {
        countries = Locale.availableLocales.collect({ locale ->
            new Country(
                    iso: getIsoCode(locale),
                    code: locale.country,
                    name: locale.getDisplayCountry(Locale.ENGLISH)
            )
        })
        countries.removeAll { it.name.isEmpty() }
    }

    private String getIsoCode(Locale locale) {
        try {
            locale.getISO3Country()
        } catch (MissingResourceException) {
            "unknown"
        }
    }

    boolean contains(String country) {
        countries.find { it.name.equals(country) }
    }
}
