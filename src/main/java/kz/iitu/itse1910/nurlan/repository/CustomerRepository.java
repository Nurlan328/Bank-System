package kz.iitu.itse1910.nurlan.repository;

import kz.iitu.itse1910.nurlan.model.Customers;

import java.util.List;


public interface CustomerRepository {
    List<Customers> getAllCustomers();

    Customers save(Customers customers);

    void updateCustomerById(Customers customers);

    List<Customers> findAll();

    Customers findById(int id);

    void deleteById(int id);
}
