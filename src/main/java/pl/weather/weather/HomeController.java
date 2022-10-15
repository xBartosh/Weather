package pl.weather.weather;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.weather.weather.city.City;
import pl.weather.weather.city.CityService;
import pl.weather.weather.country.Country;
import pl.weather.weather.country.CountryFlag;
import pl.weather.weather.country.CountryNotFoundException;
import pl.weather.weather.country.CountryService;
import pl.weather.weather.forecast.Forecast;

import java.util.List;

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

    @PostMapping("/search")
    String searchWeather(@RequestParam String country, RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("country", country);
        return "redirect:weather";
    }

    @GetMapping("/weather")
    String getCountry(@RequestParam String country, Model model){
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
    String searchWeather(@RequestParam String country,
                         @RequestParam String city,
                         RedirectAttributes redirectAttributes){

        redirectAttributes.addAttribute("city", city);
        return "redirect:/weather/" + country;
    }

    @GetMapping("/weather/{country}")
    String getWeather(@PathVariable String country, @RequestParam String city, Model model){
        if(!(countryService.existsByName(country) && cityService.existsByName(city))){
            return "error";
        }

        Forecast forecast = cityService.getForecastForCity(city);
        CountryFlag countryFlag = countryService.findCountryFlagByName(country);
        model.addAttribute("forecast", forecast);
        model.addAttribute("countryFlag", countryFlag);
        model.addAttribute("country", country);
        model.addAttribute("city", city);

        return "weather-city";
    }



}
