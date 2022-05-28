package kz.iitu.itse1910.nurlan.oibekuly.config;

import kz.iitu.itse1910.nurlan.oibekuly.model.Customers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@PropertySource(value = "application.properties", ignoreResourceNotFound = true)
@Scope("prototype")
public class CustomerConfig {

    @Lazy
    @Bean
    public Customers customerBean() {
        Customers customers = new Customers();
        customers.setCustomer_id(1);
        customers.setFirstname("Linus");
        customers.setLastname("Torvalds");
        customers.setAddress("District Quens 14");
        customers.setCity("New York");
        customers.setPhoneno("1469806985");
        return customers;
    }



}