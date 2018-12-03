package com.chwx.springbootspringsecurity;

import com.chwx.springbootspringsecurity.common.VerifyServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringbootSpringsecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootSpringsecurityApplication.class, args);
    }

    /**
     * 注入验证码servlet
     */
    @Bean
    public ServletRegistrationBean indexServletRegistration(){
        ServletRegistrationBean registrationBean = new ServletRegistrationBean(new VerifyServlet());
        registrationBean.addUrlMappings("/getVerifyCode");
        return registrationBean;
    }
}
