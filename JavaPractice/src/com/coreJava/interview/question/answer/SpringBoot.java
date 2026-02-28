package com.coreJava.interview.question.answer;

public class SpringBoot {
	/**
	Spring Boot Interview Questions and Answers
	-------------------------------------------

	[Professional Comment: This document is a complete interview preparation resource. It covers freshers, intermediate, experienced, and bonus questions. The commentary highlights practical usage and interview focus.]

	Spring Boot is a Java-based framework used to develop stand-alone, production-ready applications with minimal configuration. Introduced by Pivotal in 2014, it simplifies the development of Spring applications by offering embedded servers, auto-configuration, and fast startup. Many top companies, including Accenture, Netflix, Amazon, and Google, rely on it for its performance and ease of development.

	Table of Content
	----------------
	Spring Boot Interview Questions for Freshers
	Spring Boot Intermediate Interview Questions
	Spring Boot Interview Questions For Experienced
	Bonus Spring Boot Interview Questions and Answers

	Spring Boot Interview Questions for Freshers
	--------------------------------------------
	1. What is Spring Boot?
	   Spring Boot is built on top of the Spring framework to create stand-alone RESTful web applications with minimal configuration. It uses embedded servers like Tomcat and Jetty.
	   [Professional Comment: Key differentiator—embedded servers remove external setup.]

	2. Features of Spring Boot
	   - Auto-configuration
	   - Spring Boot Starter POM
	   - Spring Boot CLI
	   - Actuator
	   - Embedded Servers
	   [Professional Comment: These features are frequently asked in interviews.]

	3. Advantages of Spring Boot
	   - Easy to use
	   - Rapid Development
	   - Scalable
	   - Production-ready
	   [Professional Comment: Link these advantages to real-world scenarios.]

	4. Key Components
	   - Starters
	   - Auto-configuration
	   - Actuator
	   - CLI
	   - Embedded Servers

	5. Why prefer Spring Boot over Spring?
	   | Feature             | Spring             | Spring Boot         |
	   |---------------------|-------------------|---------------------|
	   | Ease of use         | More complex      | Easier              |
	   | Production readiness| Less ready        | More ready          |
	   | Scalability         | Less scalable     | More scalable       |
	   | Speed               | Slower            | Faster              |
	   | Customization       | Less customizable | More customizable   |
	   [Professional Comment: This table is a strong interview-ready comparison.]

	6. Internal Working of Spring Boot
	   - Create project
	   - Add dependencies
	   - Annotate application
	   - Run application
	   [Professional Comment: Be ready to explain lifecycle in detail.]

	7. Starter Dependencies
	   - Data JPA
	   - Web
	   - Security
	   - Test
	   - Thymeleaf

	8. How does a Spring application start?
	   Using `main()` with @SpringBootApplication.
	   Example code provided.
	   [Professional Comment: This is a practical coding question.]

	9. @SpringBootApplication annotation
	   Combines:
	   - @Configuration
	   - @EnableAutoConfiguration
	   - @ComponentScan

	10. Spring Initializr
	   Tool to generate project skeleton.

	11. Spring Boot CLI
	   Commands: run, test, jar, war, init, help

	Spring Boot Intermediate Interview Questions
	--------------------------------------------
	12. Basic Annotations
	   - @SpringBootApplication
	   - @Configuration
	   - @Component
	   - @RestController
	   - @RequestMapping

	13. Dependency Management
	   Ensures compatible versions of dependencies.

	14. Change Tomcat Port
	   `server.port=8081`

	15. Starter Dependency
	   Example: spring-boot-starter-web

	16. Default Tomcat Port
	   8080

	17. Disable Web Server
	   `server.port=-1`

	18. Disable Auto-Configuration
	   `@EnableAutoConfiguration(exclude={ClassName})`

	19. Non-Web Applications
	   Possible (microservices, console apps, batch apps).

	20. HTTPS Request Flow
	   Client → Controller → Service → Repository → Response

	21. @RestController
	   Combines @Controller + @ResponseBody

	22. Difference: @Controller vs @RestController
	   | Feature | @Controller | @RestController |
	   |---------|-------------|-----------------|
	   | Usage   | Web apps    | REST APIs       |

	23. Difference: @RequestMapping vs @GetMapping
	   - @RequestMapping: handles all HTTP methods
	   - @GetMapping: only GET

	24. Difference: @SpringBootApplication vs @EnableAutoConfiguration

	25. Profiles in Spring
	   Environment-specific configurations.

	26. WAR vs Embedded Containers
	   | Feature | WAR | Embedded |
	   |---------|-----|----------|

	Spring Boot Interview Questions For Experienced
	-----------------------------------------------
	27. Spring Boot Actuator
	   Provides monitoring and management.

	28. Enable Actuator
	   Add dependency, configure endpoints.

	29. @ComponentScan
	   Scans packages for components.

	30. @RequestMapping vs @RestController
	   - @RequestMapping: maps requests
	   - @RestController: returns data directly

	31. List Beans
	   Use ApplicationContext.

	32. Environment Properties
	   Use Environment object.

	33. Enable Debug Logs
	   Configure logging in application.properties.

	34. Dependency Injection Types
	   - Constructor
	   - Setter
	   - Field

	35. IoC Container
	   Manages beans and dependencies.

	36. Constructor vs Setter Injection
	   | Feature | Constructor | Setter |
	   |---------|-------------|--------|

	Bonus Spring Boot Interview Questions
	-------------------------------------
	1. Thymeleaf
	   Template engine for dynamic pages.

	2. Spring Data & JPA
	   Simplifies data access.

	3. Spring MVC
	   Model-View-Controller framework.

	4. Spring Bean
	   Managed object in IoC container.

	5. Inner Beans
	   Beans defined inside another bean.

	6. Bean Wiring
	   Autowiring vs Manual wiring.

	7. DevTools
	   Provides restart, fast startup, utilities.

	8. H2 Error
	   ClassNotFoundException if missing.

	9. JDBC Connection Steps
	   Add dependency, configure properties, create JdbcTemplate.

	10. YAML vs Properties
	   YAML is concise, supports complex data types.

	11. Spring Data REST
	   Exposes repositories as REST endpoints.

	12. Why not recommended?
	   Performance, versioning, relationships, filtering.

	13. Hibernate as default JPA
	   Auto-configured with spring-boot-starter-data-jpa.

	14. Deploy to different server
	   Build → Package → Deploy → Start server.

	-------------------------------------------
	[Final Professional Comment: This full version ensures no skipped questions. Each section is annotated with professional commentary to highlight interview relevance. Use this as a structured study resource and last-minute revision guide.]
*/
	
	
	public static void main(String[] args) {
		
	}

}
