<link rel='stylesheet' href='web/swiss.css'/>

# Migrating Pluralsight exercises to Gradle

In order to configure the exercises provided with the Pluralsight resources as in [exercise 01](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex01), follow the instructions below.

You need a local installation of Gradle for executing these steps.

* Do [exercise 01](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_ex01).
* Download the exercises from Pluralsight (tab `exercises`)
* In your workspace in the STS, create a general project
* Copy the contents of an exercise folder with a `pom.xml` file into the project 
* From the STS: select project on package explorer
* right click > show in > terminal
* with `pwd` make sure that you are on the directory of the project of your workspace (with `ls` you should see the file `pom.xml`)
* run `gradle init`, this will generate a file `build.gradle`
* modify the `build.gradle` by **adding**

		buildscript {
			ext {
				springBootVersion = '1.4.1.RELEASE'
			}
			repositories {
				mavenCentral()
			}
			dependencies {
				classpath("org.springframework.boot:spring-boot-gradle-plugin:${springBootVersion}")
			}
		}
		
		apply plugin: 'spring-boot'
		apply plugin: 'eclipse'
		
		task wrapper(type: Wrapper) {
		    gradleVersion = '3.1'
		}

* and **replace** java version, repository declaration and dependencies block with:

		sourceCompatibility = 1.8
		targetCompatibility = 1.8
		
		
		repositories {
		     mavenCentral()
		}
		
		dependencies {
		    compile("org.springframework.boot:spring-boot-starter-web:${springBootVersion}")
		    testCompile("org.springframework.boot:spring-boot-starter-test:${springBootVersion}")
		    compile("org.apache.tomcat.embed:tomcat-embed-jasper:9.0.0.M11")
			compile("javax.servlet:jstl:1.2")
		}

* From the terminal console, run `gradle wrapper` in order to set up the gradle wrapper (from now on you will be able to use `./gradlew`)
* From the terminal console, run `./gradlew eclipse` in order to configure  your workspace (remember to refresh the project in the package explorer). This will allow you to use Spring Boot libraries from the STS.
* Declare the entry point of your Spring Boot web application by creating this class in the root package in your source folder (feel free to change its name):

		package com.pluralsight;
		
		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		
		@SpringBootApplication
		public class LabMvcApplication {
			
		    public static void main(String[] args) {
		        SpringApplication.run(LabMvcApplication.class, args);
		    }
		}
	
* Configure your view handler to use JSPs by creating a class with the following content in the root package in your source folder. 

		package com.pluralsight;
		
		import org.springframework.context.annotation.Bean;
		import org.springframework.context.annotation.Configuration;
		import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
		import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
		import org.springframework.web.servlet.view.InternalResourceViewResolver;
		import org.springframework.web.servlet.view.JstlView;
		
		@Configuration
		public class WebConfig extends WebMvcConfigurerAdapter {
			// Handles HTTP GET requests for /resources/** by efficiently serving up static 
				// resources in the ${webappRoot}/resources/ directory
				@Override
				public void addResourceHandlers(ResourceHandlerRegistry registry) {
					registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
				}
				  
				//Resolves views selected for rendering by @Controllers to .jsp resources in the 
				// /WEB-INF/views directory
				@Bean
				public InternalResourceViewResolver viewResolver() {
					InternalResourceViewResolver viewResolver = 
			                        new InternalResourceViewResolver();
					viewResolver.setViewClass(JstlView.class);
					viewResolver.setPrefix("/WEB-INF/jsp/");
					viewResolver.setSuffix(".jsp");
					viewResolver.setOrder(2);
					return viewResolver;
				}
		}

* From the terminal console, you can run the web application using `./gradlew bootRun`
* You will also be able to run/debug your application from the `Boot Dashboard` (without Gradle)
* An example of a *translated* project can be found [here](https://github.com/uol-inf/CO2006-16-17/tree/master/sprint2/SpringMvc_Pluralsight) for the exercise `4-springmvc-m4-controllers-exercise-files/after` from Pluralsight (available under tab `Exercise files` of the [tutorial Spring MVC fundamentals](https://app.pluralsight.com/library/courses/springmvc-intro/table-of-contents))

 





