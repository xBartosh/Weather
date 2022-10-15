package pl.weather.weather.forecast;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Climate {
    private Temperature temperature;
    private Weather weather;
    private Wind wind;
    private String visibility;

    @JsonCreator
    public Climate(@JsonProperty("main") Temperature temperature,
                   @JsonProperty("weather") Weather weather,
                   @JsonProperty("win") Wind wind,
                   @JsonProperty("visibility") String visibility) {
        this.temperature = temperature;
        this.weather = weather;
        this.wind = wind;
        this.visibility = visibility;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public String getVisibility() {
        return visibility;
    }

    public void setVisibility(String visibility) {
        this.visibility = visibility;
    }

    @Override
    public String toString() {
        return "Climate{" +
                "temperature=" + temperature +
                ", weather=" + weather +
                ", wind=" + wind +
                ", visibility='" + visibility + '\'' +
                '}';
    }
}
