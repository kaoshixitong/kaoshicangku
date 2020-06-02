package com.yitihua3.exam.shiro;


import com.yitihua3.exam.config.OriginFilter;
import com.yitihua3.exam.config.RedisManager;
import com.yitihua3.exam.service.user.JWTService;
import com.yitihua3.exam.shiro.realm.DBRealm;
import com.yitihua3.exam.shiro.realm.JWTRealm;
import com.yitihua3.exam.shiro.restful.EnhanceModularRealmAuthenticator;
import com.yitihua3.exam.shiro.restful.JWTCredentialsMatcher;
import com.yitihua3.exam.shiro.restful.JWTFilter;
import com.yitihua3.exam.shiro.restful.RestfulDefaultSubjectFactory;
import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.Authenticator;
import org.apache.shiro.authc.pam.FirstSuccessfulStrategy;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.mgt.DefaultSessionStorageEvaluator;
import org.apache.shiro.mgt.DefaultSubjectDAO;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.DefaultSessionManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.MethodInvokingFactoryBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

@ConfigurationProperties(prefix = "filter")
@Configuration
@Getter
@Setter
public class ShiroConfig {
     private LinkedHashMap<String, String> filterChainDefinitionMap;

     public LinkedHashMap<String, String> newMap=new LinkedHashMap<String, String>();

    @Bean
    public FilterRegistrationBean<Filter> filterRegistrationBean(SecurityManager securityManager, JWTService jwtService) throws Exception{
        FilterRegistrationBean<Filter> filterRegistration = new FilterRegistrationBean<>();
        filterRegistration.setFilter((Filter) Objects.requireNonNull(shiroFilter(securityManager, jwtService).getObject()));
        filterRegistration.addInitParameter("targetFilterLifecycle", "true");
        filterRegistration.setEnabled(true);

        return filterRegistration;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") SecurityManager securityManager,JWTService jwtService){
        ShiroFilterFactoryBean shiro = new ShiroFilterFactoryBean();
        shiro.setSecurityManager(securityManager);
        // 没有登陆的用户只能访问登陆页面
//        shiro.setLoginUrl("/login");
        Map<String, Filter> filters = shiro.getFilters();
        filters.put("jwt", jwtFilter(jwtService));
        filters.put("origin",anonymousFilter());
        for(String key:filterChainDefinitionMap.keySet()) {
            String value = filterChainDefinitionMap.get(key);
            //去除url外的[]
            newMap.put(key.substring(1, key.length() - 1), value);
        }
        LinkedHashMap<String, String> filterChainDefinitionMap = newMap;
        shiro.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiro;
    }


    protected OriginFilter anonymousFilter(){
        return new OriginFilter();
    }

    protected JWTFilter jwtFilter(JWTService jwtService){
        return new JWTFilter(jwtService);
    }

    /*
     * 禁用使用Sessions 作为存储策略的实现，但它没有完全地禁用Sessions
     * 所以需要配合context.setSessionCreationEnabled(false);
     */
    @Bean
    public DefaultWebSecurityManager securityManager(JWTService jwtService){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //配置自定义cache管理，使用ehcache
        securityManager.setCacheManager(ehcacheManager());

        securityManager.setSubjectFactory(subjectFactory());

        securityManager.setSessionManager(sessionManager());

        securityManager.setAuthenticator(authenticator());

        securityManager.setRealms(Arrays.asList(jwtRealm(jwtService), dbRealm()));

        DefaultSubjectDAO subjectDAO = new DefaultSubjectDAO();
        DefaultSessionStorageEvaluator defaultSessionStorageEvaluator = new DefaultSessionStorageEvaluator();
        defaultSessionStorageEvaluator.setSessionStorageEnabled(false);
        subjectDAO.setSessionStorageEvaluator(defaultSessionStorageEvaluator);
        securityManager.setSubjectDAO(subjectDAO);

        return securityManager;
    }

    /**
     * subject工厂管理器.
     * @return
     */
    @Bean

    public DefaultWebSubjectFactory subjectFactory(){
        RestfulDefaultSubjectFactory subjectFactory = new RestfulDefaultSubjectFactory();
        return subjectFactory;
    }

    /**
     * session管理器：
     * sessionManager通过sessionValidationSchedulerEnabled禁用掉会话调度器，
     * 因为我们禁用掉了会话，所以没必要再定期过期会话了。
     * @return
     */
    @Bean

    public DefaultSessionManager sessionManager(){
        DefaultSessionManager sessionManager = new DefaultSessionManager();
        sessionManager.setSessionValidationSchedulerEnabled(false);
        return sessionManager;
    }
    @Bean
    public Authenticator authenticator() {
        ModularRealmAuthenticator authenticator = new EnhanceModularRealmAuthenticator();
        authenticator.setAuthenticationStrategy(new FirstSuccessfulStrategy());
        return authenticator;
    }

