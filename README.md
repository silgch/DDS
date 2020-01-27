# UTN BA - Diseño de Sistemas 2019

## Team 11 Members:
* Micolucci Leandro
* Gomez Cheda Silvina

## Project Description:
* Runtime Environment: **Java 8**
* Build Automation Tool: **Maven**
* Database: **JawsDB MySQL Database**
* Web Framework: **Spark**
* Template Engine: **Apache Velocity**
* Web Application Host: **Heroku**
* Link: [https://spark-heroku-dds-grupo11.herokuapp.com/](https://spark-heroku-dds-grupo11.herokuapp.com/)

## For Testing:
1. Import to Eclipse
2. Find project, right click in it: Maven -> Update Project
3. Find project, right click in it: Run As -> Maven Build... -> goals: clean install, check "Skip Tests"

## Understanding The Project:
```
C:\**\GIT\DDS\SRC
├───main
│   ├───java
│   │   │   Fachada.java
│   │   │   SparkApp.java
│   │   │   VelocityTemplateEngine.java
│   │   ├───climaAPI
│   │   ├───componentes
│   │   ├───eventos
│   │   ├───excepciones
│   │   ├───guardarropas
│   │   ├───main
│   │   ├───notificador
│   │   ├───repositorio
│   │   └───usuario
│   └───resources
│       ├───META-INF
│       │       persistence.xml
│       ├───public
│       │   ├───images
│       │   └───stylesheets
│       └───templates
│               calendar.html
│               detallesEventos.html
│               guardarropas.html
│               home.html
│               login.html
│               new_event.html
│               new_prenda.html
│               prendas.html
│               register.html
│               sugerencia.html
└───test
    └───java
        └───tests
```

SparkApp.java should be run to test the webpage locally though using the remote database.
When running locally the webpage is located in [http://localhost:4567/](http://localhost:4567/)

SparkApp is also used by Heroku to host the webpage

