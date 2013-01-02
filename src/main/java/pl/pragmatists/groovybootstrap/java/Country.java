package pl.pragmatists.groovybootstrap.java;

class Country {

    private final String iso;

    private final String code;

    public final String name;

    Country(String iso, String code, String name) {
        this.iso = iso;
        this.code = code;
        this.name = name;
    }

    public String toString() {
        return iso + " - " + code + " - " + name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Country country = (Country) o;

        if (!code.equals(country.code)) return false;
        if (!iso.equals(country.iso)) return false;
        if (!name.equals(country.name)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = iso.hashCode();
        result = 31 * result + code.hashCode();
        result = 31 * result + name.hashCode();
        return result;
    }

    public boolean hasData() {
        return !code.isEmpty() && !iso.isEmpty() && !name.isEmpty();
    }
}
