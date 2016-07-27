package com.softserverinc.edu.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

/**
 * Created by ihorlt on 18.07.16.
 * Configuration class dispatcher-servlet
 */

@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.softserverinc.edu"})
public class WebConfig extends WebMvcConfigurerAdapter {

    public  static final Logger LOGGER = LoggerFactory.getLogger(WebConfig.class);


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        super.addViewControllers(registry);

        // TODO: 18.07.16 rest views mapping
        //default URI /  ->  index.jsp
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("index");
    }

    /**
     * Make resources aviable to web client. Spring handle the folders starting from WEB-INF
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/css/**").addResourceLocations("/resources/css/");
        registry.addResourceHandler("/js/**").addResourceLocations("/resources/js/");
        registry.addResourceHandler("/fonts/**").addResourceLocations("/resources/fonts/");
        registry.addResourceHandler("/images/**").addResourceLocations("/resources/images/");
    }

    /**
     * Let to rosolve of views to Tiles templating framework
     * @return
     */
    @Bean
    public UrlBasedViewResolver viewResolver() {
        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
        viewResolver.setViewClass(TilesView.class);
        return viewResolver;
    }

    /**
     * Tells to the Tiles context a configuration file
     * @return
     */
    @Bean
    public TilesConfigurer tilesConfigurer(){
        TilesConfigurer tilesConfigurer = new TilesConfigurer();
        tilesConfigurer.setDefinitions(new String[]{"/WEB-INF/layouts/tiles-definitions.xml"});
        tilesConfigurer.setCheckRefresh(true);
        return tilesConfigurer;
    }

}