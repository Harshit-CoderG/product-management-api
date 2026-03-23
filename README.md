# 📦 Product Management System API

> A production-ready **Spring Boot REST API** that enables secure product management with authentication, role-based architecture, and scalable backend design.

---

## 🚀 Why This Project Stands Out

This project demonstrates:

* ✅ Clean layered architecture (Controller → Service → Repository)
* 🔐 Secure authentication using Spring Security + BCrypt
* 🛡️ Role-based database design (Users & Roles)
* 📊 Pagination, Sorting & Filtering
* 🛠️ Database versioning using Flyway
* ⚠️ Global Exception Handling
* 📄 API Documentation using Swagger

---

## 🛠️ Tech Stack

* Java
* Spring Boot
* Spring Security (Basic Auth + BCrypt)
* Spring Data JPA
* MySQL
* Lombok
* Flyway
* Swagger (OpenAPI)

---

## 📸 API Documentation (Swagger UI)

### 🔹 Swagger Dashboard

![Swagger UI](./assets/swagger-home.png)

### 🔹 Register User API

![Register API](./assets/register-api.png)

### 🔹 Register Response (BCrypt Encrypted Password)

![Register Response](./assets/register-response.png)

### 🔹 Login API

![Login API](./assets/login-api.png)

### 🔹 Login Response

![Login Response](./assets/login-response.png)

---

## 🔐 Authentication Flow

1. User registers via `/auth/register`
2. Password is encrypted using BCrypt
3. User logs in via `/auth/login`
4. Spring Security validates credentials from DB

---

## 🗄️ Database Design

### 🧑 Users

* Stores credentials
* Linked to roles
* Password stored as BCrypt hash

### 🛡️ Roles

* Defines access level (ADMIN / USER)

### 📦 Products

* Core business entity

### 🔗 Relationships

* One Role → Many Users
* Products are independent

---

## 🔗 API Endpoints

### 🔐 Auth APIs

| Method | Endpoint         |
| ------ | ---------------- |
| POST   | `/auth/register` |
| POST   | `/auth/login`    |

---

### 📦 Product APIs

| Method | Endpoint                                             |
| ------ | ---------------------------------------------------- |
| POST   | `/product/saveProduct`                               |
| POST   | `/product/saveMultiple`                              |
| GET    | `/product/getProductById/{prodId}`                   |
| GET    | `/product/getAllProduct`                             |
| PUT    | `/product/update`                                    |
| DELETE | `/product/deleteProduct/{id}`                        |
| GET    | `/product/findByPrice/{price}`                       |
| GET    | `/product/sortProductByAttributeAsc/{attributeName}` |
| GET    | `/product/paginationProduct/{pageNumber}`            |

---

## 🧠 Architecture

```
Controller → Service → Repository → Database
```

* Clean separation of concerns
* Scalable & maintainable

---

## ⚙️ Setup Instructions

```bash
git clone https://github.com/your-username/product-management-api.git
cd product-management-api
mvn spring-boot:run
```

---

## 🔧 Configuration

```
src/main/resources/application.properties
```

* MySQL configuration
* Server port: 8383
* JPA & Flyway configs

---

## 🛠️ Flyway Migration

```
src/main/resources/db/migration
```

* Auto DB version control
* Ensures schema consistency

---

## 📈 Future Improvements

* 🔑 JWT Authentication
* 🧑‍💻 Role-Based Authorization (RBAC)
* 🐳 Docker Deployment
* ☁️ Cloud Deployment (AWS / Render)

---

## 🧑‍💻 Author

**Harshit**  
Backend Developer | Java | Spring Boot

---

## ⭐ Support

If you like this project:

* ⭐ Star the repo
* 🔁 Share on LinkedIn
* 🤝 Contribute to improve it
