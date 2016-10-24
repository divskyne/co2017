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
* :computer: exercises from Pluralsight (under tab `Exercise files` of the [tutorial Spring MVC fundamentals](https://app.pluralsight.com/library/courses/springmvc-intro/table-of-contents)): 
  * :computer: [guide to migrate projects from Maven and XML configuration to Gradle and Spring Boot](https://github.com/uol-inf/CO2006-16-17/blob/master/sprint2/MigratingToGradle.md). The main differences that we are going to find are:
  * Gradle (instead of Maven) for simplifying the build of a web application and for configuring dependencies; and
  * Spring Boot for configuring Spring MVC (instead of using XML files).
* :computer: [exercise 02](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex02): developing controllers in order to practise with `@MappingRequest`
  
  
## 3. Java Server Pages (starting on 25/10/2016)

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






