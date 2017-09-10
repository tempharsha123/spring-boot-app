package org.sri.springexample.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.swagger2.mappers.LicenseMapper;

public class SwaggerConfig {

    @Bean
    public Docket api(){
       return new Docket(DocumentationType.SWAGGER_2)
                         .useDefaultResponseMessages(false)
                         .select()
                         .apis(RequestHandlerSelectors.any())
                         .paths(PathSelectors.any())
                         .build()
                         .apiInfo(getApiInfo());
    }

    private ApiInfo getApiInfo(){
        Contact contact = new Contact("admin","https://deeini.com","sriharshadatla111@gmail.com");
        ApiInfo apiInfo = new ApiInfo("Spring-REST API","A simple REST API","1.0.0","Tnc",
                                    contact,"MIT","http://opensource.org/licenses/MIT");
        return apiInfo;
    }
}
