package kz.iitu.itse1910.nurlan.jms;

import kz.iitu.itse1910.nurlan.model.Account;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableJms
public class Sender {

    @JmsListener(destination = "accountSender")
    @SendTo("accountReceiver")
    public Account sendAccountInfo(Account account) {
        account.setAccount_id(1);
        account.setAccountNumber(664385393928L);
        account.setBalance(4300000);
        return account;
    }

    @JmsListener(destination = "Sender")
    @SendTo("withDrawReceiver")
    public void sendWithDrawNotification(double amount) {
        CustomerReceiver customerReceiver = new CustomerReceiver();
        amount = 20000d;
        customerReceiver.notifyWithdrawing(amount);
    }
}
