<link rel='stylesheet' href='web/swiss.css'/>

# Spring MVC: exercise 03 - HTTP requests and Spring forms

In this exercise we are going to create a presentation layer for your application that will handle web forms. This will be achieved by building a skeleton of a web application with a presentation layer (formed by JSP views) and a control layer (formed by a controller class). Specifically, we are going to create a web page with a web form that implements a user interface that allows interaction with the user in order to provide data to the system more securely than with plain URLs. We are going to implement the HTTP requests with URLs `/student` and `/addStudent` . The first one gets a web page with a form and the second one posts a web form, showing the results of the action.


## Skeleton of web application

The architecture of the boilerplate code available in the repository is as follows:

		/src
		|-- main
	        |-- java
	            |-- labMvc
	                |-- LabMvcApplication.java: 
	                |-- WebConfig.java
	                |-- control
	                    |-- IndexController.java
	                |-- domain
	                    |-- Student.java
	        |-- resources
	            |-- application.properties
		    |-- webapp
		        |-- WEB-INF
		            |-- views: where the JSP files can be found
		                |-- index.jsp
		                |-- forms
		                    |-- form.jsp
		                    |-- result.jsp

* `src/main/java/labMvc/LabMvcApplication.java`: Java class with the annotation @SpringBootApplication.
* `src/main/java/labMvc/WebConfig.java`: Java configuration class, which configures the use of JSPs. The code in this class tells the web container how to resolve views that are encoded in JSP and where they can be fetched from.
* `src/main/java/labMvc/control/IndexController.java`: controller class where **CODE** from exercises should go.
* `src/main/webapp/WEB-INF/views/index.jsp`: Landing page. This file contains the directive `<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>` to indicate that we are going to use the Spring form tag library in this HTML web page. The file is HTML code where we have a URL that makes an http request `/student`, which will be handled by the controller of our web application.
* `src/main/webapp/WEB-INF/views/form/form.jsp`: Web page containing a form. This view contains a form that allows users to enter data about a student, namely their name, age and an identifier. The action associated with this form is a POST request `/addStudent`, that will have to be handled by the controller.
* `src/main/webapp/WEB-INF/views/form/result.jsp`: Web page shown after posting the form. This is a plain HTML page with some SpEL expressions fetching data from model attributes, which need to be initialized by the controller.		


## Exercises 

### Implementing the HTTP request "/student" (GET)

Create a @RequestMapping handler method in the class `IndexController` that corresponds to the GET HTTP request `/student`.  The method must return the view `form/form` with a fresh student instance of the class `Student` as the command object of the form in the view `form/form`.

### Implementing the HTTP request "/addStudent" (POST)

Create another method in the class `IndexController` that processes the HTTP POST request that results from submitting the form on the view `form/form`. The HTTP POST request must return the view `form/result` with a model whose attributes correspond to the attributes of the `Student` instance attached to the POST request. 


## Additional Resources
 
The code used in this tutorial has been adapted from the following sources:
* [Handling forms](http://www.tutorialspoint.com/spring/spring_mvc_form_handling_example.htm)

Other tutorials that may be helpful:
* [SpringMVC showcase](https://github.com/spring-projects/spring-mvc-showcase): forms
* [Another tutorial on handling forms](http://www.javacodegeeks.com/2012/08/handling-form-validation-with-spring-3.html).

Official tutorials:
* [Spring form tags library](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/spring-form-tld.html)


***
&copy; Artur Boronat, 2015-16 