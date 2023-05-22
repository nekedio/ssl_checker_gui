# SSL checker GUI

Гуевая прога для проверки актуальности ssl сертификатов на сайтах нашей компании. Хотя проверить можно любые.

Для запуска необходима java 8 или выше.

Последний релиз можно скачать по ссылке: [ssh-checker-1.0.jar](http://git.tatmedia.com/tatmedia/ssl-checker-gui/-/raw/main/ssh-checker-1.0.jar)

Список доменов, по которым идет проверка в файле:
[list_domen.py](http://git.tatmedia.com/tatmedia/checking-ssl/-/blob/main/list_domen.py)


## Установка Java для Windows.
1) Качаем установщик Java отсюда: https://www.java.com/ru/download/manual.jsp (Выбираем "Windows Автономный режим (64-разрядная)")
2) Нажимаем на скачанный файл
3) Открывается установщик, тыкаем на кнопку "Install"
4) Дожидаемся окончания установки
4) Java установлена

## Установка Java для Linux.
https://www.java.com/ru/download/help/index_installing.html

## Запуск на Windows:
Два раза кликнуть по файлу с расширением .jar

## Запуск на Linux:
```
java -jar ssh-checker-1.0.jar
```
или
```
chmod -R 777 ssh-checker*.jar
```
и запускать двойным надатием из гуи.

