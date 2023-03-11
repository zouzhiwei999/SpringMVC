package com.atguigu.mvc.config;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;

/**
 * @author AOA
 * @version 1.0
 * @description: TODO
 * @date 2022/5/23 2:50
 */

public class WebInit extends AbstractAnnotationConfigDispatcherServletInitializer {
    /*
     *  配置spring
     *
     * @author zzw
     * @date 2022/5/23 2:50
     * @param []
     * @return java.lang.Class<?>[]
     */
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{SpringConfig.class};
    }

    /*
     *  配置spingMVC
     *
     * @author zzw
     * @date 2022/5/23 2:50
     * @param []
     * @return java.lang.Class<?>[]
     */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{WebConfig.class};
    }

    /*
     *  配置DispatcherServlet映射规则
     *
     * @author zzw
     * @date 2022/5/23 2:51
     * @param []
     * @return java.lang.String[]
     */
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /*
     *  配置过滤器
     *
     * @author zzw
     * @date 2022/5/23 2:51
     * @param []
     * @return javax.servlet.Filter[]
     */
    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceResponseEncoding(true);

        HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();

        return new Filter[]{characterEncodingFilter, hiddenHttpMethodFilter};
    }
}
