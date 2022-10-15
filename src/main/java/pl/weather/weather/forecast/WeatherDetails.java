package pl.weather.weather.forecast;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeatherDetails {
    private String main;
    private String description;

    public WeatherDetails(@JsonProperty("main") String main,
                          @JsonProperty("description") String description) {
        this.main = main;
        this.description = description;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "WeatherDetails{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
