package com.crazy.article;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * @author shiyi
 * @version 1.0
 * @date 2020-3-19 12:02
 */

@SpringBootApplication
@Configuration
@EnableTransactionManagement
@EnableScheduling
@EnableAsync
@EnableCaching
@EnableDiscoveryClient
public class ArticleApplication {
    public static void main(String[] args) {
        SpringApplication.run(ArticleApplication.class, args);
    }


    /**
     * 使用fastjson把返回的数据转换成json格式，时间默认转换成了时间戳
     */
    /*@Bean
    public HttpMessageConverters fastJsonHttpMessageConverters() {
        // 需要先定义一个convert 转换消息的对象
        FastJsonHttpMessageConverter fastConvert = new FastJsonHttpMessageConverter();
        FastJsonConfig config = new FastJsonConfig();
        fastConvert.setFastJsonConfig(config);
        return new HttpMessageConverters(fastConvert);
    }*/

    /**
     * 日期转换
     *
     * @return
     */
    @Bean
    public Converter<String, Date> addDateConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                Date date = null;
                if (source != null && source.length() > 0) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        date = sdf.parse((String) source);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                return date;
            }
        };
    }

    /**
     * 日期转换
     *
     * @return
     */
    @Bean
    public Converter<String, LocalDateTime> addLocalDateTimeConvert() {
        return new Converter<String, LocalDateTime>() {
            @Override
            public LocalDateTime convert(String s) {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime dateTime = null;
                try {
                    dateTime = LocalDateTime.parse(s, formatter);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return dateTime;
            }
        };
    }
}
