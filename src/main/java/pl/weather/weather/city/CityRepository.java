package pl.weather.weather.city;

import org.springframework.data.repository.CrudRepository;

public interface CityRepository extends CrudRepository <City, Long> {
    boolean existsByName(String name);
    City findByName(String name);
}
