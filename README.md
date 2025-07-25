# Backend API - Spring Boot (Java 19 + PostgreSQL)
This project is a backend implementation using Spring Boot with Java 19, consisting of three main API modules:
1. **Report Transaction**

All data is stored in a PostgreSQL database and can be tested via the provided Postman documentation.

---

## Technologies Used

- **Java 19**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Lombok**
- **Postman (for API testing and documentation)**

---

## Modul API
### 1. Report Transaction
Provides endpoints to manage available items.

endpoint:
- `GET /api/report/sale?start=2025-07-24&end=2025-07-24`
#### 📤 Sample Response

```json
[
  {
  "id": 1,
  "no": 1,
  "productId": 1,
  "productName": "Pena",
  "productType": "Alat Tulis",
  "price": 10000,
  "margin": 50000
  },
  {
  "id": 2,
  "no": 2,
  "productId": 2,
  "productName": "Pensil",
  "productType": "Alat Tulis",
  "price": 7000,
  "margin": 35000
  }
 ] 
```
---

## Setup and Running the Application

### Prerequisites
- Java 19
- PostgreSQL (configured appropriately in application-dev.properties)
- Maven atau Gradle

### Langkah Menjalankan

```bash
# Clone repository
git clone https://github.com/rizkyyananda/test_gtech.git
cd <project-directory>
```
# Jalankan aplikasi (menggunakan Maven)
- set profile to dev before run
- ./mvnw spring-boot:run or right click on TestApplication.java and press **RUN** 
- application running on port 9090
- dump database: https://drive.google.com/file/d/1wbBMsWRJJXw_hW8FfPyNDsuovN_9FFfY/view?usp=sharing
