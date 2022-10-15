package pl.weather.weather.city;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.text.Collator;
import java.util.Locale;

@Entity
public class City implements Comparable<City> {
    @Id
    private Long id;
    private String name;
    private Double lat;
    private Double lng;
    private String country;
    private String iso2;
    private String iso3;

    public City() {
    }

    public City(Long id, String name, Double lat, Double lng, String country, String iso2, String iso3) {
        this.id = id;
        this.name = name;
        this.lat = lat;
        this.lng = lng;
        this.country = country;
        this.iso2 = iso2;
        this.iso3 = iso3;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @Override
    public int compareTo(City o) {
        return Collator
                .getInstance(new Locale(iso2, iso2.toUpperCase()))
                .compare(this.name, o.name);
    }
}
