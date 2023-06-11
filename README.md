# interview-assignment
repo for an take home interview assignment

#Prompt:
You are given a RESTful endpoint /movies that returns a list of movies in JSON format. Your task is to create a Spring Boot application that consumes this endpoint and exposes a new endpoint
/recommendations that returns a list of recommended movies based on the user's preferences.
The /recommendations endpoint should accept a query parameter
genre that contains the user's preferred movie genre. The endpoint should return a list of movies that belong to the specified genre, sorted by release year in descending order.
The movie model is defined as follows:
public class Movie {
private Long id;
private String title;
private String genre;
private int releaseYear;
private String director;

// getters and setters
}
The /movies endpoint returns a JSON array of movies:
[
{
"id": 1,
"title": "The Shawshank Redemption",
"genre": "Drama",
"releaseYear": 1994,
"director": "Frank Darabont"
},
{
"id": 2,
"title": "The Godfather",
"genre": "Drama",
"releaseYear": 1972,
"director": "Francis Ford Coppola"
},
{
"id": 3,
"title": "The Dark Knight",
"genre": "Action",
"releaseYear": 2008,
"director": "Christopher Nolan"
}
]
The /recommendations endpoint should return a JSON array of recommended movies:
[
{
"id": 3,
"title": "The Dark Knight",
"genre": "Action",
"releaseYear": 2008,
"director": "Christopher Nolan"
},
{
"id": 6,
"title": "The Matrix",
"genre": "Action",
"releaseYear": 1999,
"director": "The Wachowskis"
}
]

#Assumptions:

* the movies endpoint is not secured (simply used a RestTemplate without any auth config).
* the movies endpoint returns the full list of movies and it's our services's responsibility to filter it.

#Design choices:

While designing and implementing this, the main objective is to have something working without taking a long time since this is an assignment that I chose to time box in 2 hours maximum,
for the sake of keeping it simple, a few things are omitted that I would've implemented if this was meant as a prod ready api:
* No security configuration (auth, rate limiting etc...).
* No logging.
* No extensive exception handling (only one exception implemented, and no custom spring ExceptionHandler.
* No extensive unit tests.
* hardcoded api url and paths etc.. (it should be in a .properties file)

