package mx.com.tot.config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * Created by elver on 28/07/16.
 */
@Component
public class SpringContextProvider implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public SpringContextProvider() {
        System.out.println("SpringContextProvider()>>>>>");
    }

    public void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }
}
