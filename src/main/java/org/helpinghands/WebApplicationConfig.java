package org.helpinghands;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebApplicationConfig extends WebMvcConfigurerAdapter {
	
	@Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/resources");
		registry.addResourceHandler("/css/**").addResourceLocations("/css/");
  	    registry.addResourceHandler("/img/**").addResourceLocations("/img/");
  	    registry.addResourceHandler("/js/**").addResourceLocations("/js/");
  	}
}
