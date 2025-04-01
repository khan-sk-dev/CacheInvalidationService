# Cache Invalidation Service

This project is a simple Cache Invalidation Service built with Spring Boot. It provides RESTful APIs to manage data operations with caching mechanisms for optimized performance.

## Features

- Retrieve data by ID with caching.
- Update data and invalidate the cache to ensure data consistency.

## Technologies Used

- Java
- Spring Boot
- Spring MVC
- Maven

## Getting Started

### Prerequisites

- Java 17 or later
- Maven 3.6+
- An IDE like IntelliJ IDEA or Eclipse

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/SohaibKhan007/CacheInvalidationService.git
   cd CacheInvalidationService
   ```

2. **Build the project:**

   ```bash
   mvn clean install
   ```

3. **Run the application:**

   ```bash
   mvn spring-boot:run
   ```

4. **Access the application:**

   The application will be running at `http://localhost:8080`.

## API Endpoints

- **GET /data/{id}**: Retrieve data by ID.
- **POST /data/{id}**: Update data and invalidate the cache.

### Request Example for Updating Data

```json
{
  "newData": "Updated content"
}
```

## Usage

- **Retrieve Data**: Fetches data from the cache or database based on the given ID.
- **Update Data**: Updates the stored data and triggers cache invalidation to ensure the latest data is served.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any improvements.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any inquiries, please contact the repository owner through GitHub.

---
