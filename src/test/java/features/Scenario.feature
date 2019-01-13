#language: ru
Функционал: проверка работы поиска на сайте циан

  @123
  Сценарий: проверка работы поиска
    * открыт браузер и осуществлен переход на сайт
    * пользователь заполняет поле выбора действия значением "Купить"
    * пользователь заполняет поле выбора недвижимости значением "Квартира"
    * пользователь заполняет поле выбора категории значением "Новостройка"
    * пользователь заполняет поле количество комнат
        |студия               |false|
        |1-комнатная          |false|
        |2-комнатная          |true|
        |3-комнатная          |false|
        |4-комнатная          |false|
        |5-комнатная          |false|
        |6-комнатная +        |false|
        |Свободная планировка |true|
    * пользователь заполняет поле "от" значением "4500000"
    * пользователь заполняет поле "до" значением "4600000"
    # пользователь заполняет поле адреса значением "Брянск, Россия"
    * пользователь нажимает кнопку Найти
    * пользователь нажимает кнопку Сохранить файл в Excel
    * пользователь закрывает браузер