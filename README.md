# Тестовое задание
## Использованные технологии
* **Java 17**
* Spring Boot
* Spring Data JPA(to work with entities)
* **PostgreSQL**(main DBMS for this project)
* Maven(package manager to build .war-file and manipulate with dependencies)
* Docker(for run the application in container)
* OpenAPI(Swagger 3.0)
* Lombok

## Часть 1.

* Требуется спроектировать БД для сайта интернет-магазина.
У сайта есть категории, которые могут быть вложены друг в друга. В категориях находятся товары, при этом, один товар, может принадлежать различным категориям. 
Также, на сайте есть личный кабинет покупателя. Покупатели могут регистрироваться на сайте. У покупателя могут быть заказы, в которых есть товары.

**1. Решения находятся в следующих файлах проекта:**

```bash
online_store_first_task_db_scheme.png

create-tables-first-task.sql
```

## Часть 2. 

Нужно, используя Spring Boot, сделать макет сервиса сбора статистики, который имеет 2 метода:

1. Метод POST, который позволяет добавить информацию о новом событии, с типизацией по классификатору
2. Метод GET, который выводит список событий, сортированный и сгруппированный по дням с возможностью фильтрации по классификатору. 
Метод должен иметь паджинацию

* Сервис имеет классификатор (отдельный список возможных типов событий). Классификатор в будущем может дополняться
* Сервис нужно сделать используя Spring Boot 
* Сервис в дальнейшем планируется  развивать и расширять
* Базу данных можно использовать любую реляционную

## Шаги для запуска приложения

**1. Клонировать приложжение с репозитория**

```bash
git clone https://github.com/AlekseiKalashnik/online-store.git
```

**2. Создать БД PostgreSQL**

```bash
create database online_store
```

**3. Назначить логин и пароль для доступа к БД**

+ файл `src/main/resources/application.properties`
+ внести изменения в `spring.datasource.username` и `spring.datasource.password` в соответствии с вашими настройками PostgreSQL


**4. Запуск:**

+ используя maven

```bash
mvn spring-boot:run
```

+ используя docker

```bash
maven install

docker build --platform linux/amd64 -t online-store-app .

docker run -p 8080:8080 -t online-store-app
``` 
**4. Доступ к API:**

Используя браузер
+ http://localhost:8080/swagger-ui/index.html#/event-controller

Используя Postman
+ http://localhost:8080/api/v1/events/addEvent
+ http://localhost:8080/api/v1/events/{pageNumber}/{pageSize}
+ http://localhost:8080/api/v1/events/{pageNumber}/{pageSize}/{classifier}
