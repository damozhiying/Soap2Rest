package cl.ido.rest.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration 
@ComponentScan("cl.ido.rest") 
@EnableWebMvc
public class AppConfig {

}
