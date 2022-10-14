package pl.weather.weather.country;

public class CountryNotFoundException extends RuntimeException{
    CountryNotFoundException(){
        super("Country does not exist");
    }
}
