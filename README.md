# FoodOrderingAppBackend

Instruction to setup project

1. git clone https://github.com/swaroopmalladidev/food-ordering-app-backend

2. open project in intelliji and chose folder FoodOrderingAppBackend

3. start postgres and create db with name "restaurantdb"

4. on intellij terminal got to FoodOrderingAppBackend/ and run

	mvn clean install -Psetup -DskipTests

	it will create tables in db

5. make db user name as "postgres" and password as "postgres"

FoodOrderingAppBackend/FoodOrderingApp-api/src/main/resources/application.yaml should have

driverClassName: org.postgresql.Driver
url: jdbc:postgresql://localhost:5433/restaurantdb
username: postgres
password: postgres


FoodOrderingAppBackend/FoodOrderingApp-db/src/main/resources/config/localhost.properties should have
server.port=5433
server.host=localhost
database.name=restaurantdb
database.username=postgres
database.password=postgres

6. on intellij terminal got to FoodOrderingAppBackend and run 
	mvn clean install -DskipTests

7. FoodOrderingAppBackend/FoodOrderingApp-api/src/main/java/com/upgrad/FoodOrderingApp/api/FoodOrderingAppApiApplication.java
	Run Above Application

8. open url http://localhost:8080/api/swagger-ui.html
