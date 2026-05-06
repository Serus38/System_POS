package com.milcolores.system_pos.service.Customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.milcolores.system_pos.model.admin.Customer;

@Service
public interface CustomerService {

    List<Customer> getAllCustomers();

    Customer getCustomerById(Long id);

    Customer save(Customer customer);

    void delete(Long id);

    Customer update(Customer customer);
}
