package mx.com.tot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by elver on 28/07/16.
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackageClasses = { SpringContextProvider.class, HibernateConfig.class })
public class WebInit {

    public WebInit() {
        System.out.println("WebInit()>>>>>>>>>>");
    }

    @Bean(name = "firstBean")
    public String getFirstBean() {
        return "firstBean";
    }
}
