package kz.iitu.itse1910.nurlan.oibekuly;
import kz.iitu.itse1910.nurlan.oibekuly.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableBatchProcessing
//@EnableScheduling
public class OibekulyApplication {
    private static  CustomerService customerService = new CustomerService();
    public static void main(String[] args) {
        SpringApplication.run(OibekulyApplication.class, args);
        System.out.println(customerService.calculateBill(2000));
        System.out.println(customerService.payBill(17000));
        System.out.println(customerService.viewBillInfo().toString());
        }
}
