Банковский сервис предоставляет REST API со следующей функциональностью:


- Заведение нового клиента
/api/newClient
принимает XML файл (пример testData/newClient.xml) возвращает статус ok/badRequest;
Post - запрос

- Запрос списка клиентов
/api//clients
Get - запрос. Возвращает XML с данными;

- Удаление клиента
/api/deleteClient
принимает XML файл (пример testData/deleteClient.xml) возвращает статус ok/badRequest;
Post - запрос

- Заведение банковского счёта клиента
/api/newAccount
принимает XML файл (пример testData/newAccount.xml) возвращает статус ok/badRequest;
Post - запрос

- Запрос информации по счетам клиента
/api/aboutAccounts
принимает XML файл (пример testData/infoAboutClientAccounts.xml) возвращает XML с данными;
Post - запрос

- Удаление счёта
/api/deleteAccount
принимает XML файл (пример testData/newAccount.xml) возвращает статус ok/badRequest;
Post - запрос


Поддерживаемые типы документов и коды валют настраиваются в resources/application.properties;

Логгирование контролеров в resources/app.log