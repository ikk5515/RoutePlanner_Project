package RoutePlanner.core.controller.dao;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig{
    @Bean
    public ServletRegistrationBean<routeSevlet> getServletRegistrationBean() {

        ServletRegistrationBean<routeSevlet> registrationBean = new ServletRegistrationBean<>(new routeSevlet());
        registrationBean.addUrlMappings("/routeSevlet");
        registrationBean.addInitParameter("isAbsolutePath", "true");
        registrationBean.addInitParameter("propertyPath", "src/main/resources/public/rd/");

        return registrationBean;
    }
}
