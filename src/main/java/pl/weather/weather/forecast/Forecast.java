package pl.weather.weather.forecast;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Forecast {
    private List<Climate> climateList;

    @JsonCreator
    public Forecast(@JsonProperty("list") List<Climate> climateList) {
        this.climateList = climateList;
    }

    public List<Climate> getClimateList() {
        return climateList;
    }

    public void setClimateList(List<Climate> climateList) {
        this.climateList = climateList;
    }

    @Override
    public String toString() {
        climateList.forEach(System.out::println);
        return " ";
    }
}