    @Bean("dbRealm")
    public DBRealm dbRealm() {
        DBRealm dbRealm = new DBRealm();
        dbRealm.setCachingEnabled(true);
//启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        dbRealm.setAuthenticationCachingEnabled(true);
//缓存AuthenticationInfo信息的缓存名称 在ehcache.xml中有对应缓存的配置
        dbRealm.setAuthenticationCacheName("authenticationCache");

        dbRealm.setCacheManager(ehcacheManager());
//启用授权缓存，即缓存AuthorizationInfo信息，默认false
        dbRealm.setAuthorizationCachingEnabled(true);

        dbRealm.setAuthorizationCacheName("authorizationCache");
        return dbRealm;
    }

    
    @Bean("jwtRealm")
    public JWTRealm jwtRealm(JWTService jwtService){
        JWTRealm jwtRealm = new JWTRealm(jwtService);
        jwtRealm.setCachingEnabled(true);
//启用身份验证缓存，即缓存AuthenticationInfo信息，默认false
        jwtRealm.setAuthenticationCachingEnabled(true);
//缓存AuthenticationInfo信息的缓存名称 在ehcache.xml中有对应缓存的配置
        jwtRealm.setAuthenticationCacheName("authenticationCache");

        jwtRealm.setCacheManager(ehcacheManager());
//启用授权缓存，即缓存AuthorizationInfo信息，默认false
        jwtRealm.setAuthorizationCachingEnabled(true);

        jwtRealm.setCredentialsMatcher(credentialsMatcher());
        jwtRealm.setAuthorizationCacheName("authorizationCache");
//缓存AuthorizationInfo信息的缓存名称 在ehcache.xml中有对应缓存的配置
//        jwtRealm.setCredentialsMatcher(retryLimitHashedCredentialsMatcher());//配置自定义密码比较器
        return jwtRealm;
    }

    @Bean
    public JWTCredentialsMatcher credentialsMatcher(){
        return new JWTCredentialsMatcher();
    }

    @Bean
    public EhCacheManager ehcacheManager(){
        EhCacheManager cacheManager = new EhCacheManager();
        cacheManager.setCacheManagerConfigFile("classpath:resources/ehcache-shiro.xml");
        return cacheManager;
    }



    @Bean
    public RedisManager redisManager(){
        RedisManager redisManager = new RedisManager();
        return redisManager;
    }



    /**
     * 配置保存sessionId的cookie
     * 注意：这里的cookie 不是上面的记住我 cookie 记住我需要一个cookie session管理 也需要自己的cookie
     * 默认为: JSESSIONID 问题: 与SERVLET容器名冲突,重新定义为sid
     * @return
     */
    @Bean("sessionIdCookie")
    public SimpleCookie sessionIdCookie(){

        SimpleCookie simpleCookie = new SimpleCookie("sid");//这个参数是cookie的名称
        //setcookie的httponly属性如果设为true的话，会增加对xss防护的安全系数。它有以下特点：

        //setcookie()的第七个参数
        //设为true后，只能通过http访问，javascript无法访问
        //防止xss读取cookie
        simpleCookie.setHttpOnly(true);
        simpleCookie.setPath("/");

        simpleCookie.setMaxAge(-1);//maxAge=-1表示浏览器关闭时失效此Cookie
        return simpleCookie;
    }

    /**
     * 让某个实例的某个方法的返回值注入为Bean的实例
     * Spring静态注入
     * @return
     */
    @Bean
    public MethodInvokingFactoryBean getMethodInvokingFactoryBean(@Qualifier("securityManager") SecurityManager securityManager){
        MethodInvokingFactoryBean factoryBean = new MethodInvokingFactoryBean();
        factoryBean.setStaticMethod("org.apache.shiro.SecurityUtils.setSecurityManager");
        factoryBean.setArguments(new Object[]{securityManager});
        return factoryBean;
    }

    /**
     *  开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证
     * 配置以下两个bean(DefaultAdvisorAutoProxyCreator和AuthorizationAttributeSourceAdvisor)即可实现此功能
     * @return
     */
    @Bean
    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
        advisorAutoProxyCreator.setProxyTargetClass(true);
        return advisorAutoProxyCreator;
    }

    /**
     * 开启shiro 注解模式
     * 可以在controller中的方法前加上注解
     * 如 @RequiresPermissions("userInfo:add")
     * @param securityManager
     * @return
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager") SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }


}
