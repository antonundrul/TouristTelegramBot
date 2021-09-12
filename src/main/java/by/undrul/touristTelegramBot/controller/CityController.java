package by.undrul.touristTelegramBot.controller;

import by.undrul.touristTelegramBot.entity.City;
import by.undrul.touristTelegramBot.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> getCity(@PathVariable("id") Integer cityId) {
        if (cityId == null) {
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        }

        City city =  cityService.get(cityId);

        if (city == null) {
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        }

        ResponseEntity<City> cityResponseEntity = new ResponseEntity<City>(city, HttpStatus.OK);
        return cityResponseEntity;
    }

    @RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> saveCity(@RequestBody @Validated City city) {
        HttpHeaders headers = new HttpHeaders();

        if (city == null) {
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        }

        cityService.save(city);
        return new ResponseEntity<City>(city, headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> updateCity(@RequestBody @Validated City newCity, @PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();

        if (newCity == null) {
            return new ResponseEntity<City>(HttpStatus.BAD_REQUEST);
        }

        City city = cityService.get(id);
        city.setId(newCity.getId());
        city.setName(newCity.getName());
        city.setDescription(newCity.getDescription());

        cityService.save(city);
        return new ResponseEntity<City>(city, headers, HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<City> deleteCity(@PathVariable("id") Integer id) {
        City city = (City) cityService.get(id);
        if (city == null) {
            return new ResponseEntity<City>(HttpStatus.NOT_FOUND);
        }

        cityService.delete(id);
        return new ResponseEntity<City>(city, HttpStatus.NO_CONTENT);
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<City>> getAllCities() {
        List<City> cities = cityService.findAll();

        if (cities.isEmpty()) {
            return new ResponseEntity<List<City>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<City>>(cities, HttpStatus.OK);
    }

}
