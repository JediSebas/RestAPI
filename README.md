# RestAPI
Amazing API

## Run project
Clone this project into your local directory

``git clone https://github.com/JediSebas/RestAPI.git``

Then go into

``cd RestAPI``

And run with this command

``mvn spring-boot:run``

## Run docker

``./mvnw clean install``

``docker build -t rest-api``

``docker run -dp 8080:8080 rest-api``
