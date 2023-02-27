package kz.iitu.itse1910.nurlan.aop;

import kz.iitu.itse1910.nurlan.model.Account;
import kz.iitu.itse1910.nurlan.model.Bill;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class BillAspect {

    private static Logger logger = Logger.getLogger(BillAspect.class.getName());

    @AfterThrowing("execution(* payBill())")
    public void viewBillInfo() {
        Bill bill = new Bill();
        logger.info("Bill info: " + bill.toString() + '\n');
    }


    public String payBill(double amount) {
        Account account = new Account();
        double balance = account.getBalance();

        if (balance >= amount) {
            balance -= amount;
            return "You have paid " + amount + " for this month.";
        } else {
            throw new UnsupportedOperationException("Insufficient balance");
        }
    }

}











