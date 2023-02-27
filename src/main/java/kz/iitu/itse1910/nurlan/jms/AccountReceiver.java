package kz.iitu.itse1910.nurlan.jms;

import kz.iitu.itse1910.nurlan.model.Account;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class AccountReceiver {

    @JmsListener(destination = "accountReceiver")
    public void receiveAccountInfo(Account account) {
        System.out.println("Received information about account: ");
        System.out.println("Account id: " + account.getAccount_id());
        System.out.println("Account number: " + account.getAccountNumber());
        System.out.println("Balance in account: " + account.getBalance());
    }

}
