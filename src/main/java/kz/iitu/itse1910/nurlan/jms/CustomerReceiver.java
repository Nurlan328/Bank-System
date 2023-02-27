package kz.iitu.itse1910.nurlan.jms;

import kz.iitu.itse1910.nurlan.model.Customers;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class CustomerReceiver {

    public static boolean isWithdraw = true;
    public static boolean isBlocked = false;
    public static boolean security_block = false;

    @JmsListener(destination = "withDrawReceiver")
    public void notifyWithdrawing(double amount) {
        if (isWithdraw) {
            System.out.println("Notifying that there is been a withdraw of " + amount + " tenge");
            System.out.println("If it was not you. Block your card!");
        }
        if (security_block) {
            isBlocked = true;
        }
    }

    @JmsListener(destination = "customerReceiver")
    public void receiveCustomerInfo(Customers customer) {
        System.out.println("Received information about customer: ");
        System.out.println("Customer id: " + customer.getCustomer_id());
        System.out.println(customer.getFirstname());
    }
}
