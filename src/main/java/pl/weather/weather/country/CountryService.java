package pl.weather.weather.country;

import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import pl.weather.weather.city.City;

import java.util.List;
import java.util.Optional;

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
        return cities;
    }

    public List<Country> findAllCountries(){
        return Streamable.of(countryRepository.findAll()).toList();
    }
}
