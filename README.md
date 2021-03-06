# tennis-api-backend
This Spring Boot application defines the REST endpoints of the API. Data persistence is implemented using PostgreSQL, and JdbcTemplate is used to work with the database.

Maven is used for project management. Heroku was used for deployment of the application and the database. As recommended by Heroku, this project was compiled with Java 8.

Postgres database was setup using the available CSV files from Jeff Sackmann (see license below). Some relations were also made using the data from api calls made to [https://rapidapi.com/sportcontentapi/api/tennis-live-data/](https://rapidapi.com/sportcontentapi/api/tennis-live-data/). 

# License
[![](https://camo.githubusercontent.com/f05d4039b67688cfdf339d2a445ad686a60551f9891734c418f7096184de5fac/68747470733a2f2f692e6372656174697665636f6d6d6f6e732e6f72672f6c2f62792d6e632d73612f342e302f38387833312e706e67)](http://creativecommons.org/licenses/by-nc-sa/4.0/)

Tennis databases, files, and algorithms by [Jeff Sackmann / Tennis Abstract](http://www.tennisabstract.com/) is licensed under a [Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International License](http://creativecommons.org/licenses/by-nc-sa/4.0/).
Based on a work at [https://github.com/JeffSackmann](https://github.com/JeffSackmann).

In other words: Attribution is required. Non-commercial use only.
