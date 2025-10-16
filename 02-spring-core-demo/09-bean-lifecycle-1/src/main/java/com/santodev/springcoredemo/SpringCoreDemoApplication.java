/*
Bean lifecycle:

1. Configuration:
    Spring reads configuration metadata to know what & how to create beans. This metadata comes from
    * @Configuration + @Bean methods
    * @ComponentScan
    * application.properties

    * Spring reads AppConfig.class OR @SpringBootApplication to find component scan packages
    * Classpath scanning - Spring scans packages, sub-packages recursively & finds classes with annotation
        @Component, @Service, @Repository, @Controller etc.

    * Bean definition creation - for each found class, Spring creates bean definition (metadata - class name, scope, dependencies etc.

2. Instantiation:
    Spring creates actual objects for each bean using reflection OR constructor injection
    If bean requires any other bean as dependency then, Spring figures out which bean instance should be created first - Dependency Resolution

3. Initialization:
    After bean is instantiated - Initial Setup takes place
    -Dependency Injection through @Autowired, @Value
    -@PostConstruct - Calling custom init method

4. Registration:
    Spring registers beans inside container
    Assigns unique bean id/name & keeps it in internal bean registry map
    Map<String, Object> singletonObjects

5. Ready to use:
    Now, all beans are full configured & registered inside container
    available to use via Dependency injection OR context.getBean(class-name)

6. Destruction:
    Calling @PreDestroy methods to cleanup before complete shutdown
    bean destoyed

* */

package com.santodev.springcoredemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCoreDemoApplication {

	public static void main(String[] args) {
        System.out.println("____________________________________");
        System.out.println("Starting Spring Boot Application...");
		SpringApplication.run(SpringCoreDemoApplication.class, args);
        System.out.println("Application is running...");
	}

}
