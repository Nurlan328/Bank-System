package kz.iitu.itse1910.nurlan.oibekuly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebConfig implements  WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/",
            "classpath:/resources/**",
            "classpath:/static/",
            "classpath:/static/images",
            "classpath:/public/",
            "classpath:webapp/WEB-INF/**"
    };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")
                .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS);
    }

//    @Bean
//    InternalResourceViewResolver viewResolver() {
//        InternalResourceViewResolver resolver =  new InternalResourceViewResolver();
//        resolver.setPrefix("/WEB-INF"); resolver.setSuffix(".jsp" );
//        resolver.setRequestContextAttribute("requestContext");
//        return resolver;
//    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/about").setViewName("_aboutUs");
        //registry.addViewController("/admin/labels").setViewName("getPlayers");
    }

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }
//
//    @Bean(name = "viewResolver")
//    public ViewResolver getViewResolver() {
//        UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
//
//        // TilesView 3
//        viewResolver.setViewClass(TilesView.class);
//
//        return viewResolver;
//    }


}

