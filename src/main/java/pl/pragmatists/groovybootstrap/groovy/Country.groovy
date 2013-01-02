package pl.pragmatists.groovybootstrap.groovy

class Country {
     String iso
     String code
     String name

    @Override
    String toString() {
        "$iso - $code - $name";
    }
}
