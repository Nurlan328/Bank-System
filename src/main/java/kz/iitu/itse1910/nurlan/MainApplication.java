package kz.iitu.itse1910.nurlan;

import kz.iitu.itse1910.nurlan.service.CustomerService;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableBatchProcessing
@EnableScheduling
public class MainApplication {
    private static CustomerService customerService = new CustomerService();

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
        System.out.println(customerService.calculateBill(2000));
        System.out.println(customerService.payBill(17000));
        System.out.println(customerService.viewBillInfo().toString());
    }
}
