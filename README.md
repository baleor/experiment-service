# Experiment Service

A lightweight Spring Boot service for evaluating A/B experiments. It determines which variant a user should receive using deterministic bucketing logic.

---

## 🛠 How to Build

### Prerequisites

* Java 17+
* Maven
* Docker (optional)

### Build using Maven

```bash
git clone https://github.com/baleor/experiment-service.git
cd experiment-service
mvn clean install
```

---

### 🐳 Build using Docker

```bash
docker build -t experiment-service .
```

---

## ▶️ How to Run

### Run using Maven

```bash
mvn spring-boot:run
```

---

### Run using JAR

```bash
java -jar target/experiment-service.jar
```

---

### 🐳 Run using Docker

```bash
docker run -p 8080:8080 experiment-service
```

---

Service will be available at:

```
http://localhost:8080
```

---

## ⚡ How to Trigger Core Functionality

### Evaluate Experiment (Core Endpoint)

```bash
curl "http://localhost:8080/experiments/evaluate?userId=user-123&experimentKey=new-ui-test"
```

### Sample Response

```json
{
  "variant": "A"
}
```

### Behavior

* The same `userId` will always receive the same variant
* Variant assignment is deterministic
* No state is stored for user assignments

---

## 🧠 Architecture & Design Decisions

### 1. Stateless Design

* No user session or assignment storage
* Each request is independently evaluated
* Enables horizontal scalability

---

### 2. Deterministic Bucketing

* Uses a hashing strategy based on:

    * `userId`
    * `experimentKey`
* Guarantees:

    * Consistent variant assignment
    * No need for database storage

---

### 3. Single Responsibility Service

* Focused only on **evaluation logic**
* Keeps API surface minimal and fast
* Can be easily integrated into larger systems

---

### 4. Microservice Friendly

* Exposes a simple REST endpoint
* Can be called by frontend or backend services
* Decouples experimentation logic from business services

---

### 5. Trade-offs

* No persistence layer for experiment configuration
* No dynamic experiment creation (static or config-driven)
* No analytics or tracking of experiment results

---

### 6. Extensibility

Can be extended to support:

* Database-backed experiment configurations
* Redis caching for faster access
* Targeted rollouts (user segments)
* Experiment metrics and analytics
* Authentication & authorization

---

## 🚀 Future Improvements

* Add dynamic experiment configuration
* Introduce caching layer (Redis)
* Add observability (metrics/logging)
* Container orchestration (Kubernetes)

---
