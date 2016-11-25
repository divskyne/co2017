<link rel='stylesheet' href='./web/swiss.css'/>

# Sprint 3: Spring Data (JPA) and Spring Security 

In this sprint, we are going to focus on how to implement two important aspects of web applications:
* persistence using a relational database (MySQL): we will generate the database automatically from our POJOs; and
* security.

Specifically, the **goal** of the sprint is to add a persistence layer (with a MySQL database and Spring Data) and a security layer (with Spring Security) to the mini project (part II): 
* :computer: [Mini project worksheet](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/mini-project2)
  * deadline: **Wednesday 9 December (9 am)**
  * marks: 100 - **30%** of overall mark
  * this assessment is **individual** and you should not work with other students in your solution, which is penalised as [a form of plagiarism (namely, collusion)](https://campus.cs.le.ac.uk/ForStudents/plagiarism/)
* The base code for this assignment is in the project [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db): 
  * This project configures the basic infrastructure of the project so that you can focus on the use of Spring Data JPA and Spring Security.
  * This project relies on what we have learnt in previous sprints:
    * how to use Gradle in sprint 1
    * how to use Spring Mvc and Cucumber in sprint 2 
* :loudspeaker: [Solution of mini project (sprint 2)](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/CO2006.eMarket.0.0.1-SNAPSHOT): the code provided in this project can be adapted, extended and reused for the mini project worksheet of sprint 3.
  * Some optional **productivity tips** to work with Java for developing web apps are described in the solution.


We are going to use agile software development based on test-driven development and behaviour-driven development, as explained in Sprint 2.

## 1. Pre-requisites

In this sprint, we are going to use MySQL to persist data handled by our web application. We are going to assume that you are familiar with SQL and MySQL, as taught in CO1019. 

If you did not take that course and you don't know/remember SQL and MySQL, then I recommend going through the following tutorials:
* [MySQL Fundamentals](https://app.pluralsight.com/library/courses/mysql-fundamentals-part1/table-of-contents)
  * :movie_camera: [introduction](https://app.pluralsight.com/player?course=mysql-fundamentals-part1&author=pinal-dave&name=mysql-fundamentals-part1-01-introduction&clip=0&mode=live) 
  * :movie_camera: [installations and GUI tools](https://app.pluralsight.com/player?course=mysql-fundamentals-part1&author=pinal-dave&name=mysql-fundamentals-part1-01-introduction&clip=0&mode=live): if you want to use MySQL and the MySQLWorkbench at home 
  * :movie_camera: [Fundamentals of RDBMS and Database Design](https://app.pluralsight.com/player?course=mysql-fundamentals-part1&author=pinal-dave&name=mysql-fundamentals-part1-03-database-designs&clip=0&mode=live): 
    * C/S system, 
    * web application server, 
    * concepts, 
    * model keys, 
    * column definition 
  * :movie_camera: [Introduction to MySQL Workbench](https://app.pluralsight.com/player?course=mysql-fundamentals-part1&author=pinal-dave&name=mysql-fundamentals-part1-04-workbench&clip=0&mode=live): 
    * connecting to your database
    * selecting data
    * output window
    * data modeling
  * :movie_camera: [Data Retrieval Techniques](https://app.pluralsight.com/player?course=mysql-fundamentals-part1&author=pinal-dave&name=mysql-fundamentals-part1-05-data-retrieval&clip=0&mode=live): SELECT queries
* [MySQL Fundamentals 2](https://app.pluralsight.com/library/courses/mysql-fundamentals-part2/table-of-contents)  
  * :movie_camera: [Joins](https://app.pluralsight.com/player?course=mysql-fundamentals-part2&author=pinal-dave&name=mysql-fundamentals-part-2-m2&clip=0&mode=live):
    * beginning joins
    * inner join 
    

## 2. Spring Data (starting on 17/11/2016)

In this week's lectures, we covered:
* :movie_camera: [L8. ORM and JPA](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=17bb5284-2614-44df-9d8e-0877bea78158)
  * a demo of the mini project with a persistence layer
  * the object-relational mapping (ORM) problem
  * Java Persistence API (JPA) annotations to map
    * classes to tables in a relational schema
    * associations to foreign keys or join tables
* :movie_camera: [L9. Spring Data](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=dbcfac72-69ea-4ec1-a384-42455e5c128c)
  * configuration of the persistence layer of a Spring Mvc project using the project [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db)
  * generating relational databases using Hibernate and Spring Data
  * accessing a database from Java code using Spring Data repositories
  * specific tasks for this week   


### What to focus on during the following two weeks?

#### JPA

* The object relational mapping problem
* What is JPA?
* What is an Entity?
* Spring MVC architecture
  * service layer
  * repository layer
* JPA/Hibernate configuration: what options are available for initialising a database `hbm2ddl`
* **JPA annotations** 
  * `@Entity` 
  * `@Table`
  * `@Id`
  * `@GeneratedValue`
  * `@Column`
  * `@Column`
  * Join types: 
    * `@OneToOne`
    * `@OneToMany`
    * `@ManyToOne`
    * `@ManyToMany`
    * configuration
      * unidirectional/bidirectional/cascasde
      * Fetch type: lazy/eager
* What is Spring Data JPA?   
   
#### Spring Data JPA
* What is a Spring JPA repository?
* What can we do with a Spring JPA repository?
  * How to use CRUD operations?
* What is the Query DSL?
  * Query method syntax basics
  * Query method return types
  * Keywords: use as reference (remember that most of these keywords correspond to clauses that can be used in a SQL SELECT statement)

### Pluralsight resources

The approach that we are using in CO2006 for configuring Spring MVC apps is based on Java configuration (as opposed to XML configuration as done in the Pluralsight tutorial), to be discussed in the lecture and exercises.

####  Spring, JPA and Hibernate

Some differences with the Pluralsight tutorials:
  * The tutorial uses Spring Validation, whereas we used error handling with exceptions
  
This tutorial builds on the case study used in the tutorial [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro), the project `Fitness Tracker` and the examples can be migrated to Gradle/Java configuration using the [migration guide from Maven to Gradle](https://github.com/uol-inf/CO2006-16-17/blob/master/sprint2/MigratingToGradle.md).  Watch the following tutorials:
  * :movie_camera: [Introduction](https://app.pluralsight.com/player?course=spring-jpa-hibernate&author=bryan-hansen&name=springjpa-m1-intro&clip=5&mode=live)
  * :movie_camera: [MVC Demo](https://app.pluralsight.com/player?course=spring-jpa-hibernate&author=bryan-hansen&name=springjpa-m2-scaffold&clip=0&mode=live): the project `Fitness Tracker`
  * :movie_camera: [Architecture](https://app.pluralsight.com/player?course=spring-jpa-hibernate&author=bryan-hansen&name=springjpa-m3-architecture&clip=0&mode=live): revisiting architectural design with more emphasis on persistence (databases)
  * :movie_camera: [Overview of JPA and creating your first entity](https://app.pluralsight.com/player?course=spring-jpa-hibernate&author=bryan-hansen&name=springjpa-m6-jpa&clip=0&mode=live)
  * :movie_camera: [JPA annotations and how to use them](https://app.pluralsight.com/player?course=spring-jpa-hibernate&author=bryan-hansen&name=springjpa-m7-jpaannotation&clip=0&mode=live)
    * **skip** 
      * JPQL/JPQL demo
      * OpenEntityManagementInViewFilter
      * Lazy Initialization Fix Demo
      * Projection/Projection Demo
      * Named queries/named queries demo

#### Spring Data JPA
  * :movie_camera: [Getting Started](https://app.pluralsight.com/player?course=spring-data-jpa-getting-started&author=dan-bunker&name=spring-data-jpa-getting-started-m1-intro&clip=4&mode=live)
    * introduction to Spring Data JPA
    * case study: guitar project (uses Maven and Java configuration): use the [migration guide from Maven to Gradle](https://github.com/uol-inf/CO2006-16-17/blob/master/sprint2/MigratingToGradle.md) 
  * :movie_camera: [Spring Data Repositories](https://app.pluralsight.com/player?course=spring-data-jpa-getting-started&author=dan-bunker&name=spring-data-jpa-getting-started-m2-repositories&clip=0&mode=live)
  * :movie_camera: [QueryDSL](https://app.pluralsight.com/player?course=spring-data-jpa-getting-started&author=dan-bunker&name=spring-data-jpa-getting-started-m3-queries&clip=0&mode=live)

### Exercises
* :computer: [Exercises Spring Data](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringData_ex)
  * Configuring a database connection
  * Defining JPA annotations
  * Using Spring Data repository interfaces
* :computer: [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db): base code for mini project
  * :computer: [solution](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringData_ex_solution)
* :computer: [Fitness tracker examples](https://app.pluralsight.com/library/courses/spring-jpa-hibernate/exercise-files) (Excercise files)
* :computer: [Guitar company examples](https://app.pluralsight.com/library/courses/spring-data-jpa-getting-started/exercise-files) (Excercise files)
  

## 3. Spring Security (starting on 29/11/2016)    


### What to focus on during the following two weeks?
* Architecture of a secure Spring MVC web app
  * Authentication
  * Authorization
* User storage
* Password encryption
* Access control lists (ACLs)
* Secure communication
  * HTTPS
  * Man in the middle attack
  * Certificates

### Pluralsight resources
* :movie_camera: [Introduction to Spring Security](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m1-intro&clip=0&mode=live)
* :movie_camera: [Scaffold application](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m2-scaffold&clip=0&mode=live)
  * Building on the `Fitness Tracker` application used in previous tutorials
  * Some differences with what we are using are:
    * We are using containerless applications where the web server is embedded into our applications by using Spring Boot. Use the view `Boot Dashboard` instead of the view `Servers` to run your web app within the STS.
    * We are using Gradle instead of Maven and Java configuration instead of XML configuration. See the usual [migration guide from Maven to Gradle](https://github.com/uol-inf/CO2006-16-17/blob/master/sprint2/MigratingToGradle.md) for reusing the examples provided.
* :movie_camera: [Securing your Spring MVC Application](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m3-first-app&clip=0&mode=live)
  * replace most of the XML configuration for what we will discuss in the lecture
* :movie_camera: [User storage](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m4-user-storage&clip=0&mode=live)
* :movie_camera: [Spring Security Client Integration](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m5-client&clip=0&mode=live)
  * we are going to configure authentication and access control using the Spring Security DSL as shown in the lecture
* :movie_camera: [Password Storage](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m6-passwords&clip=0&mode=live)
* :movie_camera: [Customizing Spring Security](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m7-customizing&clip=0&mode=live)
  * we are going to customize security using the Spring Security DSL as shown in the lecture
* :movie_camera: [Forcing the use of HTTPS](https://app.pluralsight.com/player?course=spring-security-fundamentals&author=bryan-hansen&name=springsec-fundamentals-m9b-https&clip=0&mode=live)


## 4. Jargon buster <a name="jargon"></a>

| term  | definition | source |
|-------|------------|--------|
| Repository | CRUD interface for a database table | [Working with Spring Data Repositories](http://docs.spring.io/spring-data/data-commons/docs/1.6.1.RELEASE/reference/html/repositories.html) |
| Domain class | Plain old class modelling data, which will usually be mapped to a table | |
| MySQLWorkbench | GUI for MySQL database server | [http://mysqlworkbench.org](http://mysqlworkbench.org) |  
| Public key certificate | Electronic document used to prove the ownership of a public key | [wikipedia](https://en.wikipedia.org/wiki/Public_key_certificate) |
| HTTPS | Protocol for secure communication over a computer network | [wikipedia](https://en.wikipedia.org/wiki/HTTPS) |
| Man-in-the-middle attack | Attack used to sniff information from a communication between two systems. | [OWASP](https://www.owasp.org/index.php/Man-in-the-middle_attack) | 

## 5. Additional resources (for reference)

These are pointers to official documentation in case you need to expand your knowledge when implementing the mini project (part II):
* [SQL (w3schools tutorial)](http://www.w3schools.com/sql/)

### Spring Data

* [Nicholas S. Williams. Professional Java for Web Applications. Addison-Wesley. 2014.](http://readinglists.le.ac.uk/items/51133F43-7D8E-3A7B-952C-6DA5DC168B73.html?referrer=%2Flists%2FAE79369B-4CED-C912-2150-5BD837030B59.html%23item-51133F43-7D8E-3A7B-952C-6DA5DC168B73) (link to ebook on Library catalogue). Chapters 19-23.
* [Official documentation about Spring Data](http://docs.spring.io/spring-data/jpa/docs/current/reference/html/)

### Spring Security

* [Nicholas S. Williams. Professional Java for Web Applications. Addison-Wesley. 2014.](http://readinglists.le.ac.uk/items/51133F43-7D8E-3A7B-952C-6DA5DC168B73.html?referrer=%2Flists%2FAE79369B-4CED-C912-2150-5BD837030B59.html%23item-51133F43-7D8E-3A7B-952C-6DA5DC168B73) (link to ebook on Library catalogue). Chapters 25-26.
* [Official documentation about Spring Security](http://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/)






