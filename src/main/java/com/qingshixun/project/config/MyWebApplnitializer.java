package com.qingshixun.project.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class MyWebApplnitializer implements WebApplicationInitializer{

	
//	  @Override
//	    public void onStartup(ServletContext servletContext) throws ServletException {
//	        WebApplicationContext context = getContext();
//	        servletContext.addListener(new ContextLoaderListener(context));
//	        FilterRegistration.Dynamic dispatcher = servletContext.addFilter("struts",StrutsPrepareAndExecuteFilter.class );
//	        dispatcher.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
//	  }
//
//	    private AnnotationConfigWebApplicationContext getContext() {
//	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
//	        context.setConfigLocation("com.qingshixun.project.config");
//	        return context;
//	    }
	    
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(PersistenceConfig.class);
		
		container.addListener(new ContextLoaderListener(rootContext));
		  
		container.addFilter("struts", StrutsPrepareAndExecuteFilter.class);
		FilterRegistration.Dynamic dispatcher = container.addFilter("*",StrutsPrepareAndExecuteFilter.class );
        dispatcher.addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST), true, "/*");
	}

}
