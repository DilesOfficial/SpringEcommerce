# ⚙️ Diles E-Commerce (Spring Boot Backend API)

**A robust, enterprise-grade RESTful API powering premium tech gear & exclusive shopping experiences.**

<br/>

![E-Commerce Full Stack Showcase](/Users/dilushaeshan/.gemini/antigravity/brain/819f3177-e8e1-4b65-97ee-611b53b5b20c/ecommerce_showcase_1776534994989.webp)
*A look at the beautifully crafted React/Tailwind Frontend seamlessly consuming this Spring Boot API.*

<br/>

### Built With Modern Backend Tech Stack
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=java&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badge&logo=postgresql&logoColor=white)
![React](https://img.shields.io/badge/React-20232A?style=for-the-badge&logo=react&logoColor=61DAFB)
![TailwindCSS](https://img.shields.io/badge/Tailwind_CSS-38B2AC?style=for-the-badge&logo=tailwind-css&logoColor=white)

---

## 📖 Architecture Overview
Diles E-Commerce represents the backbone of a high-performance web application. Developed in **Java 21**, this backend leverages the robust **Spring Boot** framework engineered to handle intensive e-commerce operations. 

Data persistence is managed cleanly through **Spring Data JPA & Hibernate**, securely querying and writing to a lightning-fast **PostgreSQL** relational database. The architecture is cleanly separated into Controllers, Services, and Repositories, ensuring highly scalable and maintainable REST APIs.

## ✨ Core Backend Features
- **Advanced JPA Entity Management**: Efficient database relationships mapping products, orders, and cart items directly to PostgreSQL schema configurations.
- **RESTful API Ecosystem**: Fully functional endpoints conforming to REST standards, allowing operations (`GET`, `POST`, `PUT`, `DELETE`) for complete product life cycle management.
- **Live Search Query Optimizations**: Real-time keyword processing that drives instant autocompletion on the frontend, ensuring rapid data retrieval.
- **Multipart Data Handling**: Powerful BLOB payload support over `FormData` designed specifically to ingest and serve custom product images in real time directly from the PostgreSQL store.
- **Cross-Origin Configuration**: Granular CORS management allowing the modern React + Vite decoupled frontend architecture to consume data seamlessly.

## 🚀 Getting Started

### Prerequisites
- Java 21+ & Maven 
- PostgreSQL
- Node.js (v18+) (For testing the visual frontend client)

### Running the Backend (Spring Boot)
1. Ensure your local PostgreSQL server is running.
2. Configure your PostgreSQL credentials in `src/main/resources/application.properties`:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/yourecommercedb
   spring.datasource.username=postgres
   spring.datasource.password=yourpassword
   spring.jpa.hibernate.ddl-auto=update
   ```
3. Run the Spring Boot application using Maven or execute `SpringEcommerceApplication.java` in your IDE (IntelliJ/Eclipse).

### Running the Associated Client (Frontend)
1. Navigate to the frontend repository (e.g. `t-ecom` folder).
2. Install dependencies: `npm install`
3. Ensure `.env` is pointing to the Spring API: `VITE_BASE_URL=http://localhost:8080`
4. Start the frontend development server: `npm run dev`
