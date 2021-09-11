package by.undrul.touristTelegramBot.repository;

import by.undrul.touristTelegramBot.entity.City;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface CityRepository extends CrudRepository<City, Long> {
    City getCityByName(String name);
}
