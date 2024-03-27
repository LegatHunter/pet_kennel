# Операционные системы и виртуализация (Linux)

## 1. Использование команды cat в Linux

### Создать два текстовых файла: "Pets"(Домашние животные) и "Pack animals"(вьючные животные), используя команду `cat` в терминале Linux. В первом файле перечислить собак, кошек и хомяков. Во втором — лошадей, верблюдов и ослов.

```
    cat > Pets.txt
    Собаки
    Кошки
    Хомяки
    ^D
```

```
    cat > PackAnimals.txt
    Лошади
    Верблюды
    Ослы
    ^D
```

### Объединить содержимое этих двух файлов в один и просмотреть его содержимое.

```
    cat Pets.txt PackAnimals.txt > Animals.txt
    cat Animals.txt
```

> Собаки  
> Кошки  
> Хомяки  
> Лошади  
> Верблюды  
> Ослы  

### Переименовать получившийся файл в "Human Friends".

```
    mv Animals.txt HumanFriends.txt
```

## 2. Работа с директориями в Linux

### Создать новую директорию и переместить туда файл "Human Friends".

```
    mkdir Pets
    mv HumanFriends.txt Pets/
```

## 3. Работа с MySQL в Linux. “Установить MySQL на вашу вычислительную машину ”

### Подключить дополнительный репозиторий MySQL и установить один из пакетов из этого репозитория.
- Скачиваем deb пакет с конфигурацией репозитория
- Устанавливаем `sudo dpkg -i /home/gb/Загрузки/mysql-apt-config_0.8.29-1_all.deb`
- Отвечаем на несколько вопросов установщика  
-`sudo apt update`  
-`sudo apt install mysql-server mysql-client`  
-`sudo systemctl start mysql`  
-`sudo systemctl status mysql`  

## 4. Управление deb-пакетами

### Установить и затем удалить deb-пакет, используя команду dpkg.

```
    sudo dpkg -i some.deb
    sudo dpkg -r some
```
## 5. История команд в терминале Ubuntu

`history > command_history.txt`

> Я решил сделать в файле md, т.к. так будет нагляднее
