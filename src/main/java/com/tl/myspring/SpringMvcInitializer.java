package com.tl.myspring;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Created by Tom Tang on 25/09/14.
 */
public class SpringMvcInitializer extends
        AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { SecurityConfig.class };
    }

    //    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
//
//    @Override
//    protected Filter[] getServletFilters() {
//        return new Filter[] { new SiteMeshFilter() };
//    }
}

