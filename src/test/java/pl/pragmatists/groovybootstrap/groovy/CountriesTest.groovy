package pl.pragmatists.groovybootstrap.groovy

import org.junit.Test

import static org.fest.assertions.Assertions.assertThat

public class GroovyCountriesTest {

    private GroovyCountries countries = new GroovyCountries()

    @Test
    public void containsSomeCountries() {
        assertThat(countries.allNames()).contains("Poland", "United Arab Emirates", "Puerto Rico", "Latvia", "Peru", "Honduras");
    }

    @Test
    public void doesNotContainEmpty() {
        assertThat(countries.contains("")).isFalse();
    }

    @Test
    public void containsCodes() {
        assertThat(countries.byName("Poland")).isEqualTo(new GroovyCountry("POL", "PL", "Poland"));
    }

    @Test
    public void countriesAreCached() {
        assertThat(countries.all()).isSameAs(countries.all());
    }

    @Test
    public void isoCodeIsUnknownForSerbiaAndMontenegro() {
        assertThat(countries.byName("Serbia and Montenegro").iso).isEqualTo("unknown");
    }
}
