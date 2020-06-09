package com.yitihua3.exam.config;

import com.alibaba.druid.filter.Filter;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import com.alibaba.druid.wall.WallConfig;
import com.alibaba.druid.wall.WallFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.*;

@Configuration
public class DruidConfig {
    //将所有前缀为spring.datasource下的配置项都加载到DataSource中
    /**
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return new DruidDataSource();
    }*/

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

    @Bean
    @ConfigurationProperties(prefix="spring.datasource")
    public DataSource druidPrimary(){
        DruidDataSource druidDataSource = new  DruidDataSource();
        List<Filter> filterList = new ArrayList<>();
        List<Filter> filters = druidDataSource.getProxyFilters();
        boolean isExit = false;
        for (Filter filter:filters){
            if (filter instanceof WallFilter){
                ( (WallFilter) filter) . setConfig (wallConfig());
                isExit = true;
                if( !isExit){
                    filterList = new ArrayList<>();
                    filterList.add(wallFilter());
                    druidDataSource. setProxyFilters(filterList);
                }
            }
        }
        return new DruidDataSource();
    }

    @Bean
    public WallFilter wallFilter(){
        WallFilter wallFilter = new WallFilter();
        wallFilter.setConfig(wallConfig());
        return wallFilter;
    }

    @Bean
    public WallConfig wallConfig() {
        WallConfig config = new WallConfig();
        //允许一次执行多条语句
        config.setMultiStatementAllow(true);
        //允许一次执行多条语句
        config.setNoneBaseStatementAllow(true);
        return config;
    }
}
