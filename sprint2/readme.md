<link rel='stylesheet' href='./web/swiss.css'/>

If you prefer to read this worksheet on GitHub: follow [this link](https://github.com/uol-inf/CO2006-16-17/blob/master/sprint2/readme.md). 
* The advantage is that links to Pluralsight resources work directly.

# Sprint 2: Spring MVC and BDD

In this sprint, we are going to focus on how to build web applications using Java and the MVC architectural style and on testing them using agile testing based on test-driven development and behaviour-driven development.

## 1. Pre-requisites

In this sprint we are going to Java Server Pages (JSPs) to create dynamically generated web pages based on HTML and we are going to assume that you are familiar with basic HTML, as taught in CO1019. 

If you did not take that course and you don't know HTML, then I recommend going through :movie-camera: [this one-hour tutorial on Pluralsight](https://app.pluralsight.com/library/courses/teaching-kids-basic-html/table-of-contents) to understand what HTML is and how to use it.

## 2. Spring MVC and Spring Boot (starting on 20/10/2016)

In this week's :movie_camera: [lecture](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=68cbf3a2-be0f-4080-a29a-49f84d556d98) we covered:
* the goal of the sprint: the mini project (I) 
  * :computer: [mini project worksheet](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/mini-project/readme.md)
  * deadline: **Wednesday 16 November (9 am)**
  * marks: 100 - **30%** of overall mark
  * this assessment is **individual** and you should not work with other students in your solution, which is penalised as [a form of plagiarism (namely, collusion)](https://campus.cs.le.ac.uk/ForStudents/plagiarism/)
* specific goals for this week

### What to focus on during this week?

* What is Spring MVC? and Spring Boot?
* What is a software architecture? 
  * Examples of software architectures: MVC, n-tier
* Techniques to design software architectures: layering
* What is a controller? What is the request/response lifecycle in an MVC web application?
* Implementation of the MVC architectural style in Spring, aka Spring MVC
  * Component
  * Controller
  * Service
  * Repository
* Implementation of controllers


### Pluralsight resources

* :movie_camera: [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=0&mode=live)
* :movie_camera: [Building](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m2-building&clip=1&mode=live): this unit should be watched for the sake of completeness in order to follow the rest of the tutorial on Pluralsight. However, we are going to simplify the configuration process by avoiding the use of XML, as illustrated in [exercise 01](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint1/SpringMvc_ex01). Check the guide on how to migrate Pluralsight projects to Gradle and Spring Boot below. 
* :movie_camera: [Architecture](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m3-architecture&clip=0&mode=live)
* :movie_camera: [Controllers](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m4-controllers&clip=0&mode=live)

### Exercises
* :computer: [exercise 01](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex01): setting up your first Java web application
  * :computer: [exercise 01 (solution)](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex01_solution)
* :computer: exercises from Pluralsight (under tab `Exercise files` of the [tutorial Spring MVC fundamentals](https://app.pluralsight.com/library/courses/springmvc-intro/table-of-contents)): 
  * :computer: [guide to migrate projects from Maven and XML configuration to Gradle and Spring Boot](https://github.com/uol-inf/CO2006-16-17/blob/master/sprint2/MigratingToGradle.md). The main differences that we are going to find are:
  * Gradle (instead of Maven) for simplifying the build of a web application and for configuring dependencies; and
  * Spring Boot for configuring Spring MVC (instead of using XML files).
* :computer: [exercise 02](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex02): developing controllers in order to practise with `@MappingRequest`
  * :computer: [exercise 02 (solution)](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex02_solution)
  
  
## 3. Java Server Pages (starting on 25/10/2016)

In this week's :movie_camera: [lecture](https://leicester.cloud.panopto.eu/Panopto/Pages/Viewer.aspx?id=e444fb3f-b2a1-4b8d-8cc6-d2ba1c8944f5) we covered:
* A demo of the part of the mini project that is not assessed 
  * product management in the online shop: :computer: [source code is here](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_product)
* Implementation of JSP views using 
  * HTML, 
  * the EL (Expression Language), and 
  * tag libraries - namely JSTL for UI logic and Spring forms for implementing web forms. 

### What to focus on during this week?
* Views
  * What is a view in Spring MVC?
  * What is the connection between a view and a controller? and between a view and the model?
  * How are views resolved?
  * What is JavaServer Pages? What are the main components of a JSP page?
* What the Expression Language?
  * What is the main function of this language?
  * What are the main operators available? How can they be used?
* What is the JSTL?
  * How is it used to implement views?
  * How can you generate snippets of HTML code depending on conditions?
  * How can you generate the same HTML code for all the elements of a collection?
* What are the main Spring form tags?
  * What is the command object?
  * How can you post information to a controller?
  * How can you define a drop-down list and select elements from that list?

### Pluralsight resources

* :movie_camera: [Views](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m5-views&clip=0&mode=live)
* :movie_camera: [Tag libraries](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m6-tags&clip=0&mode=live)
  * focus on form tags
  * skip interceptors
* Java servlet technology is running underneath Spring MVC and this Pluralsight tutorial on [Java Web Development](https://app.pluralsight.com/library/courses/java-web-fundamentals/table-of-contents) explains JSPs from the point of view of servlets. Although we don't need so much detail as delivered in this tutorial, the following videos will be helpful:
  * :movie_camera: [JSPs](https://app.pluralsight.com/player?course=java-web-fundamentals&author=kevin-jones&name=java-web-fundamentals-m3&clip=0)
    * This video is used as **background material** (not assessed). You may want to skip it if you are not interested in learning the magic underneath Spring MVC controllers.
  * :movie_camera: [The Expression language](https://app.pluralsight.com/player?course=java-web-fundamentals&author=kevin-jones&name=java-web-fundamentals-m4&clip=0)
    * Introduction
    * Using the Expression Language
    * Using Operators
  * :movie_camera: [JSTL](https://app.pluralsight.com/player?course=java-web-fundamentals&author=kevin-jones&name=java-web-fundamentals-m5&clip=0)
    * Introduction
    * Using conditional tags
    * Looping with the iteration tag
  * Keep in mind the following **concept map** when going through these videos:
  
| Servlet concept | SpringMVC concept |
|-----------------|-------------------|
| bean			| POJO stored in the model (accessible as a model attribute from the view) |
| servlet			| Controller (which is actually an enriched servlet) |
 

### Exercises

* :computer: [exercise 03](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex03): handling HTTP requests and Spring forms
* :computer: [exercise 04](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex04): developing a master/detail GUI with JSTL
* :computer: push a (first) commit with an initial executable skeleton of your mini project so that your file
`gradle.script` is under `root/sprint2/mini-project` in your repository. 
  * This is going to be used as a check point for monitoring performance
  * Deadline: **Monday 31 October (midnight)** 

## 4. Test-driven development (starting on 1/11/2016)

## 5. Behaviour-driven development (starting on 8/11/2016)


## 6. Jargon buster <a name="jargon"></a>

| term  | definition | source |
|-------|------------|--------|
| Java annotation |  Annotations, a form of metadata, provide data about a program that is not part of the program itself. Annotations can be used to inform the compiler in order to detect errors or suppress warnings. For example, the `@Override` annotation informs the compiler that the element is meant to override an element declared in a superclass. While it is not required to use this annotation when overriding a method, it helps to prevent errors. If a method marked with @Override fails to correctly override a method in one of its superclasses, the compiler generates an error. | [Java tutorial](https://docs.oracle.com/javase/tutorial/java/annotations/index.html) |
| Dispatcher servlet | the entry/configuration point for the application | [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=6&mode=live) |
| Controller | class that handles a request and determines which view should be displayed |  [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=6&mode=live)|
| Request mapping | the url and request type that a method is tied to | [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=6&mode=live) |
| ViewResolver | used to locate JSP pages (or the desired view) | [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=6&mode=live) |
| POJO | Plan Old Java Object (that is, an instance of a Java class) | [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=6&mode=live) |
| Bean | A Spring configured POJO (that is, an instance of a Java class that is used by Spring) | [Introduction to Spring MVC](https://app.pluralsight.com/player?course=springmvc-intro&author=bryan-hansen&name=springmvc-m1-intro&clip=6&mode=live) | 



## 7. Additional resources (for reference)

These are pointers to official documentation in case you need to deepen your knowledge when implementing the mini project:
* [HTML (w3schools tutorial)](http://www.w3schools.com/html/)
  * [online try it yourself HTML editor](http://www.w3schools.com/html/tryit.asp?filename=tryhtml_default)
* Spring MVC
  * [Official documentation about Spring MVC](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/mvc.html)
    * [about controllers](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-controller)
    * [about @RequestMapping](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-requestmapping)
    * [about @RequestMapping handler methods](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/htmlsingle/#mvc-ann-methods) (Java methods in a controller)
  * [More examples with `@RequestMapping`](http://www.byteslounge.com/tutorials/spring-mvc-requestmapping-example)
  * [Another example of master/detail interface using Spring MVC forms](http://www.mkyong.com/spring-mvc/spring-mvc-form-handling-example/)
* [Spring Expression Language](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/expressions.html#expressions-language-ref): this is the Expression Language used in Spring MVC
* [JSTL core tag library (tutorialspoint)](http://www.tutorialspoint.com/jsp/jsp_standard_tag_library.htm)
* [Spring form tag library](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/view.html#view-jsp-formtaglib)






