package com.crazy.article.config;

import com.crazy.article.interceptor.TotalVisitsInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-22 9:28
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TotalVisitsInterceptor interceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor(interceptor).addPathPatterns("/**");
    }
}

