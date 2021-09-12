# TouristTelegramBot

Телеграм бот и веб сервисы начинают свою работу после забуска класса App.
Телеграм бот запускается сообщением /start. После данного сообщения бот здоровается и рассказывает о себе:

#### Привет! Я туристический телеграм бот. Введи город, который ты планируешь посетить, и я немного расскажу тебе о нём

После этого мы можем использовать его в качестве туристического путеводителя.
Работа с ботом предполагает, что путешественник вводит название города, и если данный город есть в нашей базе данных, то бот отвечает путешественнику кратким описанием этого города. Например:

#### - Париж
#### - Никакое место на земле не заставляет сердце замереть так, как одно только упоминание о Париже. Город манит своим великолепным искусством, архитектурой, культурой и кухней, однако в то же время исполнен и более спокойного волшебства, которое только и ждет, чтобы его открыли.

Если же города в базе нет, то бот пришлет сообщение "К сожалению, я пока ничего не знаю об этом городе"

Данные о боте (имя бота и его токен) и о базе данных (url, логин и пароль) храняться в файле **application.properties**

Таким образом телеграм бот полностью выполняет поставленную задача. 
Далее перейдем к веб части нашего проекта.

Для работы через REST необходимо подготовить приложение **Postman**.
Назначение Postman — тестирование отправки запросов с клиента на сервер и получения ответа от сервера.

Для получения информации о всех городах выберем тип метода **GET** и введем url

![image](https://user-images.githubusercontent.com/63640670/132994650-37a26143-72f2-4f5d-be78-9da05bd2ed4f.png)

Далее нажав кнопку **SEND** мы получим список городов и их описаний

![image](https://user-images.githubusercontent.com/63640670/132994722-0d4bbda7-0c44-49e3-828e-6f38e619fa38.png)

