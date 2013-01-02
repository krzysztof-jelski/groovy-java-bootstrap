package pl.pragmatists.groovybootstrap.java;

import org.junit.Test;
import pl.pragmatists.groovybootstrap.java.Countries;

import static org.fest.assertions.Assertions.assertThat;

public class CountriesTest {

    private Countries countries = new Countries();

    @Test
    public void containsSomeCountries() {
        assertThat(countries.contains("Poland")).isTrue();
        assertThat(countries.contains("United Arab Emirates")).isTrue();
        assertThat(countries.contains("Puerto Rico")).isTrue();
        assertThat(countries.contains("Latvia")).isTrue();
        assertThat(countries.contains("Peru")).isTrue();
        assertThat(countries.contains("Honduras")).isTrue();
    }

    @Test
    public void doesNotContainEmpty() {
        assertThat(countries.contains("")).isFalse();
    }
}
