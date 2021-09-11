package by.undrul.touristTelegramBot.telegram;

import by.undrul.touristTelegramBot.answers.AnswersFile;
import by.undrul.touristTelegramBot.service.CityService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Service
public class BotService {
    private static final Logger logger = LogManager.getLogger();

    @Autowired
    private Bot bot;

    @Autowired
    CityService cityService;

    public void sendMessage(Message message, String text) {
        try {
            logger.info("BotService: sendMessage():   "+text);
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(message.getChatId().toString());
            sendMessage.setText(getAnswer(text));
            bot.execute(sendMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public String getAnswer(String text) {
        logger.info("BotService: getAnswer():   "+text);
        return (text.equals("/start")) ? AnswersFile.START_INFORMATION : cityService.getAnswer(text);
    }
}
