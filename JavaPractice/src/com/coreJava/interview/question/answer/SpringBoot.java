package com.coreJava.interview.question.answer;

public class SpringBoot {
	/**
	Spring Boot Interview Questions (Complete Guide)
	================================================

	[Professional Comment: This document is a consolidated interview preparation resource. It covers 70+ questions, including 30+ real-time scenario, coding, and project-based questions. Each answer is annotated with professional commentary to highlight interview relevance.]

	Q1. What is Spring Boot and why is it used?
Spring Boot is a framework built on top of Spring that simplifies application development by:
- Removing boilerplate configuration
- Providing auto-configuration
- Offering starter dependencies
- Embedding servers like Tomcat/Jetty
- Providing production-ready features (Actuator, metrics, health checks)
Use case: Instead of configuring DispatcherServlet, DataSource, Hibernate manually, Spring Boot auto-configures them based on classpath.

Q2. What is @SpringBootApplication?
It is a meta-annotation combining:
- @Configuration: This annotation configures the beans and packages in the class path.
- @EnableAutoConfiguration: This annotation automatically configuring beans in the class path and automatically scans the dependencies according to the application need.
- @ComponentScan: This annotation scans the components (@Component, @Service, etc.) in the package of annotated class and its sub-packages
Code:
@SpringBootApplication
public class App { public static void main(String[] args){ SpringApplication.run(App.class,args); } }

Q3. What is auto-configuration?
Spring Boot checks:
- Classpath (e.g., spring-webmvc)
- Beans in context
- Conditional annotations
- spring.factories files
Auto-config can be disabled using:
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})

Q4. Difference between @Controller and @RestController?
@Controller This annotation is the most generic annotation for any Spring-managed component. It is used to mark a class as a Spring bean that will be managed by the Spring container.
returns views (JSP/Thymeleaf).
@RestController =  This annotation is used to define a RESTful web service controller. It is a specialized version of the @Controller annotation that includes the @ResponseBody annotation by default.
-@Controller + @ResponseBody, returns JSON.
Code:
@RestController
@GetMapping("/users") public List<User> get(){ return service.findAll(); }

Q5. What is Spring Boot Actuator?
Provides production-ready endpoints:
- /actuator/health
- /actuator/metrics
- /actuator/env
Used for monitoring with Prometheus/Grafana.

Q6. How to implement global exception handling?
Use @ControllerAdvice + @ExceptionHandler.
Code:
@ControllerAdvice
public class GlobalHandler {
 @ExceptionHandler(Exception.class)
 public ResponseEntity<String> handle(Exception ex){
   return ResponseEntity.badRequest().body(ex.getMessage());
 }
}

Q7. How to secure REST APIs with JWT?
Steps:
1. User logs in → generate JWT
2. Client sends token in Authorization header
3. Filter validates token
Code:
public class JwtFilter extends OncePerRequestFilter {
 protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
 throws IOException, ServletException {
   String token = req.getHeader("Authorization");
   if(token!=null && jwtUtil.validate(token)){
     UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(user,null,roles);
     SecurityContextHolder.getContext().setAuthentication(auth);
   }
   chain.doFilter(req,res);
 }
}

Q8. How to connect Spring Boot with PostgreSQL?
application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update

Q9. How to implement caching?
Use @EnableCaching + @Cacheable.
Code:
@Service
public class UserService {
 @Cacheable("users")
 public User get(Long id){ return repo.findById(id).orElseThrow(); }
}

Q10. How to write unit tests for controllers?
Use @WebMvcTest + MockMvc.
Code:
@WebMvcTest(UserController.class)
class Test {
 @Autowired MockMvc mvc;
 @Test void test() throws Exception {
   mvc.perform(get("/users/1")).andExpect(status().isOk());
 }
}

Q11. What are Spring Boot starters?
Pre-configured dependency bundles.
Example: spring-boot-starter-web includes:
- Spring MVC
- Jackson
- Tomcat

Q12. What is the difference between application.properties and application.yml?
Both configure Spring Boot.
properties → key=value
yml → hierarchical, cleaner.
Example:
spring:
  datasource:
    url: jdbc:mysql://localhost:3306/db

Q13. What are Spring Profiles?
Used for environment-specific configs.
Activate:
spring.profiles.active=dev
Use:
@Profile("prod")

Q14. How to override auto-configuration?
Ways:
- Define your own bean
- Use exclude in @EnableAutoConfiguration
- Use spring.autoconfigure.exclude in properties

Q15. What is @ComponentScan?
Tells Spring where to scan for beans.
Default: same package and subpackages of main class.

Q16. What is dependency Injection and its types?
Dependency Injection (DI) is a design pattern that enables us to produce loosely coupled components. In DI, an object's ability to complete a task depends on another object. There three types of dependency Injections.

Constructor injection: This is the most common type of DI in Spring Boot. In constructor injection, the dependency object is injected into the dependent object's constructor.
Setter injection: In setter injection, the dependency object is injected into the dependent object's setter method.
Field injection : In field injection, the dependency object is injected into the dependent object's field.

Q17. What is Inversion of Control?
An IoC (Inversion of Control) Container in Spring Boot is essentially a central manager for the application objects that controls the creation, configuration,
 and management of dependency injection of objects (often referred to as beans), also referred to as a DI (Dependency Injection) container

Q18. What is the Spring Bean lifecycle?
Steps:
1. Instantiate
2. Populate properties
3. BeanNameAware
4. BeanFactoryAware
5. Pre-initialization BeanPostProcessors
6. @PostConstruct
7. Initialization
8. Post-initialization BeanPostProcessors
9. @PreDestroy

Q19. What is @Bean?
Used inside @Configuration to define beans manually.
Code:
@Bean
public ModelMapper mapper(){ return new ModelMapper(); }

Q20. What is @Configuration?
Marks a class as a source of bean definitions.
Equivalent to XML config.

Q21. How do you create REST APIs in Spring Boot?
Use @RestController and @RequestMapping.
Code:
@RestController
@RequestMapping("/api/users")
public class UserController {
 @GetMapping("/{id}")
 public User get(@PathVariable Long id){ return service.find(id); }
}

Q22. How do you validate request payloads?
Use @Valid + validation annotations.
DTO:
public class UserDTO {
 @NotNull @Size(min=3)
 private String name;
}
Controller:
@PostMapping
public ResponseEntity<?> save(@Valid @RequestBody UserDTO dto){ ... }

Q23. How do you handle file uploads?
Use MultipartFile.
Code:
@PostMapping("/upload")
public String upload(@RequestParam MultipartFile file) throws Exception {
 file.transferTo(new File("/uploads/" + file.getOriginalFilename()));
 return "Uploaded";
}

Q24. How do you consume REST APIs in Spring Boot?
Use WebClient (reactive) or RestTemplate (blocking).
Code (WebClient):
WebClient client = WebClient.create();
User user = client.get().uri("http://localhost:8080/users/1")
 .retrieve().bodyToMono(User.class).block();

Q25. Difference between RestTemplate and WebClient?
RestTemplate:
- Blocking
- Synchronous
WebClient:
- Non-blocking
- Asynchronous
- Supports reactive streams

Q26. How do you implement pagination in REST APIs?
Use Pageable and Page<T>.
Code:
@GetMapping
public Page<User> list(Pageable pageable){
 return repo.findAll(pageable);
}

Q27. What is HATEOAS?
Hypermedia As The Engine Of Application State.
Adds links to REST responses.
Code:
EntityModel<User> model = EntityModel.of(user);
model.add(linkTo(methodOn(UserController.class).get(user.getId())).withSelfRel());

Q28. How do you version REST APIs?
Methods:
1. URI versioning → /api/v1/users
2. Header versioning → Accept: application/vnd.company.v1+json
3. Parameter versioning → /users?version=1

Q29. How do you implement rate limiting?
Use Bucket4j or API Gateway filters.
Bucket4j example:
Bucket bucket = Bucket4j.builder().addLimit(Bandwidth.simple(10, Duration.ofMinutes(1))).build();

Q30. How do you implement logging in Spring Boot?
Use Logback (default).
application.properties:
logging.level.org.springframework=DEBUG
logging.file.name=app.log

Q31. How do you enable CORS?
Use @CrossOrigin or WebMvcConfigurer.
Code:
@CrossOrigin(origins="http://localhost:3000")
@GetMapping("/users") public List<User> get(){ ... }

Q32. How do you implement async REST calls?
Use @Async + CompletableFuture.
Code:
@Async
public CompletableFuture<User> getAsync(Long id){
 return CompletableFuture.completedFuture(repo.findById(id).orElseThrow());
}

Q33. How do you document REST APIs?
Use SpringDoc OpenAPI.
Dependency: springdoc-openapi-ui
Access: /swagger-ui.html

Q34. How do you implement request/response filters?
Extend OncePerRequestFilter.
Code:
public class LogFilter extends OncePerRequestFilter {
 protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
 throws IOException, ServletException {
   System.out.println("URI: " + req.getRequestURI());
   chain.doFilter(req,res);
 }
}

Q35. How do you implement custom error responses?
Create ErrorResponse DTO + return ResponseEntity.
Code:
public class ErrorResponse { String message; int status; }

Q36. What is Spring Data JPA?
Abstraction over JPA/Hibernate.
Provides:
- Repositories
- Derived queries
- Paging/sorting
- No boilerplate DAO code

Q37. Difference between JPA, Hibernate, Spring Data JPA?
JPA → Specification
Hibernate → Implementation
Spring Data JPA → Abstraction layer with repositories

Q38. How do you define an entity?
Use @Entity + @Id.
Code:
@Entity
public class User {
 @Id @GeneratedValue private Long id;
 private String name;
}

Q39. How do you create a repository?
Extend JpaRepository.
Code:
public interface UserRepo extends JpaRepository<User,Long> {
 List<User> findByName(String name);
}

Q40. What are derived query methods?
Spring generates queries based on method names.
Examples:
findByEmail(String email)
findByNameAndStatus(String name, String status)
Q41. How do you write custom queries in Spring Data JPA?
Use @Query with JPQL or native SQL.
Code:
@Query("SELECT u FROM User u WHERE u.email = ?1")
User findByEmail(String email);

Native:
@Query(value="SELECT * FROM users WHERE status=?1", nativeQuery=true)
List<User> findByStatus(String status);

Q42. How do you implement pagination and sorting?
Use Pageable and PageRequest.
Code:
Page<User> page = repo.findAll(PageRequest.of(0,10,Sort.by("name")));

Q43. How do you handle relationships in JPA?
Use:
@OneToOne
@OneToMany
@ManyToOne
@ManyToMany
Example:
@OneToMany(mappedBy="user")
private List<Order> orders;

Q44. Difference between LAZY and EAGER loading?
LAZY → loads related data only when accessed.
EAGER → loads related data immediately.
Best practice: Always use LAZY for collections.

Q45. How do you handle transactions in Spring Boot?
Use @Transactional.
Code:
@Transactional
public void transfer(Long from, Long to, double amount){ ... }

Q46. How do you configure multiple datasources?
Steps:
1. Define multiple DataSource beans
2. Define multiple EntityManagerFactory beans
3. Use @EnableJpaRepositories with entityManagerFactoryRef

Q47. How do you implement auditing in JPA?
Use @CreatedDate, @LastModifiedDate.
Enable:
@EnableJpaAuditing
Entity:
@EntityListeners(AuditingEntityListener.class)

Q48. How do you handle database migrations?
Use Flyway or Liquibase.
Flyway:
- SQL scripts: V1__init.sql
Liquibase:
- XML/YAML changelogs

Q49. How do you implement soft deletes?
Add boolean deleted flag OR use Hibernate @SQLDelete.
Code:
@SQLDelete(sql="UPDATE user SET deleted=true WHERE id=?")
@Where(clause="deleted=false")

Q50. How do you optimize JPA performance?
Techniques:
- Use JOIN FETCH to avoid N+1
- Use DTO projections
- Enable batch fetching
- Use LAZY loading
- Use indexes

Q51. How do you write native queries?
Use @Query with nativeQuery=true.
Code:
@Query(value="SELECT * FROM users WHERE id=?1", nativeQuery=true)
User findNative(Long id);

Q52. What are projections in Spring Data JPA?
Used to return partial data.
Interface projection:
public interface UserView { String getName(); }

Q53. How do you implement optimistic and pessimistic locking?
Optimistic:
@Version private int version;
Pessimistic:
@Lock(LockModeType.PESSIMISTIC_WRITE)

Q54. How do you connect Spring Boot with NoSQL?
Use:
- spring-boot-starter-data-mongodb
- spring-boot-starter-data-redis
- spring-boot-starter-data-cassandra

Q55. How do you test JPA repositories?
Use @DataJpaTest.
Code:
@DataJpaTest
class RepoTest {
 @Autowired UserRepo repo;
}

Q56. How do you implement global exception handling?
Use @ControllerAdvice + @ExceptionHandler.
Code:
@ControllerAdvice
class GlobalHandler {
 @ExceptionHandler(Exception.class)
 public ResponseEntity<?> handle(Exception ex){
   return ResponseEntity.badRequest().body(ex.getMessage());
 }
}

Q57. How do you create custom error responses?
Create ErrorResponse DTO.
Return via ResponseEntity.
Code:
return ResponseEntity.status(400).body(new ErrorResponse("Invalid",400));

Q58. How do you secure REST APIs with Spring Security?
Use SecurityFilterChain.
Code:
@Bean
SecurityFilterChain filter(HttpSecurity http) throws Exception {
 return http.csrf().disable()
   .authorizeHttpRequests(auth->auth.anyRequest().authenticated())
   .httpBasic().and().build();
}

Q59. How do you implement JWT authentication?
Steps:
1. User logs in → generate token
2. Client sends token in Authorization header
3. Filter validates token
4. SecurityContext stores authentication

Q60. How do you implement role-based access control?
Use @PreAuthorize.
Code:
@PreAuthorize("hasRole('ADMIN')")
@GetMapping("/admin")
public String admin(){ return "admin"; }
Q61. How do you connect Spring Boot with PostgreSQL?
Add dependencies:
- spring-boot-starter-data-jpa
- postgresql driver
application.properties:
spring.datasource.url=jdbc:postgresql://localhost:5432/mydb
spring.datasource.username=postgres
spring.datasource.password=pass
spring.jpa.hibernate.ddl-auto=update

Q62. How do you implement caching in Spring Boot?
Enable caching:
@EnableCaching
Use @Cacheable:
@Cacheable("users")
public User get(Long id){ return repo.findById(id).orElseThrow(); }

Q63. How do you implement scheduled tasks?
Enable:
@EnableScheduling
Use @Scheduled:
@Scheduled(fixedRate=5000)
public void job(){ System.out.println("Runs every 5 seconds"); }

Q64. How do you send emails in Spring Boot?
Use JavaMailSender.
Code:
@Autowired JavaMailSender sender;
public void send(){
 SimpleMailMessage msg = new SimpleMailMessage();
 msg.setTo("test@gmail.com");
 msg.setSubject("Hello");
 msg.setText("Mail body");
 sender.send(msg);
}

Q65. How do you consume Kafka messages?
Use @KafkaListener.
Code:
@KafkaListener(topics="users", groupId="grp1")
public void consume(String msg){ System.out.println(msg); }

Q66. How do you produce Kafka messages?
Use KafkaTemplate.
Code:
@Autowired KafkaTemplate<String,String> template;
public void send(String msg){ template.send("users",msg); }

Q67. How do you implement RabbitMQ messaging?
Use spring-boot-starter-amqp.
Consumer:
@RabbitListener(queues="queue1")
public void consume(String msg){ ... }

Q68. How do you implement file download?
Code:
@GetMapping("/download")
public ResponseEntity<Resource> download(){
 Resource file = new FileSystemResource("test.txt");
 return ResponseEntity.ok()
   .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=test.txt")
   .body(file);
}

Q69. How do you implement REST API versioning?
Methods:
1. URI → /api/v1/users
2. Header → Accept: application/vnd.company.v1+json
3. Parameter → /users?version=1

Q70. How do you implement request validation?
Use @Valid + validation annotations.
DTO:
@NotNull @Size(min=3) private String name;

Q71. How do you write unit tests for REST controllers?
Use @WebMvcTest + MockMvc.
Code:
@WebMvcTest(UserController.class)
class Test {
 @Autowired MockMvc mvc;
}

Q72. How do you write integration tests?
Use @SpringBootTest.
Loads full application context.

Q73. How do you mock dependencies in tests?
Use @MockBean.
Code:
@MockBean UserService service;

Q74. How do you test JPA repositories?
Use @DataJpaTest.
Provides in-memory DB (H2).

Q75. How do you test scheduled tasks?
Use @SpringBootTest + logs or mocks to verify execution.

Q76. How do you design microservices with Spring Boot?
Use:
- Eureka for service discovery
- Spring Cloud Gateway for routing
- Feign Client for communication
- Resilience4j for fault tolerance
- Actuator + Prometheus for monitoring

Q77. How do you implement distributed tracing?
Use Sleuth + Zipkin.
Sleuth adds traceId, spanId to logs.
Zipkin visualizes traces.

Q78. How do you handle configuration in microservices?
Use Spring Cloud Config Server.
Stores config in Git.
Clients fetch config dynamically.

Q79. How do you implement service discovery?
Use Eureka Server.
Services register themselves.
Clients discover via Eureka.

Q80. How do microservices call and interact with each other?
Two ways:
1. Synchronous (HTTP)
   - Feign Client
   - RestTemplate
2. Asynchronous (Messaging)
   - Kafka
   - RabbitMQ
Flow:
Gateway → User Service → Order Service (via Feign)
Security:
JWT passed between services.
Observability:
Sleuth + Zipkin.
Q81. How do you implement API Gateway in Spring Boot?
Use Spring Cloud Gateway.
Features:
- Routing
- Filters
- Load balancing
- Authentication
Example route:
spring:
  cloud:
    gateway:
      routes:
        - id: user-service
          uri: lb://USER-SERVICE
          predicates:
            - Path=/users/**

Q82. How do you implement fault tolerance in microservices?
Use Resilience4j.
Patterns:
- Circuit breaker
- Retry
- Rate limiter
- Bulkhead
Code:
@CircuitBreaker(name="userService", fallbackMethod="fallback")
public User getUser(Long id){ ... }

Q83. How do you implement centralized logging?
Use ELK stack:
- Logstash → collects logs
- Elasticsearch → stores logs
- Kibana → visualizes logs
Spring Boot logs sent to Logstash via TCP/UDP.

Q84. How do you monitor Spring Boot applications?
Use Actuator + Prometheus + Grafana.
Expose metrics:
management.endpoints.web.exposure.include=metrics,health,prometheus

Q85. How do you deploy Spring Boot in Docker?
Dockerfile:
FROM openjdk:17-jdk-slim
COPY target/app.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]

Q86. How do you deploy Spring Boot in Kubernetes?
Steps:
1. Build Docker image
2. Create Deployment YAML
3. Create Service YAML
4. Use ConfigMaps/Secrets
5. Use HPA for autoscaling

Q87. How do you externalize configuration?
Ways:
- application.properties
- application.yml
- Environment variables
- Spring Cloud Config Server
- Kubernetes ConfigMaps

Q88. How do you secure secrets?
Use:
- Spring Cloud Vault
- Kubernetes Secrets
- Environment variables
Never hardcode passwords.

Q89. How do you implement resilience in distributed systems?
Use:
- Circuit breaker
- Retry
- Timeout
- Bulkhead
- Fallback
Resilience4j provides all.

Q90. How do you implement load balancing?
Use Spring Cloud LoadBalancer.
Feign Client automatically load balances when using Eureka.

Q91. How do you implement API rate limiting?
Use Bucket4j.
Example:
Bucket bucket = Bucket4j.builder()
 .addLimit(Bandwidth.simple(10, Duration.ofMinutes(1)))
 .build();

Q92. What is blue-green deployment?
Two environments:
- Blue (current)
- Green (new)
Switch traffic to green after testing.
Rollback is instant.

Q93. What is canary deployment?
Release new version to small % of users.
Gradually increase traffic.
Monitor errors before full rollout.

Q94. How do you handle DB migrations in CI/CD?
Use Flyway/Liquibase.
Pipeline steps:
1. Run migrations
2. Run tests
3. Deploy application

Q95. How do you scale Spring Boot horizontally?
- Deploy multiple instances
- Use load balancer
- Make app stateless
- Store sessions in Redis

Q96. Difference between @Bean, @Component, @Service, @Repository?
@Bean → manual bean creation
@Component → generic bean
@Service → business logic
@Repository → DAO layer + exception translation

Q97. What is @Configuration?
Defines bean configuration class.
Equivalent to XML config.

Q98. What is @EnableAutoConfiguration?
Enables Spring Boot auto-config.
Included inside @SpringBootApplication.

Q99. What is @ConditionalOnClass and @ConditionalOnMissingBean?
Used in auto-configuration.
@ConditionalOnClass → load bean only if class exists
@ConditionalOnMissingBean → load bean only if not already defined

Q100. What is @Lazy?
Delays bean initialization until first use.
Improves startup time.
Q101. What is @Primary?
Marks a bean as the default when multiple beans of the same type exist.
Example:
@Bean @Primary
public ModelMapper mapper1(){ return new ModelMapper(); }

Q102. What is @Qualifier?
Used to resolve bean ambiguity.
Example:
@Autowired @Qualifier("emailService")
private NotificationService service;

Q103. What is @Value?
Injects values from properties.
Example:
@Value("${app.name}")
private String appName;

Q104. What is @ConfigurationProperties?
Binds external properties to a POJO.
Example:
@ConfigurationProperties(prefix="app")
public class AppConfig { private String name; }

Q105. What is @EnableScheduling?
Enables scheduled tasks.
Used with @Scheduled.

Q106. What is @EnableCaching?
Enables caching support.
Used with @Cacheable, @CachePut, @CacheEvict.

Q107. What is @EnableJpaRepositories?
Enables scanning for JPA repositories.
Example:
@EnableJpaRepositories(basePackages="com.app.repo")

Q108. What is @EntityScan?
Specifies packages to scan for JPA entities.
Example:
@EntityScan("com.app.entity")

Q109. What is @Transactional?
Defines transactional boundaries.
Default rollback: RuntimeException.
To rollback checked exceptions:
@Transactional(rollbackFor=Exception.class)

Q110. What is @RestControllerAdvice?
Combination of:
- @ControllerAdvice
- @ResponseBody
Used for global exception handling in REST APIs.

Q111. What is @SpringBootTest?
Loads full application context for integration testing.
Example:
@SpringBootTest
class AppTest { ... }

Q112. What is @DataJpaTest?
Loads only JPA components.
Uses in-memory DB (H2) by default.

Q113. What is @WebMvcTest?
Loads only web layer (controllers).
Does not load service or repository beans.

Q114. What is @MockBean?
Creates a mock bean in Spring context.
Used in tests to mock dependencies.

Q115. What is @EnableFeignClients?
Enables Feign Client support for inter-service communication.
Example:
@FeignClient(name="order-service")
public interface OrderClient { ... }

Q116. How do microservices call and interact with each other?
Two ways:
1. Synchronous (HTTP)
   - Feign Client
   - RestTemplate
2. Asynchronous (Messaging)
   - Kafka
   - RabbitMQ
Architecture:
Gateway → User Service → Order Service
Security:
JWT passed between services.
Observability:
Sleuth + Zipkin.

Q117. How do you implement OAuth2 in Spring Boot?
Use:
spring-boot-starter-oauth2-resource-server
Configure JWT validation:
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=...

Q118. How do you secure microservices with API Gateway?
Gateway validates JWT.
Downstream services trust gateway.
Use filters for:
- Authentication
- Rate limiting
- Logging

Q119. How do you integrate Spring Boot with Keycloak?
Add Keycloak adapter.
Configure:
spring.security.oauth2.resourceserver.jwt.issuer-uri=http://localhost:8080/realms/myrealm

Q120. How do you implement CSRF protection?
Enabled by default.
Disable for REST APIs:
http.csrf().disable();
Q121. How do you secure Actuator endpoints?
Actuator exposes sensitive endpoints like /env, /beans, /metrics.
Secure them using Spring Security.
Example:
management.endpoints.web.exposure.include=health,info
http.authorizeHttpRequests(auth -> auth
  .requestMatchers("/actuator/**").hasRole("ADMIN")
);

Q122. How do you implement HTTPS in Spring Boot?
Steps:
1. Generate keystore:
keytool -genkeypair -alias spring -keyalg RSA -keystore springboot.jks
2. Configure:
server.port=8443
server.ssl.key-store=classpath:springboot.jks
server.ssl.key-store-password=123456

Q123. What is Spring WebFlux?
Reactive, non-blocking web framework.
Uses:
- Reactor (Mono, Flux)
- Netty server
Better for high concurrency.

Q124. How do you create reactive REST APIs?
Use Mono and Flux.
Example:
@GetMapping("/users")
public Flux<User> getAll(){ return service.getAll(); }

Q125. How do you connect WebFlux with MongoDB?
Use spring-boot-starter-data-mongodb-reactive.
Repository:
public interface UserRepo extends ReactiveMongoRepository<User,String> {}

Q126. How do you implement reactive security?
Use SecurityWebFilterChain.
Example:
@Bean
SecurityWebFilterChain security(ServerHttpSecurity http){
 return http.csrf().disable()
   .authorizeExchange(ex -> ex.anyExchange().authenticated())
   .httpBasic().and().build();
}

Q127. How do you test reactive code?
Use StepVerifier.
Example:
StepVerifier.create(service.getAll())
  .expectNextCount(3)
  .verifyComplete();

Q128. How do you test asynchronous code?
Use Awaitility.
Example:
Awaitility.await().atMost(5,SECONDS)
  .until(() -> service.isCompleted());

Q129. How do you use Testcontainers?
Runs real DB in Docker for tests.
Example:
@Container
static PostgreSQLContainer<?> db = new PostgreSQLContainer<>("postgres:15");

Q130. How do you mock Feign Clients?
Use @MockBean.
Example:
@MockBean OrderClient client;

Q131. How do you test Kafka consumers?
Use EmbeddedKafka.
Example:
@EmbeddedKafka(partitions=1, topics={"users"})

Q132. How do you test REST APIs end-to-end?
Use RestAssured.
Example:
given().get("/users/1").then().statusCode(200);

Q133. How do you tune HikariCP?
Properties:
spring.datasource.hikari.maximum-pool-size=20
spring.datasource.hikari.connection-timeout=30000
spring.datasource.hikari.idle-timeout=600000

Q134. How do you implement distributed caching?
Use Redis.
@EnableCaching
@Cacheable("users")
public User get(Long id){ ... }

Q135. How do you handle large file uploads?
Increase limits:
spring.servlet.multipart.max-file-size=50MB
Use streaming:
InputStream in = file.getInputStream();

Q136. How do you optimize Spring Boot startup time?
Techniques:
- Lazy initialization
- Remove unused starters
- Exclude heavy auto-configurations
- Use GraalVM native image

Q137. How do you profile performance?
Tools:
- Actuator metrics
- JProfiler
- VisualVM
- Micrometer

Q138. How do you deploy Spring Boot on AWS?
Options:
- EC2 (JAR)
- ECS (Docker)
- EKS (Kubernetes)
- Elastic Beanstalk
Use RDS for database.

Q139. How do you deploy Spring Boot on Azure?
Options:
- Azure App Service
- Azure Kubernetes Service (AKS)
- Azure Container Instances

Q140. How do you deploy Spring Boot on Google Cloud?
Options:
- Google Kubernetes Engine (GKE)
- Cloud Run (serverless)
- Compute Engine (VM)
Q141. How do you implement centralized configuration using Spring Cloud Config?
Spring Cloud Config allows storing configuration in a Git repo.
Steps:
1. Create Config Server
@EnableConfigServer
2. Configure Git repo:
spring.cloud.config.server.git.uri=https://github.com/repo/config
3. Client fetches config:
spring.config.import=optional:configserver:http://localhost:8888
4. Use @RefreshScope for dynamic refresh.

Q142. How do you refresh configuration without restarting the service?
Use:
- Spring Cloud Config
- @RefreshScope
- /actuator/refresh endpoint
Example:
@RefreshScope
@Service
public class MsgService {
 @Value("${app.message}")
 private String msg;
}

Q143. What is the difference between @RefreshScope and @ConfigurationProperties?
@RefreshScope → reloads bean when /refresh is called  
@ConfigurationProperties → binds external config to POJO  
Both can be used together.

Q144. How do you implement distributed session management?
Use Spring Session with Redis.
Dependency:
spring-session-data-redis
Config:
spring.session.store-type=redis
This allows multiple instances to share session data.

Q145. How do you implement API throttling in Spring Boot?
Use Bucket4j.
Example:
Bucket bucket = Bucket4j.builder()
 .addLimit(Bandwidth.simple(100, Duration.ofMinutes(1)))
 .build();
Check before processing request:
if(bucket.tryConsume(1)) { proceed } else { reject }

Q146. How do you implement request tracing in microservices?
Use Spring Cloud Sleuth.
Adds:
- traceId
- spanId
Automatically propagates across services.
Works with Zipkin/Jaeger.

Q147. How do you implement distributed transactions?
Use Saga pattern.
Two types:
1. Orchestration → central coordinator
2. Choreography → events via Kafka
Avoid 2PC (two-phase commit) in microservices.

Q148. What is the Saga pattern?
A sequence of local transactions coordinated by events.
If a step fails → compensating transaction is triggered.
Used in order-payment-inventory workflows.

Q149. How do you implement event-driven microservices?
Use Kafka or RabbitMQ.
Producer:
template.send("orders", order);
Consumer:
@KafkaListener(topics="orders")
public void consume(Order o){ ... }

Q150. How do you implement graceful shutdown?
Enable:
server.shutdown=graceful
Spring waits for active requests to finish before stopping.
Useful in Kubernetes rolling updates.

Q151. How do you implement multi-tenancy in Spring Boot?
Two approaches:
1. Database-per-tenant
2. Schema-per-tenant
Use Hibernate MultiTenantConnectionProvider.
Tenant identified via:
- Header
- Subdomain
- JWT claim

Q152. How do you implement OpenAPI 3 documentation?
Use SpringDoc.
Dependency:
springdoc-openapi-starter-webmvc-ui
Access:
http://localhost:8080/swagger-ui.html

Q153. How do you implement custom starter in Spring Boot?
Steps:
1. Create auto-config class
2. Use @Configuration + @ConditionalOnClass
3. Register in META-INF/spring.factories
4. Package as dependency
Used to share common configs across microservices.

Q154. How do you optimize memory usage in Spring Boot?
Techniques:
- Reduce heap size
- Use G1GC or ZGC
- Remove unused starters
- Disable JMX
- Use lazy initialization
- Use GraalVM native image

Q155. How do you optimize CPU usage in Spring Boot?
- Use WebFlux for high concurrency
- Tune thread pools
- Use caching
- Reduce serialization overhead
- Use async processing

Q156. How do you implement health checks for microservices?
Use Actuator:
- /actuator/health
Add custom health indicators:
@Component
public class DbHealth implements HealthIndicator {
 public Health health(){ return Health.up().build(); }
}

Q157. How do you implement readiness and liveness probes in Kubernetes?
Add Actuator probes:
management.endpoint.health.probes.enabled=true
K8s YAML:
livenessProbe:
  httpGet:
    path: /actuator/health/liveness
readinessProbe:
  httpGet:
    path: /actuator/health/readiness

Q158. How do you handle partial failures in microservices?
Use:
- Circuit breaker
- Retry
- Timeout
- Fallback
- Event-driven architecture
- Idempotent operations

Q159. How do you ensure idempotency in REST APIs?
Techniques:
- Use PUT instead of POST
- Use unique request IDs
- Store processed request IDs
- Use database constraints

Q160. How do you implement bulkhead pattern?
Separate thread pools for different operations.
Example:
ExecutorService poolA = Executors.newFixedThreadPool(10);
ExecutorService poolB = Executors.newFixedThreadPool(5);
Prevents one failing component from exhausting all resources.
Q161. How do you implement idempotent REST APIs?
Idempotency ensures that multiple identical requests have the same effect.
Techniques:
1. Use PUT instead of POST for updates.
2. Use unique request IDs.
3. Store processed request IDs in DB/Redis.
4. Use database constraints (unique keys).
Example:
If payment request is retried, check if requestId already processed.

Q162. How do you implement distributed locks?
Use Redis or Zookeeper.
Redis example:
SETNX lock_key "value"
Expire lock after timeout.
Used for:
- Preventing duplicate job execution
- Synchronizing microservices

Q163. How do you implement asynchronous communication between microservices?
Use:
- Kafka
- RabbitMQ
- AWS SNS/SQS
Producer sends event → Consumer processes event.
Improves scalability and decoupling.

Q164. How do you implement CQRS in Spring Boot?
CQRS = Command Query Responsibility Segregation.
Commands → write DB  
Queries → read DB  
Benefits:
- Scalability
- Separation of concerns
- Event sourcing compatibility

Q165. What is Event Sourcing?
Instead of storing final state, store events.
Example:
OrderCreated, OrderPaid, OrderShipped.
Rebuild state by replaying events.
Used in high‑audit systems.

Q166. How do you implement WebSockets in Spring Boot?
Use spring-boot-starter-websocket.
Code:
@MessageMapping("/send")
@SendTo("/topic/messages")
public String send(String msg){ return msg; }

Q167. How do you implement server-sent events (SSE)?
Use Flux.
@GetMapping(value="/stream", produces=MediaType.TEXT_EVENT_STREAM_VALUE)
public Flux<String> stream(){ return Flux.interval(Duration.ofSeconds(1)).map(i -> "msg " + i); }

Q168. How do you implement file streaming?
Use InputStreamResource.
@GetMapping("/stream")
public ResponseEntity<InputStreamResource> stream() throws Exception {
 FileInputStream in = new FileInputStream("video.mp4");
 return ResponseEntity.ok().body(new InputStreamResource(in));
}

Q169. How do you implement batch processing?
Use Spring Batch.
Components:
- Job
- Step
- ItemReader
- ItemProcessor
- ItemWriter
Used for:
- ETL
- Data migration
- Scheduled jobs

Q170. How do you schedule batch jobs?
Use @EnableScheduling + JobLauncher.
@Scheduled(cron="0 0 * * * *")
public void runJob(){ launcher.run(job, params); }

Q171. How do you implement custom authentication?
Create custom AuthenticationProvider.
Code:
public class CustomAuth implements AuthenticationProvider {
 public Authentication authenticate(Authentication auth){
   String user = auth.getName();
   String pass = auth.getCredentials().toString();
   if(valid(user,pass)) return new UsernamePasswordAuthenticationToken(user,pass,new ArrayList<>());
   throw new BadCredentialsException("Invalid");
 }
}

Q172. How do you implement custom authorization?
Use @PreAuthorize with SpEL.
@PreAuthorize("@authService.canAccess(#id)")
public User get(Long id){ ... }

Q173. How do you implement two-factor authentication (2FA)?
Steps:
1. User logs in with username/password.
2. Generate OTP (email/SMS).
3. Validate OTP.
4. Issue JWT token.
Use:
- Twilio
- Email service

Q174. How do you implement password hashing?
Use BCryptPasswordEncoder.
@Bean
public PasswordEncoder encoder(){ return new BCryptPasswordEncoder(); }
encoder.encode("password");

Q175. How do you implement API key authentication?
Steps:
1. Store API keys in DB.
2. Create filter to validate key.
3. Reject if missing/invalid.
Filter:
String key = req.getHeader("X-API-KEY");
if(!service.isValid(key)) throw new UnauthorizedException();

Q176. How do you implement custom filters in Spring Security?
Extend OncePerRequestFilter.
Add before UsernamePasswordAuthenticationFilter.
http.addFilterBefore(new JwtFilter(), UsernamePasswordAuthenticationFilter.class);

Q177. How do you implement custom exception handling in Spring Security?
Use AuthenticationEntryPoint.
@Component
public class AuthEntry implements AuthenticationEntryPoint {
 public void commence(HttpServletRequest req, HttpServletResponse res, AuthenticationException ex){
   res.sendError(401,"Unauthorized");
 }
}

Q178. How do you implement logging for every request?
Use HandlerInterceptor.
public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler){
 System.out.println("URI: " + req.getRequestURI());
 return true;
}

Q179. How do you implement AOP in Spring Boot?
Use @Aspect.
@Aspect
@Component
public class LogAspect {
 @Before("execution(* com.app.service.*.*(..))")
 public void log(){ System.out.println("Method called"); }
}

Q180. How do you implement cross-cutting concerns using AOP?
Cross-cutting concerns:
- Logging
- Security
- Transactions
- Caching
Use:
@Before
@After
@Around
@AfterThrowing
Q181. How do you implement distributed rate limiting?
Use Redis + Bucket4j.
Each request consumes a token from a Redis bucket.
If bucket empty → reject request.
Useful for:
- API Gateway
- Microservices
- Multi-instance deployments

Q182. How do you implement distributed tracing with Jaeger?
Add dependencies:
- opentelemetry-exporter-jaeger
Configure endpoint:
otel.exporter.jaeger.endpoint=http://localhost:14250
Jaeger UI shows:
- spans
- latency
- service call graph

Q183. How do you implement correlation IDs?
Add filter:
String id = UUID.randomUUID().toString();
MDC.put("correlationId", id);
Add to logs:
%X{correlationId}
Used for debugging across microservices.

Q184. How do you implement custom metrics?
Use Micrometer.
@Autowired MeterRegistry registry;
registry.counter("orders.count").increment();
Expose via:
http://localhost:8080/actuator/prometheus

Q185. How do you implement custom health indicators?
@Component
public class DbHealth implements HealthIndicator {
 public Health health(){
   return Health.up().withDetail("db","running").build();
 }
}

Q186. How do you implement graceful shutdown in Kubernetes?
Enable:
server.shutdown=graceful
K8s waits for:
terminationGracePeriodSeconds: 30
Spring Boot finishes active requests before stopping.

Q187. How do you implement retry logic?
Use Resilience4j Retry.
@Retry(name="userService", fallbackMethod="fallback")
public User getUser(){ ... }

Q188. How do you implement timeouts?
Use:
- WebClient timeout
- Resilience4j TimeLimiter
Example:
TimeLimiterConfig.custom().timeoutDuration(Duration.ofSeconds(3));

Q189. How do you implement bulkhead isolation?
Separate thread pools.
Resilience4j:
@Bulkhead(name="serviceA", type=THREADPOOL)
Prevents cascading failures.

Q190. How do you implement message deduplication?
Use:
- Redis set of processed message IDs
- Kafka message keys
- Database unique constraints
Ensures idempotency in event-driven systems.

Q191. How do you implement dead-letter queues?
Kafka:
topic: orders
DLQ: orders.DLQ
Failed messages go to DLQ for later processing.

Q192. How do you implement message retries?
Kafka:
- Retry topic
- Backoff intervals
Spring Retry:
@Retryable(maxAttempts=3)

Q193. How do you implement API composition?
API Gateway aggregates responses from multiple services.
Example:
User Service + Order Service → Combined response.

Q194. How do you implement distributed caching invalidation?
Use Redis pub/sub.
When one instance updates cache:
redis.publish("cache-clear","users");
Other instances clear local cache.

Q195. How do you implement request collapsing?
Use batching.
Example:
Instead of 100 calls → batch into 1 call.
Used in:
- GraphQL
- Hystrix (deprecated)
- Custom batching logic

Q196. How do you implement GraphQL in Spring Boot?
Use:
spring-boot-starter-graphql
Schema:
type Query { user(id: ID): User }
Controller:
@QueryMapping
public User user(Long id){ ... }

Q197. How do you implement file storage in AWS S3?
Use AWS SDK.
PutObjectRequest req = PutObjectRequest.builder().bucket("my-bucket").key("file").build();
s3.putObject(req, RequestBody.fromBytes(bytes));

Q198. How do you implement email templates?
Use Thymeleaf.
Context ctx = new Context();
ctx.setVariable("name","Manish");
String html = templateEngine.process("email-template", ctx);

Q199. How do you implement PDF generation?
Use iText or OpenPDF.
Document doc = new Document();
PdfWriter.getInstance(doc, new FileOutputStream("file.pdf"));
doc.add(new Paragraph("Hello"));

Q200. How do you implement Excel export?
Use Apache POI.
Workbook wb = new XSSFWorkbook();
Sheet sheet = wb.createSheet("Users");
Row row = sheet.createRow(0);
row.createCell(0).setCellValue("Name");
wb.write(new FileOutputStream("users.xlsx"));

	[Professional Comment: This is a complete arsenal for senior-level Spring Boot interviews. Use it for structured study, last-minute revision, and practical coding practice.]

	*/
	public static void main(String[] args) {
		
	}

}
