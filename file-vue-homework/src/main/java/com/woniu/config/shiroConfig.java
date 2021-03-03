package com.woniu.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.woniu.realm.CustomeRealm;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;

@Configuration
public class shiroConfig {

    @Bean
    public Realm realm(){
        CustomeRealm customeRealm = new CustomeRealm();
        //设置凭证
        HashedCredentialsMatcher matcher=new HashedCredentialsMatcher();
        matcher.setHashAlgorithmName("md5");
        matcher.setHashIterations(1024);
        customeRealm.setCredentialsMatcher(matcher);
        //设置缓存
        customeRealm.setCachingEnabled(true);
        customeRealm.setAuthenticationCachingEnabled(true);
        customeRealm.setAuthorizationCachingEnabled(true);
        customeRealm.setCacheManager(new EhCacheManager());
        return customeRealm;
    }

    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm());
        return manager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager());

        LinkedHashMap<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/user/login","anon");
        filterChainDefinitionMap.put("/user/register","anon");
        filterChainDefinitionMap.put("/user/checkName","anon");
//        filterChainDefinitionMap.put("/user/logout","logout");
        filterChainDefinitionMap.put("/film/page","anon");
        filterChainDefinitionMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }


}
