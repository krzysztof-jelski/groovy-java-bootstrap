package pl.pragmatists.groovybootstrap.groovy

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode
class GroovyCountry {
    String iso
    String code
    String name

    @Override
    public String toString() {
        "$iso - $code - $name"
    }
}
