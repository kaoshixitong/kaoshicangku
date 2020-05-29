package com.yitihua3.exam.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author aiwoqe
 */
@EnableSwagger2
@EnableKnife4j
@Configuration
public class SwaggerConfig {

    /**
     * 否开启swagger，正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
     */

    @Value(value = "${swagger.enabled}")
    Boolean swaggerEnabled;

    private static final String BASE_PACKAGE="com.yitihua3.exam.controller.";


    @Autowired
    private ApplicationContext applicationContext;


    @Getter
    @AllArgsConstructor
    private enum GroupName{
        /**
         * subject组API
         */
        SUBJECT("subject"),
        /**
         * answer组API
         */
        ANSWER("answer"),
        /**
         * user组API
         */
        USER("user"),
        /**
         * exam组API
         */
        EXAM("exam");

        private String groupName;
    }

    @Bean
    public String addBean() {
        for (GroupName groupName : GroupName.values()) {
            DefaultListableBeanFactory defaultListableBeanFactory = (DefaultListableBeanFactory) applicationContext.getAutowireCapableBeanFactory();
            //创建beanDefinition
//            BeanDefinition beanDefinition=new GenericBeanDefinition();
//            beanDefinition.setBeanClassName(Docket.class.getName());

            defaultListableBeanFactory.registerSingleton(groupName.getGroupName()+"RestApi",
                    new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
                            .enable(swaggerEnabled)
                            .groupName(groupName.getGroupName()).apiInfo(apiInfo())
                            .select()
                            .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE+groupName.getGroupName()))
                            .paths(PathSelectors.any())
                            .build());
        }
        return "";
    }

    private static final String CONTACT_NAME="aiwoqe";

    private static final String CONTACT_URL="aiwoqe.xyz";

    private static final String CONTACT_EMAIL="1936563461@qq.com";
    /**
     * 该套 API 说明，包含作者、简介、版本、host、服务URL
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("考试系统")
                .description("一体化3实践")
                // 作者信息
                .contact(new Contact(CONTACT_NAME,CONTACT_URL , CONTACT_EMAIL))
                .version("1.0.0")
                .build();
    }
}
