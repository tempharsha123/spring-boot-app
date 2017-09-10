package org.sri.springexample;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.sri.springexample.config.SwaggerConfig;
import org.sri.springexample.config.WebConfig;

@SpringBootApplication
@Import({SwaggerConfig.class, WebConfig.class})
public class Application{
    public static void main(String[] args) {
        /*This property is for the prod profile*/
        //System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME,"prod");
        SpringApplication.run(Application.class,args);
    }
}
