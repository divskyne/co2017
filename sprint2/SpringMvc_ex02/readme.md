<link rel='stylesheet' href='web/swiss.css'/>

# (:star::star:) Spring MVC: Exercise 02

In this exercise, we are going to practise how to map HTTP requests to controller methods.

In constrast to Pluralsight videos, we are using Gradle and Java configuration for bootstrapping the web application, which reduces the configuration effort.

## Setting

The configuration is similar to exercise 01. The project contains the JSP file `src/main/webapp/WEB-INF/views/greeting.jsp`, which is a slight modification of `src/main/webapp/WEB-INF/views/hello.jsp` and that can display the attributes `name` and `value` from the model.

## Exercises

The exercises are in file `src/main/java/labMVC/IndexController.java`. For each method, add the corresponding request mapping annotation as described in the corresponding comment.  

The intent behind this exercise is to get used to explore documentation, in this case about [request mappings](http://docs.spring.io/spring/docs/current/spring-framework-reference/html/mvc.html#mvc-ann-requestmapping).

***
&copy; Artur Boronat, 2016-17
