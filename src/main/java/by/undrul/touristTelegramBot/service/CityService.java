package by.undrul.touristTelegramBot.service;

import by.undrul.touristTelegramBot.answers.AnswersFile;
import by.undrul.touristTelegramBot.entity.City;
import by.undrul.touristTelegramBot.repository.CityRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private CityRepository cityRepository;

    public List<City> findAll() {
        return (List<City>) cityRepository.findAll();
    }

    public String getAnswer(String name) {
        logger.info("CityService: getAnswer():   " + name + "   " + cityRepository.findAll());
        String answer = cityRepository.getCityByName(name).getDescription();
        return (answer != null) ? answer : AnswersFile.NO_INFORMATION;
    }
}
