package com.wuzx.boot.crud.config;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Druid 连接池监控 {@link DruidConfig}
 *
 * @author wuzx
 * @email wuzhixiang.ithz@gmail.com
 */
@Configuration
public class DruidConfig {

    @Bean
    public ServletRegistrationBean druidServlet () {
        ServletRegistrationBean servletRegistrationBean
                = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
        servletRegistrationBean.addInitParameter("loginUsername", "admin");
        servletRegistrationBean.addInitParameter("loginPassword", "admin");
        servletRegistrationBean.addInitParameter("resetEnable", "false");

        return servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.css, /druid/*");

        return filterRegistrationBean;
    }
}
