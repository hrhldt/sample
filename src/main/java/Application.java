import model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import service.UserService;

/*
@Configuration
@ComponentScan
@EnableAutoConfiguration
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}


*/
@Configuration
@EnableAutoConfiguration
@ComponentScan
@EntityScan
public class Application extends SpringBootServletInitializer {

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);

//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("persistence.xml");
//        User user = new User();
//        user.setId("123");
//        user.setName("John");
//        user.setAge(35);
//        UserService userService = (UserService) context.getBean("userService");
//        userService.persistUser(user);
//        System.out.println("Updated age :" + userService.findUserById("123").getAge());
//        user.setAge(32);
//        userService.updateUser(user);
//        System.out.println("Updated age :" + userService.findUserById("123").getAge());
//        userService.updateUser(user);
//        context.close();
    }

    @Override
    protected final SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

//    @RestController
//    class GreetingController {
//
//        @RequestMapping("/hello/{name}")
//        String hello(@PathVariable String name) {
//            return "Hello, " + name + "!";
//        }
//    }
}