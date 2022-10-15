package pl.weather.weather.forecast;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weather {
    private List<WeatherDetails> weatherDetails;

    @JsonCreator
    public Weather(List<WeatherDetails> weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    public List<WeatherDetails> getWeatherDetails() {
        return weatherDetails;
    }

    public void setWeatherDetails(List<WeatherDetails> weatherDetails) {
        this.weatherDetails = weatherDetails;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "weatherDetails=" + weatherDetails +
                '}';
    }
}
