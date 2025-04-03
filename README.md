# ⌚ Transaction Data Transfer Service

## Author: Josue Miguel Canaviri Martinez

## Description

This Spring Boot application automates the transfer of transaction data from a `TransactionDay` table to a `TransactionHistory` table in a PostgreSQL database. It utilizes Spring's scheduling capabilities to perform this transfer at a configurable interval, ensuring data archival and efficient management of the `TransactionDay` table.

## Technologies Used

* Spring Boot
* Spring Data JPA
* Spring Scheduling
* PostgreSQL
* Maven
* Docker Compose

## Architecture
* **Model:** Defines the entity classes (`TransactionDay`, `TransactionHistory`) that map to the database tables.
* **Repository:** Handles database interactions using Spring Data JPA.
* **Service:** Contains the business logic for transferring data.
* **ScheduledTask:** A Spring component that defines the scheduled job.
* **Controller:** (Optional) Exposes REST endpoints (e.g., to trigger the transfer).

## ⚒️ Setup

1.  **Prerequisites:**
    * Java Development Kit (JDK) 17
    * Maven
    * Docker
    * Docker Compose

2.  **Clone the Repository:**

    ```bash
    git clone <repository_url>
    cd <project_directory>
    ```

   3.  **Configure Database Credentials:**

       * Edit `src/main/resources/application.yml` and set the database connection properties:

       ```yaml
       spring:
         datasource:
           url: jdbc:postgresql://db:5432/your_db
           username: your_user
           password: your_password
       ```

       * Ensure these credentials match the environment variables in docker-compose.yml.

4. **Start the Database:**

    ```bash
    $ docker-compose up -d
    ```

5. **Run the Application:**
    * Run the play in IntellijIdea.

## 🚀 Execution

**Endpoints:** 

* GET http://localhost:8080/transactions-history?page=1&size=5
Accept: application/json

* GET http://localhost:8080/transactions-history
Accept: application/json

* POST http://localhost:8080/transactions-day

    Content-Type: application/json
    ```JSON
    {
    "name": "Product A",
    "nroTransaction": 1,
    "amount": 1000.50,
    "type": "DEPOSIT",
    "date": "2023-10-10"
    }
    ```

**Scripts:**
```sql
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product A', 1, 'DEPOSIT', 99.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product B', 2, 'WITHDRAWAL', 15.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product C', 3, 'TRANSFER', 43.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product D', 4, 'PAYMENT', 125.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product E', 5, 'DEPOSIT', 415.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product F', 6, 'WITHDRAWAL', 99.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product G', 7, 'TRANSFER', 14.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product H', 8, 'PAYMENT', 5.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product I', 9, 'DEPOSIT', 35.99, '2025-03-04');
INSERT INTO transaction_day(name, nro_transaction, type, amount, date)
VALUES('Product J', 10, 'WITHDRAWAL', 12.99, '2025-03-04');

```