package com.yitihua3.exam.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {
    //将所有前缀为spring.datasource下的配置项都加载到DataSource中
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }

    @Bean
    public ServletRegistrationBean statViewServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        Map<String,String> initParams = new HashMap<>();
//可配的属性都在StatViewServlet和其父类下
        initParams.put("loginUsername", "aiwoqe");//登录用户名
        initParams.put("loginPassword","aiwoqe");//登录密码
        initParams.put("allow","");//默认就是允许所有访问
//        initParams.put("deny","192.168.15.21");//拒绝访问
        bean.setInitParameters(initParams);
        return bean;
    }

    @Bean
    public FilterRegistrationBean webStatFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>();
//排除名单
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
//所有请求进行监控处理
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }

}
