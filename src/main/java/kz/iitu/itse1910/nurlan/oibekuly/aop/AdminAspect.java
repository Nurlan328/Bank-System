package kz.iitu.itse1910.nurlan.oibekuly.aop;

import kz.iitu.itse1910.nurlan.oibekuly.controller.CustomerController;
import kz.iitu.itse1910.nurlan.oibekuly.model.Customers;
import kz.iitu.itse1910.nurlan.oibekuly.model.FeedBack;
import kz.iitu.itse1910.nurlan.oibekuly.service.CustomerService;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class AdminAspect {

    private static Logger logger = Logger.getLogger(AdminAspect.class.getName());

    @Pointcut("within(kz.iitu.itse1910.nurlan.oibekuly.service.CustomerService)")
    public void serviceMethods(){}

    @Before("execution(public void viewFeedBack())")
    public String manageConnection() {
        return "Connection is successfully";
    }

    @Around("serviceMethods()")
    public void manageBills() {

    }

    @AfterReturning(pointcut = "execution(public String manageConnection())")
    public String registerCustomer() {
        CustomerService customerService = new CustomerService();
        Customers customers = new Customers();
        return String.valueOf(customerService.addCustomer(customers));
    }

    @After("execution(* manageConnection())")
    public void viewFeedBack() {
        FeedBack feedBack = new FeedBack();
        System.out.println("Feedback from: " + feedBack.getCustomerName());
        System.out.println("Feedback form: " + feedBack.getDescription());
        System.out.println("Customer email: " + feedBack.getEmail());
    }
}
