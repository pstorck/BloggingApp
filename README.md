# Blogging App #

### Summary ###
This project is a Blogging App created using Spring Boot and Thymeleaf. Users are able to create,
edit or delete blog posts, as well as commenting or deleting comments left on blog posts. 

### How To Use ###
This project can be run with the command ```./mvnw spring-boot:run```. The app can then be 
accessed by going to ```http://localhost:8080``` in a browser, and logging in with the credentials
```username = 'tester', password = 'password'```.

### What I Learned ###
- Combining controller, service and data layers into a functional CRUD web application
- Defining JPA entities and handling the relationships between them
- Templating using Thymeleaf
- Creation of REST API for easier viewing of application data
- Basic Spring Security functionality allowing login and authentication of a single user

# Potential Additions
1. Ability to use media other than text in blog posts (pics, videos, emoji, etc)
2. Caching to prevent potential slow response times (maybe especially useful if 2 implemented)
3. Creation of new users and correct permissions for them
4. Switch from in-memory database to Postgres (or similar) running on Docker for extending data 
lifetime beyond application lifetime