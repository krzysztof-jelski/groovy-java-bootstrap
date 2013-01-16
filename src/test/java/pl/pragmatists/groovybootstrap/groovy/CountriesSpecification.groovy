package pl.pragmatists.groovybootstrap.groovy

import spock.lang.Specification

class CountriesSpecification extends Specification {
    def "contains some Countries"() {
        when:
        def countries = new GroovyCountries()

        then:
        countries.allNames() containsAll(["Poland", "New Zealand", "United Arab Emirates"])
    }

}
