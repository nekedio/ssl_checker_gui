# SSL checker GUI

Гуевая прога для проверки актуальности ssl сертификатов и срока действия доменов.  
Для запуска необходима java 8 или выше.  
Последний релиз можно скачать по ссылке: [ssh-checker-2.0.jar](http://git.tatmedia.com/tatmedia/ssl-checker-gui/-/raw/main/ssh-checker-2.0.jar)  
Версия без проверки срока домена: [ssh-checker-1.0.jar](http://git.tatmedia.com/tatmedia/ssl-checker-gui/-/raw/main/ssh-checker-1.0.jar)  
Список доменов, по которым идет проверка в файле:
[list_domen.py](http://git.tatmedia.com/tatmedia/checking-ssl/-/blob/main/list_domen.py)


## Установка Java для Windows.
1) Качаем установщик Java отсюда: https://learn.microsoft.com/en-us/java/openjdk/download (Выбираем OpenJDK 17.0.7 LTS "microsoft-jdk-17.0.7-windows-aarch64.msi")
2) Нажимаем на скачанный файл
3) Открывается установщик, тыкаем на кнопку "Install"
4) Дожидаемся окончания установки
4) Java установлена

## Установка Java для Linux.
https://linuxways.net/debian/how-to-install-java-17-lts-jdk-17-on-debian-11/

## Запуск:
Два раза кликнуть по файлу с расширением .jar

```
java -jar ssh-checker*.jar
```
