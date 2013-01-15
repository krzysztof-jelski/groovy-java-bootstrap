package pl.pragmatists.groovybootstrap.groovy

import groovy.transform.EqualsAndHashCode
import groovy.transform.TupleConstructor

@EqualsAndHashCode
@TupleConstructor
class GroovyCountry {
    final String iso
    final String code
    final String name

    @Override
    public String toString() {
        "$iso - $code - $name"
    }
}
