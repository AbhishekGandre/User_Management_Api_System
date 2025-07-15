<!DOCTYPE html>
<html lang="en">

<body style="font-family: Arial, sans-serif; line-height: 1.6; margin: 40px;">

  <h1 style="color: #2c3e50;">👤 Spring Boot JPA User Management System API</h1>

  <p>
    This project is a simple <strong>User Management REST API</strong> built using
    <strong>Spring Boot</strong>, <strong>Spring Data JPA</strong>, and <strong>H2/MySQL</strong> database.
    It provides endpoints to create, read, update, and delete users.
  </p>

  <h2 style="color: #2c3e50;">🖼️ Architecture Diagram</h2>
  <img src="https://github.com/AbhishekGandre/User_Management_Api_System/blob/main/Spring%20Boot%20Project%20Structure.PNG"
       alt="Spring Boot JPA Architecture"
       style="max-width: 100%; border: 1px solid #ccc; border-radius: 4px;" />

  <h2 style="color: #2c3e50;">🧱 Tech Stack</h2>
  <ul>
    <li>Java 17+</li>
    <li>Spring Boot</li>
    <li>Spring Data JPA</li>
    <li>MySQL or H2 (in-memory)</li>
    <li>Maven</li>
  </ul>

  <h2 style="color: #2c3e50;">📁 Project Structure</h2>
  <ul>
    <li><code>entity/</code> - User entity class</li>
    <li><code>repository/</code> - JPA repository interface</li>
    <li><code>controller/</code> - REST APIs</li>
    <li><code>service/</code> - Business logic</li>
    <li><code>Application.java</code> - Spring Boot main app</li>
  </ul>

  <h2 style="color: #2c3e50;">🧾 application.properties</h2>
  <pre style="background: #f4f4f4; padding: 10px; border-radius: 5px;"><code>
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.hibernate.ddl-auto=update
  </code></pre>

  <h2 style="color: #2c3e50;">🌐 API Endpoints</h2>
  <table border="1" cellpadding="8">
    <thead>
      <tr>
        <th>Method</th>
        <th>Endpoint</th>
        <th>Description</th>
      </tr>
    </thead>
    <tbody>
      <tr>
        <td>POST</td>
        <td>/api/users</td>
        <td>Create a new user</td>
      </tr>
      <tr>
        <td>GET</td>
        <td>/api/users</td>
        <td>Get all users</td>
      </tr>
      <tr>
        <td>GET</td>
        <td>/api/users/{id}</td>
        <td>Get user by ID</td>
      </tr>
      <tr>
        <td>PUT</td>
        <td>/api/users/{id}</td>
        <td>Update user</td>
      </tr>
      <tr>
        <td>DELETE</td>
        <td>/api/users/{id}</td>
        <td>Delete user</td>
      </tr>
    </tbody>
  </table>



  <h2 style="color: #2c3e50;">✅ Features</h2>
  <ul>
    <li>CRUD operations for user management</li>
    <li>JPA with H2/MySQL support</li>
    <li>RESTful API structure</li>
    <li>Can be extended with JWT, Swagger, etc.</li>
  </ul>

  <h2 style="color: #2c3e50;">📜 License</h2>
  <p>MIT License</p>

</body>
</html>
