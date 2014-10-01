package com.tl.myspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Created by Tom Tang on 25/09/14.
 */
@Configuration //Marks this class as configuration
//Specifies which package to scan
@ComponentScan("com.tl.myspring")
//Enables Spring's annotations
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter
{

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry)
//    {
//        super.addViewControllers(registry);
//        registry.addViewController("login/form").setViewName("login");
//        registry.addViewController("welcome").setViewName("welcome");
//        registry.addViewController("admin").setViewName("admin");
//    }

    @Bean
    public ViewResolver resolver()
    {
        InternalResourceViewResolver url = new InternalResourceViewResolver();
        url.setPrefix("/WEB-INF/views/");
        url.setSuffix(".jsp");
        return url;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/img/**").addResourceLocations("/img/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/").setCachePeriod(31556926);
    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer)
    {
        configurer.enable();
    }

//    @Bean
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver mr = new CommonsMultipartResolver();
//        mr.setMaxUploadSize(50000000);
//        return new CommonsMultipartResolver();
//    }
//    @Bean(name = "messageSource")
//    public MessageSource configureMessageSource()
//    {
//        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//        messageSource.setBasename("classpath:messages");
//        messageSource.setCacheSeconds(5);
//        messageSource.setDefaultEncoding("UTF-8");
//        return messageSource;
//    }

}