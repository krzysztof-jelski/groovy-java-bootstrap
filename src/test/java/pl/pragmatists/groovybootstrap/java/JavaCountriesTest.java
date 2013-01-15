package pl.pragmatists.groovybootstrap.java;

import static org.fest.assertions.Assertions.*;

import org.junit.*;

public class JavaCountriesTest {

    private JavaCountries countries = new JavaCountries();

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
        assertThat(countries.byName("Poland")).isEqualTo(new JavaCountry("POL", "PL", "Poland"));
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
