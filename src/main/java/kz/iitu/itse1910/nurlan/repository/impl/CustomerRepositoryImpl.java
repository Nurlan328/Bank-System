package kz.iitu.itse1910.nurlan.repository.impl;

import kz.iitu.itse1910.nurlan.model.Customers;
import kz.iitu.itse1910.nurlan.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class CustomerRepositoryImpl implements CustomerRepository {
    public JdbcTemplate jdbcTemplate;

    @Autowired
    public CustomerRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Customers> getAllCustomers() {
        String sql = "select * from customers";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    @Override
    public Customers findById(int customer_id) {

        String sql = "select * from customers  where customer_id=?";
        return jdbcTemplate.queryForObject(sql, new Object[]{customer_id}, new CustomerRowMapper());

    }


    @Override
    public Customers save(Customers customer) {
        jdbcTemplate.update(
                "insert into customers (  customer_id, firstname, lastname, address, city, phoneno) values ( ?,?, ?, ?, ?,?)",
                customer.getCustomer_id(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getAddress(),
                customer.getCity(),
                customer.getPhoneno()
        );
        return customer;
    }

    @Override
    public void updateCustomerById(Customers customers) {
        jdbcTemplate.update("update customers c set  c.lastname =?, c.address=?, c.city=?, c.phoneno=?, c.customer_id=? where c.firstname=?,");
    }

    @Override
    public List<Customers> findAll() {
        String sql = "select * from customers";
        return jdbcTemplate.query(sql, new CustomerRowMapper());
    }

    @Override
    public void deleteById(int customer_id) {
        jdbcTemplate.update("delete from customers where customer_id = ?", customer_id);
    }


}

class CustomerRowMapper implements RowMapper<Customers> {

    public Customers mapRow(ResultSet rs, int i) throws SQLException {
        Customers customer = new Customers();
        customer.setCustomer_id(rs.getInt("customer_id"));
        customer.setFirstname(rs.getString("firstname"));
        customer.setLastname(rs.getString("lastname"));
        customer.setAddress(rs.getString("address"));
        customer.setCity(rs.getString("city"));
        customer.setPhoneno(rs.getString("phoneno"));
        return customer;
    }

}
