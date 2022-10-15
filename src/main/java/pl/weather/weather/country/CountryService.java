package pl.weather.weather.country;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.weather.weather.forecast.Forecast;
import pl.weather.weather.city.City;

import java.util.*;

@Service
public class CountryService {
    private final CountryRepository countryRepository;


    public CountryService(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    public Optional<String> findCountryCodeByName(String name){
        Optional<Country> country = countryRepository.findByName(name);
        String countryCode = country.map(Country::getCountryCode)
                .orElseThrow(CountryNotFoundException::new);

        return Optional.of(countryCode);
    }

    public List<City> findCitiesByCountryName(String name){
        Optional<Country> country = countryRepository.findByName(name);
        country.orElseThrow(CountryNotFoundException::new);

        List<City> cities = country.map(Country::getCityList).get();
        Collections.sort(cities);

        return cities;
    }

    public CountryFlag findCountryFlagByName(String name){
        Optional<Country> country = countryRepository.findByName(name);
        String iso2 = country.map(Country::getIso2).get();
        String url = "https://countryflagsapi.com/png/" + iso2;
        return new CountryFlag(url);
    }

    public List<Country> findAllCountries(){
        return Streamable.of(countryRepository.findAll()).toList();
    }

    public boolean existsByName(String name){
        return countryRepository.existsByName(name);
    }
}
