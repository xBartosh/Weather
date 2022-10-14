package pl.weather.weather.country;

import pl.weather.weather.city.City;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Country {

    private String name;
    @Id
    private String iso2;
    private String iso3;
    private String countryCode;

    @OneToMany
    @JoinColumn( name = "iso2")
    private List<City> cityList;

    public Country() {
    }

    public Country(String name, String iso2, String iso3, String countryCode, List<City> cityList) {
        this.name = name;
        this.iso2 = iso2;
        this.iso3 = iso3;
        this.countryCode = countryCode;
        this.cityList = cityList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public List<City> getCityList() {
        return cityList;
    }

    public void setCityList(List<City> cityList) {
        this.cityList = cityList;
    }
}
