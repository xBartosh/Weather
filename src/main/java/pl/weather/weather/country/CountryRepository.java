package pl.weather.weather.country;

import org.springframework.data.repository.CrudRepository;
import pl.weather.weather.city.City;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends CrudRepository<Country, String> {
    Optional<Country> findByName(String name);
    boolean existsByName(String name);
}
