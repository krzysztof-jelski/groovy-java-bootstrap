package pl.pragmatists.groovybootstrap.groovy

import org.junit.Test

import static org.fest.assertions.Assertions.assertThat


class GroovyCountryTest {

    @Test
    public void shouldHaveToString() {
        assertThat(new GroovyCountry(iso: "iso", code: "code", name: "name").toString()).isEqualTo("iso - code - name")
    }
}
