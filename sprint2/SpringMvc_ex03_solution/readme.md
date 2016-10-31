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

### Implementing the transition "/student"

Create a method in the class `IndexController` that corresponds to the GET HTTP request `/student`.  The method must return the view `form/form` with a fresh student instance of the class `Student` as the command object of the form in the view `form/form`.

<!--
Add the following code to your controller class:
		@RequestMapping(value = "/student", method = RequestMethod.GET)
	    public ModelAndView student() {
	       return new ModelAndView("form/form", "command", new Student());
	    }
The code above implements a transition for the GET HTTP request `/student`. An effect of this request is to create a `Student` instance as the command object of the web form, which is used to collect its data. The view `form/form` is the target state of the transition.    	   
Hint: The `ModelAndView` class is a mechanism that Spring MVC provides to automatically create a command object to be used in a form of a view so it basically becomes the model of the view. That is, this is a way of initializing a view that contains a Spring form. [This is a reference to more information about this class in the official documentation](http://docs.spring.io/spring-framework/docs/current/spring-framework-reference/html/mvc.html#mvc-coc-modelmap).	     
-->


### Implementing the transition "/addStudent"

Create another method in the class `IndexController` that processes the HTTP POST request that results from submitting the form on the view `form/form`. The HTTP POST request must return the view `form/result` with a model whose attributes correspond to the attributes of the `Student` instance attached to the POST request. 


<!--
Hint: check Spring MVC's conventions for including the model in the list of parameters of the method mapped to a HTTP request.
The following code processes a POST request where the form data is available in the student parameter used as the command object in the form.    
	    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
	    public String addStudent(Student student,  ModelMap model) {
	    	model.addAttribute("name", student.getName());
	        model.addAttribute("age", student.getAge());
	        model.addAttribute("id", student.getId());	
	        return "form/result";
	    }  
The code above uses the data from the web form to initialize model attributes that will be used to render the view `form/result`. The SpEL expressions that fetch data from model attributes for this view is given in the JSP file `form/result.jsp`, which you should have created already as explained above.	    
-->

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