create-jar:
	./mvnw clean compile package install

run: create-jar
	java -jar target/ssh-checker.jar

update-config:
	git clone git@git.tatmedia.com:tatmedia/checking-ssl.git temp
	cp ./temp/list_domen.py .
	rm -rf temp
	mv list_domen.py config
	sed -i 's/def domens():/hosts = /' config
	sed -i 's/return \[//' config
	sed -i 's/\]//' config
	sed -i 's/\"//' config
	sed -i 's/\"//' config
	sed -i 's/\ //' config
	sed -i s/' '//g config
	sed -i '/^$$/d' config
	cat config | tr -d '\r\n' >> config.temp
	mv config.temp src/main/resources/app.properties
	rm config

