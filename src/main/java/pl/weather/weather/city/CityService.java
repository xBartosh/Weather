package pl.weather.weather.city;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.stereotype.Service;
import pl.weather.weather.forecast.Forecast;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

@Service
public class CityService {
    private final CityRepository cityRepository;


    private final String apiKey = "d50267040db8973bc7076575040989ea";

    private final int howManyDays = 5;
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public boolean existsByName(String name){
        return cityRepository.existsByName(name);
    }

    public Forecast getForecastForCity(String cityName){
        City city = cityRepository.findByName(cityName);
        ObjectMapper objectMapper = new ObjectMapper();
        return getForecast(city, objectMapper);
    }

    private Forecast getForecast(City city, ObjectMapper objectMapper) {
        String urlString = String
                .format("https://api.openweathermap.org/data/2.5/forecast?" +
                        "lat=%.2f&" +
                        "lon=%.2f&" +
                        "units=metric&" +
                        "cnt=%d&" +
                        "appid=%s", city.getLat(), city.getLng(), howManyDays, apiKey);
        try {
            URL url = new URL(urlString);
            Forecast forecast = objectMapper.readValue(url, Forecast.class);
            return forecast;
        } catch (JsonProcessingException | MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
