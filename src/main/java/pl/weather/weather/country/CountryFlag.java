package pl.weather.weather.country;

import java.io.File;

public class CountryFlag {
    private String url;

    public CountryFlag(String url) {
        this.url = url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
