package kz.iitu.itse1910.nurlan.converter;

import kz.iitu.itse1910.nurlan.model.Customers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.FormattingConversionService;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Configuration
@Component
public class ConversionConfiguration {

    @Bean
    public FormattingConversionService conversionService1() {
        FormattingConversionServiceFactoryBean conversionServiceFactoryBean =
                new FormattingConversionServiceFactoryBean();

        conversionServiceFactoryBean.setConverters(
                Collections.singleton(new Customers()));
        return conversionServiceFactoryBean.getObject();
    }

    @Bean
    public ConversionServiceFactoryBean conversionServiceFactoryBean() {
        ConversionServiceFactoryBean bean = new ConversionServiceFactoryBean();
        Set<Converter> converters = new HashSet<>();
        Customers customers = new Customers(1, "Smith", "Johnson", "Abaya 34", "Alabama", "2522525");
        bean.setConverters(converters);
        return bean;
    }

    @Bean
    public ConversionService conversionService() {
        FormattingConversionServiceFactoryBean fb = new FormattingConversionServiceFactoryBean();
        fb.afterPropertiesSet();
        FormattingConversionService cs = fb.getObject();
        return cs;
    }

}
