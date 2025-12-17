# mongo
spring boot application with mongo db atlas
# MongoDB Spring Boot Application

This is a Spring Boot application that connects to **MongoDB Atlas**, the fully managed cloud database service. The application demonstrates how to interact with the sample `sample_mflix` database provided by MongoDB Atlas.

## Features

- **MongoDB Atlas Integration**: Easily connect your Spring Boot app to MongoDB Atlas.
- **Sample Database**: Access and interact with the `sample_mflix` database for learning and development purposes.
- **Coding Examples**: Provides detailed implementation on how to configure and perform database operations.

---

## Prerequisites

1. **Java**: Ensure that Java (version 11 or higher) is installed.
2. **MongoDB Atlas Cluster**:
   - Create an account on [MongoDB Atlas](https://www.mongodb.com/cloud/atlas).
   - Deploy a cluster, and make sure the `sample_mflix` dataset is loaded.
   - Whitelist your IP address in the MongoDB Atlas dashboard.
   - Gather the connection string for your MongoDB Atlas cluster.

3. **Build Tool**: The application uses **Maven** to manage dependencies.
4. Additional tools, such as Docker (optional), for containerized deployments.

---

## Application Setup

1. **Clone the Repository**:
   ```bash
   git clone https://github.com/subirsingh/mongo.git
   cd mongo
   ```

2. **Configure MongoDB Connection**:
   Update the `application.properties` (or `application.yml`) file to include the MongoDB connection string. Example:
   ```properties
   spring.data.mongodb.uri=mongodb+srv://<username>:<password>@cluster0.mongodb.net/sample_mflix
   ```
   Replace `<username>` and `<password>` with your MongoDB Atlas credentials.

3. **Build the Project**:
   Use Maven to build and package the project:
   ```bash
   mvn clean install
   ```

4. **Run the Application**:
   Start the Spring Boot application:
   ```bash
   mvn spring-boot:run
   ```

5. Access the application locally at `http://localhost:8080`.

---

## Code Examples

Here are some examples of common operations performed in the `sample_mflix` database.

### 1. MongoRepository Interface
The application uses Spring Data MongoDB's `MongoRepository` to interact with the database. For instance:
```java
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    List<Movie> findByTitle(String title);
}
```

### 2. Reading Movies
```java
@Autowired
private MovieRepository movieRepository;

public List<Movie> getMoviesByTitle(String title) {
    return movieRepository.findByTitle(title);
}
```

### 3. Saving Operations
```java
Movie movie = new Movie();
movie.setTitle("Inception");
movieRepository.save(movie);
```

---

## Example REST Endpoints

### 1. Fetch All Movies
**GET** `/api/movies`

### 2. Search Movies by Title
**GET** `/api/movies?title=Inception`

### 3. Add a New Movie
**POST** `/api/movies`
```json
{
  "title": "Inception",
  "year": 2010
}
```

---

## Dependencies

The project includes the following key dependencies:

- **Spring Boot Starter Web**: To build RESTful web services.
- **Spring Data MongoDB**: For MongoDB integration.
- **Lombok**: Reduces boilerplate code by auto-generating getters, setters, etc.

Dependencies are managed in the `pom.xml` file.

---

## References

- [MongoDB Atlas Documentation](https://www.mongodb.com/docs/atlas/)
- [Spring Data MongoDB Documentation](https://spring.io/projects/spring-data-mongodb)

---

## Contributing

Contributions are welcome! Feel free to fork this repository, create a branch, and submit a pull request.

---

## License

This project is licensed under the [MIT License](LICENSE).
