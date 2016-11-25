<link rel='stylesheet' href='../web/swiss.css'/>

# CO2006 MINI PROJECT 16-17: eMarket (part II)

In sprint 3, the goal is to implement the second release of the online shop with the following design aspects:
* Persistence layer using MySQL and Spring Data JPA.
* Security layer using Spring Security.

## 1. Exercises

### Section A. Persistence layer (63 marks)

#### End product (what needs to be done) 

  1. **Develop** a persistence layer for the online shop,  as explained in the lecture :movie_camera: [L9. Spring Data](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=dbcfac72-69ea-4ec1-a384-42455e5c128c), by
    * configuring the database connection using your MySQL credentials;
    * annotating domain classes using JPA in order to generate the database (**12 marks**);
    * declaring `Repository` interfaces (**3 marks**);
    * modifying controllers in order to access the repository (**30 marks**).
  2. **Test** the persistence layer by:
    * generating step definitions from the feature file [OrderPersistence.feature](https://github.com/uol-inf/CO2006-16-17/blob/master/sprint3/mini-project2/OrderPersistence.feature);
    * implement step definitions as shown in project :computer: [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db) (**18 marks**).

#### Methodology (how to do it)

* Watch the demo of the system given at the beginning of this lecture :movie_camera: [L8. ORM and JPA](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=17bb5284-2614-44df-9d8e-0877bea78158) (minute 3:15)
  * The code of the part of the demo that is not assessed (product management) has been provided as an example: :computer: [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db) and it can be reused for your mini project
  * The solution released for the :computer: [mini project of sprint 2](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/CO2006.eMarket.0.0.1-SNAPSHOT) can be reused **selectively**
    * For example, the code in the controllers needs to be adapted in order to access the database as explained in the lecture.
      * In sprint 2, we used the :notebook: [singleton pattern](https://en.wikipedia.org/wiki/Singleton_pattern) in the main class `EMarketApp` for implementing an abstraction of the database (that is, we did not have a database yet and we needed a way to fake one by using objects in memory). 
    * On the other hand, the Lombok library was used as explained in [here](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/CO2006.eMarket.0.0.1-SNAPSHOT#project-lombok) in order to simplify the develoment of Java classes (e.g. by annotating an attribute with `@Getter` the getter method is added implicitly and there is no need to generate that code explicitly).
      * **However**, as explained [here](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/CO2006.eMarket.0.0.1-SNAPSHOT#project-lombok) you need to configure your STS in order for Eclipse to recognise those annotations.
      * If you don't want to use Lombok, simply generate getters/setters explicitly using the IDE in that project.
* Software development is carried out in an **iterative way** in small increments:
  * First iteration:
    * develop a [smoke test](http://softwaretestingfundamentals.com/smoke-testing/): 
check that the [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db) project runs in your machine after configuring the database connection and that data is created and sent to your MySQL database in the Departmental web server as described in the lecture :movie_camera: [L9. Spring Data](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=dbcfac72-69ea-4ec1-a384-42455e5c128c).
	  * push your code to GitHub (as explained for `checkpoint 1`)
  * For subsequent iterations, use **behaviour-driven development** for driving the implementation of the system from scenarios using **test-driven development triangulation** as explained in the tutorial :movie_camera: [Introduction to testing in Java](https://app.pluralsight.com/library/courses/java-testing-introduction/table-of-contents):
    * choose a scenario from the feature [OrderPersistence.feature]() and generate step definition stubs for it using the command `./gradlew cucumber` in a terminal (copy those in a `StepDefs.java` file as done in sprint 2);
    * develop system code:
      * identify what HTTP request handler method needs to be modified (the one to be used in the `@When` step) in a controller class; 
      * develop the corresponding `Repository` interface if not present already with appropriate query methods;
      * add JPA annotations to domain classes used to implement those scenarios;
      * modify the code in the corresponding HTTP request handler method in the controller;
        * access to the singleton `Store` object in the class `EMarketApp` is no longer allowed;
        * information needs to be retrieved from the database by using `Repository` interfaces and it has to be saved in the database;
        * there is an example on how to do this in the controller of :computer: [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db);
      * run your application and check that it is working as expected by using SQL queries in MySQLWorkbench;
    * develop tests:
      * implement the step definitions (glue code) linking the specification to your implementation:
        * there are examples on how to do this in the Cucumber steps definitions of :computer: [SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db);
      * check that the tests go green in the cucumber report (in `build/cucumber-html-report/index.html`) using `./gradle test` (or any Gradle task the embeds that task).
  * For each iteration that results in working software, push a commit to your repo in GitHub.

#### Marking guidelines


| Scenario | Marks for development | Marks for testing | Total |
|----------|-----------------------|-------------------|-------| 
| Order.Repo.Create  | 5 | 3 | 8 |
| Order.Repo.Edit  | 5 | 3 | 8 |
| Order.Repo.Delete | 5 | 3 | 8 |
| Item.Repo.Create | 5 | 3 | 8 |
| Item.Repo.Edit | 5 | 3 | 8 |
| Item.Repo.Delete | 5 | 3 | 8 |

Each scenario is marked out of 5 marks for implementation using Spring Data JPA and 3 marks for the testing aspect (using SpringMvc Test, Cucumber and HamCrest). Each implementation/testing aspect of a scenario is marked as explained in the marking guidelines at the end of the worksheet.


### Section B. Security layer (30 marks)

#### End product (what needs to be done)

##### Secure connection (5 marks)
* Generate your public key certificate 
* Configure the web application to use secure communication with that certificate

##### Authentication (15 marks)
* Configure the authentication mechanism in your web application (using a login form).
* Passwords must be encrypted in the database.
* Add users of role `CUSTOMER` when the application is started.

##### Authorization (10 marks)
* Create a role `CUSTOMER` for users that will have access to the order management functionality
  * Customers must not be able to modify the catalogue of products


#### Methodology
* Iterations
  * Set up the secure configuration
  * Configure the login form and add users of roles `CUSTOMER`
  * Configure access control for customers to be able to access order management
    * Managers must not be able to access that functionality (i.e. requests under `/order/`)
    * Customers must not be able to modify the product catalogue (i.e. requests under `/product/`) 
    
### Section C. Engagement and release procedure (7 marks)

#### Checkpoint 1: formative feedback only
* **When**: Friday 25 November 2016, 17:00.
* **What**: set up the infrastructure that you need for doing your mini project in sprint 3.
* **How**: copy the **contents** of the project :computer: [sprint3/SpringMvc_product_db](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint3/SpringMvc_product_db) from **the master repo** to a new folder `root/sprint3/mini-project2` **in your repo** and push it to GitHub (where `root` is the actual root folder of your git repository, where the directory `.git` is).

#### Checkpoint 2: 3 marks
* **When**: Friday 2 December 2016, 17:00.
* **What**: develop most of `Section A. Persistence layer` (around 75%) in the project that you have set up in `checkpoint 1`.
* **How**: make a commit `checkpoint 2` and push it to GitHub.

#### Release 0.0.2-SNAPSHOT: 4 marks
* **When**: Friday 9 December 2016, 17:00.
* **What**: solution to full worksheet.
* **How**: make a commit `checkpoint 2` and push it to GitHub.
  * Commit and push your mini project (the whole project) to your GitHub repository, under the folder `root/sprint3/mini-project2` so that you can find your file `gradle.build` in `root/sprint3/mini-project2/gradle.build` 
  * Make a release on GitHub
    1. Open the repo in Github
    2. Click Releases
    3. Click `Create a new release` 
    4. Enter the `Tag Version` as `ws2` (leave `@ Target Master`)
    5. Enter the `Release Title` as `Worksheet 2 submission`
    6. Click `Publish Release` 
  * Clone your repository in a new workspace and check that `root/sprint3/mini-project2/gradlew check` generates a report in folder `root/sprint3/mini-project2/build/cucumber-html-report/index.html`


## 2. Marking criteria (rubric)

| Indicator | Description			  | Persistence	(scenario system/test)	 | Security |
|------------|--------------------|------------------|------------------|
| **master** | Usually corresponds to a top mark. | 5/3: Code is fit for purpose and is well documented (and readable). Excellent use of frameworks and libraries (SpringMvc, Spring Data JPA, SpringMvc Test, HamCrest). | Security design concerns (security channel, access control) have been fully considered.  |
| **proficient** | Usually corresponds to a mark above average. | 4/2-3: code works as expected. | Security design concerns (security channel, access control) have been considered. |  
| **skilled** | Usually corresponds to an average mark. | 3-4/2: Code does compile but contains errors (e.g. it is not testing what it should test). Code is readable. Some functionality from the frameworks and libraries (SpringMvc, Spring Data, SpringMvc Test, HamCrest) are not used correctly. |  Functioning system with a partial implementation of some security features. | 
| **satisfactory** | Usually corresponds to a mark below average, although there is merit in the answer provided. This is an indicator of an area where improvement is required. | 2-3/1-2: code does not compile but there is a thoughtful attempt at implementing the scenarios. | Some security aspects are working although there may not be ready for production.  |
| **borderline** | Usually corresponds to a low mark and is a clear an indicator of an area where improvement is required. | 1-2/1: code does not compile but there is an attempt at implementing the scenarios | There is an attempt at implementing the system. |
| **fail** | No submission. |
    



