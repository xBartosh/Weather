package pl.weather.weather;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriComponentsBuilder;
import pl.weather.weather.city.City;
import pl.weather.weather.city.CityService;
import pl.weather.weather.country.Country;
import pl.weather.weather.country.CountryNotFoundException;
import pl.weather.weather.country.CountryService;

import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {
    private final CountryService countryService;
    private final CityService cityService;

    public HomeController(CountryService countryService, CityService cityService) {
        this.countryService = countryService;
        this.cityService = cityService;
    }

    @GetMapping("/")
    String home(Model model){
        List<Country> allCountries = countryService.findAllCountries();
        model.addAttribute("countries", allCountries);
        return "index";
    }

    @GetMapping("weather/{country}")
    String getCountry(@PathVariable String country, Model model){
        try {
            List<City> cities = countryService.findCitiesByCountryName(country);
            model.addAttribute("cities", cities);
            model.addAttribute("country", country);
        }catch (CountryNotFoundException e){
            return "error";
        }

        return "weather";
    }

    @PostMapping("/search/country")
    String searchWeather(@RequestParam String country, @RequestParam String city){
        return "redirect:/weather/" + country + "/" + city;
    }

    @GetMapping("/weather/{country}/{city}")
    String getWeather(@PathVariable String country, @PathVariable String city, Model model){
        model.addAttribute("country", country);
        model.addAttribute("city", city);
        return "weather-city";
    }

    @PostMapping("/search")
    String searchWeather(@RequestParam String country){
        return "redirect:weather/" + country;
    }

}
