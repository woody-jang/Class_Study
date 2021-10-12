package kr.co.greenart.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan("kr.co.greenart")
public class WebConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/views/", ".jsp");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
			.addResourceLocations("classpath:resources/");
	}
	
//	@Bean
//	public ViewResolver viewResolver() {
//		InternalResourceViewResolver vr = new InternalResourceViewResolver();
//		vr.setViewClass(JstlView.class);
//		vr.setPrefix("/WEB-INF/views");
//		vr.setSuffix(".jsp");
//		return vr;
//	}
}
