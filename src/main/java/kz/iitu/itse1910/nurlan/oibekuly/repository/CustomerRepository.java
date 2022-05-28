package kz.iitu.itse1910.nurlan.oibekuly.repository;

import kz.iitu.itse1910.nurlan.oibekuly.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CustomerRepository {
    List<Customers> getAllCustomers();

    //    Customers getById(int id);
    Customers save(Customers customers);
//    void delete(int customer_id);

    void updateCustomerById(Customers customers);

    List<Customers> findAll();

    Customers findById(int id);

    void deleteById(int id);

//    void updateCustomerById(int customer_id, String firstname, String lastname, String address, String city, String phoneno);
//    @Modifying
//    @Query("update  customers c set c.firstname=?1, c.lastname =?2, c.address=?3, c.city=?4, c.phoneno=?5 where c.customer_id=?6")
//    void updateCustomerById(int customer_id, String firstname, String lastname, String address, String city, String phoneno);

}
