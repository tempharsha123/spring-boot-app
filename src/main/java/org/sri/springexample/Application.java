package org.sri.springexample;


import com.sun.deploy.net.HttpResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.sri.springexample.config.SwaggerConfig;
import org.sri.springexample.config.WebConfig;

@SpringBootApplication
@Import({SwaggerConfig.class, WebConfig.class})
public class Application{
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
