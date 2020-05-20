package com.yitihua3.exam.config;


import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;


@Configuration
public class RestfulConfig{

    @Bean
    public FilterRegistrationBean restfulFilter() {                 //配置HiddenHttpMethodFilter，进行restful
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new HiddenHttpMethodFilter());
        bean.addUrlPatterns("/*");
        bean.setName("restfulFilter");
        return bean;
    }
}

