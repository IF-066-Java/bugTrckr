package com.softserverinc.edu.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 * Created by ihorlt on 18.07.16.
 */
public class WebAppInitializer implements WebApplicationInitializer {

    public  static final Logger LOGGER = LoggerFactory.getLogger(WebAppInitializer.class);

    @Override
    public void onStartup(ServletContext container) throws ServletException {

        LOGGER.debug("WebAppInitializer.onStartup is called");

        //Registering WebConfig class for further servlet configuration
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(WebConfig.class);

        //manage the lifecycle of rootcontext
        container.addListener(new ContextLoaderListener(rootContext));

        //Define and register a dispatcher servlet that can manage all servlets
        DispatcherServlet dispatcherServlet = new DispatcherServlet(rootContext);
        ServletRegistration.Dynamic registration = container.addServlet("dispatcherServlet", dispatcherServlet);
        //load the servlet only once
        registration.setLoadOnStartup(1);
        //add mapping this servlet to all requests
        registration.addMapping("/");
    }
}