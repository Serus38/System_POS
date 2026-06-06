package com.system.system_pos.service.Customer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.system.system_pos.exception.ResourceNotFound;
import com.system.system_pos.model.admin.Customer;
import com.system.system_pos.repository.CustomerRepository;

@Service
public class CustomerServiceImp implements CustomerService {

    CustomerRepository customerRepository;

    public CustomerServiceImp(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long id) {
        Customer customer = customerRepository.findById(id)
                .orElseThrow(() -> {
                    throw new ResourceNotFound("Customer not found with id: " + id);
                });
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public void delete(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(Customer customer) {
        return customerRepository.save(customer);
    }
}
