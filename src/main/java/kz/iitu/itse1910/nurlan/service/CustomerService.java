package kz.iitu.itse1910.nurlan.service;

import kz.iitu.itse1910.nurlan.model.Account;
import kz.iitu.itse1910.nurlan.model.Bill;
import kz.iitu.itse1910.nurlan.model.Customers;
import kz.iitu.itse1910.nurlan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.AssertTrue;
import java.util.List;

@Service
public class CustomerService {

    private CustomerRepository customerRepository;

    @Autowired
    public void setCustomerRepository(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customers> getallCustomers() {
        return customerRepository.findAll();
    }

    public Customers findById(int id) {
        return customerRepository.findById(id);
    }

    public void updateCustomerById(Customers customers) {
        customerRepository.updateCustomerById(
                customers
        );
    }

    public Customers addCustomer(Customers customers) {
        return customerRepository.save(customers);
    }

    public void deleteCustomer(int id) {
        customerRepository.deleteById(id);
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

    public String viewBillInfo() {
        Bill bill = new Bill();
        StringBuilder billInfo = new StringBuilder();
        billInfo.append(bill.getBill_id());
        billInfo.append(bill.getBill_customer_id());
        billInfo.append(bill.getBill_number());
        billInfo.append(bill.getAmount());
        billInfo.append(bill.getAccount());
        billInfo.append(bill.getDescription());
        return billInfo.toString();
    }

    public double calculateBill(int unit) {
        double bill_Amount = 0;
        //initialy we can understand prize of unit
        //may be changed by day to day
        /*1 - 100 unit - 5/=
        101-200 unit -  7/=
        201-300 unit - 10/=
        above 300  - 15/=*/
        if (unit <= 100) {
            bill_Amount = unit * 5;
            return bill_Amount;
        } else if (unit <= 200) {
            bill_Amount = (100 * 5) + (unit - 100) * 7;
            return bill_Amount;
        } else if (unit <= 300) {
            bill_Amount = (100 * 5) + (100 * 7) + (unit - 200) * 10;
            return bill_Amount;
        } else if (unit > 300) {
            bill_Amount = (100 * 5) + (100 * 7) + (100 * 10) + (unit - 300) * 15;
            return bill_Amount;
        } else {
            bill_Amount = 0;
            return bill_Amount;
        }
    }

    @AssertTrue(message = "ERROR! Individual customer should have firstname and last name defined")
    public boolean isCustomerRegistered() {
        Customers customers = new Customers();
        String lastname = customers.getLastname();
        String firstname = customers.getFirstname();
        boolean result = true;
        if (lastname == null || firstname == null) {
            result = false;
        }
        return result;
    }

}
