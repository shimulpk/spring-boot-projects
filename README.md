# Spring Boot Projects

A collection of Spring Boot projects and applications built for learning and practice purposes.

## 📋 Overview

This repository contains multiple Spring Boot applications demonstrating best practices and modern development patterns using Java and Spring framework ecosystem.

## 🗂️ Projects

### GarmentsManagementSystem

A comprehensive Spring Boot application for managing garments inventory and business operations.

**Technology Stack:**
- **Framework:** Spring Boot 4.0.6
- **Language:** Java 17
- **Build Tool:** Maven
- **Database:** MySQL
- **ORM:** Spring Data JPA
- **Security:** Spring Security with JWT Authentication
- **API Documentation:** Swagger/OpenAPI
- **Utilities:** Lombok for reducing boilerplate code

**Key Features:**
- RESTful API endpoints
- JWT-based authentication and authorization
- Email notifications (Jakarta Mail)
- Data validation and error handling
- Swagger API documentation
- Unit testing support
- Development tools integration (Spring DevTools)

**Dependencies:**
- Spring Boot Starter Data JPA (for database operations)
- Spring Boot Starter Web/WebMVC (for REST APIs)
- Spring Boot Starter Security (for authentication)
- Spring Boot Starter Mail (for email functionality)
- Spring Boot Starter Validation (for input validation)
- JWT (jjwt) for token management
- SpringDoc OpenAPI for API documentation
- Lombok for code generation
- MySQL Connector for database connectivity

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL Server

### Installation & Setup

1. **Clone the repository:**
   ```bash
   git clone https://github.com/shimulpk/spring-boot-projects.git
   cd spring-boot-projects
   ```

2. **Navigate to a project:**
   ```bash
   cd GarmentsManagementSystem
   ```

3. **Build the project:**
   ```bash
   mvn clean install
   ```

4. **Configure Database:**
   - Update `application.properties` or `application.yml` with your MySQL database credentials
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/garments_db
   spring.datasource.username=root
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

5. **Run the application:**
   ```bash
   mvn spring-boot:run
   ```
   or
   ```bash
   ./mvnw spring-boot:run  # On Linux/Mac
   mvnw.cmd spring-boot:run  # On Windows
   ```

6. **Access the application:**
   - API: `http://localhost:8080`
   - Swagger UI: `http://localhost:8080/swagger-ui.html`
   - API Docs: `http://localhost:8080/v3/api-docs`

## 📚 Project Structure

```
spring-boot-projects/
├── README.md
└── GarmentsManagementSystem/
    ├── src/
    │   ├── main/
    │   │   ├── java/
    │   │   └── resources/
    │   └── test/
    ├── .mvn/
    ├── pom.xml
    ├── mvnw
    └── mvnw.cmd
```

## 🔧 Configuration

### Application Properties

Key configuration parameters:

```properties
# Server
server.port=8080
server.servlet.context-path=/api

# Database
spring.datasource.url=jdbc:mysql://localhost:3306/garments_db
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
spring.jpa.hibernate.ddl-auto=update

# JWT
app.jwt.secret=your_secret_key
app.jwt.expiration=86400000

# Mail
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=your_app_password
```

## 🧪 Testing

Run tests using Maven:

```bash
mvn test
```

## 📖 API Documentation

The project uses Swagger/OpenAPI for API documentation. Once the application is running, access the interactive API documentation at:

- **Swagger UI:** `http://localhost:8080/swagger-ui.html`
- **OpenAPI JSON:** `http://localhost:8080/v3/api-docs`

## 🔐 Security

- **Authentication:** JWT (JSON Web Tokens)
- **Password Security:** Spring Security with bcrypt encoding
- **Authorization:** Role-based access control (RBAC)

## 🛠️ Development

### Code Style
- Uses Lombok to reduce boilerplate code
- Follows Spring Boot conventions

### IDE Setup
- IntelliJ IDEA: Recommended with Spring Boot plugins
- Eclipse: Requires Spring Tools Suite (STS)
- VS Code: With Spring Boot Extension Pack

### Hot Reload
Spring DevTools is included for automatic restart during development:
```bash
mvn spring-boot:run
```

## 📝 License

This project is open source and available under the MIT License.

## 👤 Author

**Shimul PK**
- GitHub: [@shimulpk](https://github.com/shimulpk)

## 🤝 Contributing

Contributions are welcome! Feel free to:
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## 📧 Support

For support, email or open an issue in the repository.

## 📚 Resources

- [Spring Boot Official Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Spring Security](https://spring.io/projects/spring-security)
- [JWT (jjwt)](https://github.com/jwtk/jjwt)
- [Lombok](https://projectlombok.org/)
- [MySQL Documentation](https://dev.mysql.com/doc/)

---

**Last Updated:** August 2026
