# Работа с MySQL

## 1.  В ранее подключенном MySQL создать базу данных с названием "Human Friends".

```
CREATE DATABASE IF NOT EXISTS HumanFriends;  
USE HumanFriends;
```

## 2.  Создать таблицы, соответствующие иерархии из вашей диаграммы классов.

```
CREATE TABLE Pets (  
    ID INT AUTO_INCREMENT PRIMARY KEY,  
    Name VARCHAR(255) NOT NULL,  
    Type VARCHAR(255) NOT NULL,  
    BirthDate DATE NOT NULL,  
    Commands VARCHAR(255)  
);
```

```
CREATE TABLE PackAnimals (  
    ID INT AUTO_INCREMENT PRIMARY KEY,  
    Name VARCHAR(255) NOT NULL,  
    Type VARCHAR(255) NOT NULL,  
    BirthDate DATE NOT NULL,  
    Commands VARCHAR(255)  
);
```

## 3. Заполнить таблицы данными о животных, их командах и датами рождения.

```
INSERT INTO Pets (Name, Type, Birthdate, Commands)  
VALUES  
    ('Жучка', 'Собака', '2019-05-10', 'Сидеть, Стоять, Фас'),  
    ('Муся', 'Кошка', '2020-02-15', 'Ловить мышей, Сидеть'),  
    ('Хома', 'Хомяк', '2018-11-20', 'Перекат');
```

```
INSERT INTO PackAnimals (Name, Type, Birthdate, Commands)  
VALUES  
    ('Пегас', 'Лошадь', '2017-08-25', 'Голоп, На дыбы'),  
    ('Терпила', 'Верблюд', '2016-10-12', 'Нести груз'),  
    ('Крикун', 'Осел', '2018-04-30', 'Нести груз, кричать');
```

## 4. Удалить записи о верблюдах и объединить таблицы лошадей и ослов.

``` DELETE FROM PackAnimals WHERE Type = 'Верблюд'; ```

```
CREATE TABLE HorseAndCamel AS  
SELECT * FROM PackAnimals;
```

## 5. Создать новую таблицу для животных в возрасте от 1 до 3 лет и вычислить их возраст с точностью до месяца.

```
CREATE TABLE YoungAnimals AS  
SELECT  
    ID,  
    Name,  
    Type,  
    BirthDate,  
    TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) AS AgeYears,  
    TIMESTAMPDIFF(MONTH, BirthDate, CURDATE()) % 12 AS AgeMonths  
FROM Pets  
WHERE TIMESTAMPDIFF(YEAR, BirthDate, CURDATE()) BETWEEN 1 AND 3;
```

## 6. Объединить все созданные таблицы в одну, сохраняя информацию о принадлежности к исходным таблицам.

```
CREATE TABLE AllAnimals AS  
(  
SELECT  
    ID,  
    Name,  
    Type,  
    BirthDate,  
    Commands,  
    'Pets' AS SourceTable FROM Pets  
)  
UNION ALL  
(  
SELECT  
    ID,  
    Name,  
    Type,  
    BirthDate,  
    Commands,  
    'PackAnimals' AS SourceTable FROM PackAnimals  
)  
UNION ALL  
(  
SELECT  
    ID,  
    Name,  
    Type,  
    BirthDate,  
    NULL AS Commands,  
    'HorseAndCamel' AS SourceTable FROM HorseAndCamel  
)  
UNION ALL  
(  
SELECT  
    ID,  
    Name,  
    Type,  
    BirthDate,  
    NULL AS Commands,  
    'YoungAnimals' AS SourceTable FROM YoungAnimals  
);
```