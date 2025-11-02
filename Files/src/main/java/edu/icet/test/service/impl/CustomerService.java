package edu.icet.test.service.impl;

import edu.icet.test.model.dto.Customer;
import edu.icet.test.model.entity.CustomerEntity;
import edu.icet.test.repository.CustomerRepository;
import edu.icet.test.util.exception.CustomDbException;
import jakarta.persistence.PersistenceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository repository;

    public List<Customer> getAllCustomers() {
        try {
            List<Customer> customerList = new ArrayList<>();
            List<CustomerEntity> entities = repository.findAll();

            if (!entities.isEmpty()) {
                for (CustomerEntity entity : entities) {
                    customerList.add(
                            Customer.builder()
                                    .id(entity.getId())
                                    .email(entity.getEmail())
                                    .phone(entity.getPhone())
                                    .name(entity.getName())
                                    .build()
                    );
                }
                return customerList;
            }
            else {
                throw new CustomDbException("No data in customer table");
            }
        }catch(DataAccessException e){
            throw new PersistenceException("A database access error occurred:", e);
        }
    }

    public String addNewCustomer(Customer customer) {
        try {
            Optional<CustomerEntity> foundEntity = repository.findById(customer.getId());
            if (foundEntity.isPresent()) {
                return "Item code: " + customer.getId() + ", Already exist!";
            } else {
                repository.save(
                        new CustomerEntity(
                            customer.getId(), customer.getName(), customer.getPhone(), customer.getEmail()
                        )
                );
                return "New Customer saved successfully!";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }
    }

    public String updateCustomer(Customer customer) {
        try {
            Optional<CustomerEntity> foundEntity = repository.findById(customer.getId());
            if (foundEntity.isPresent()) {

                foundEntity.get().setName(customer.getName());
                foundEntity.get().setPhone(customer.getPhone());
                foundEntity.get().setEmail(customer.getEmail());

                repository.save(foundEntity.get());

                return "Customer id: " + customer.getId() + ", details updated.";
            } else {
                return "Customer: " + customer.getId() + ", Not found.";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }
    }

    public String deleteCustomer(String id) {
        try {
            Optional<CustomerEntity> foundEntity = repository.findById(id);

            if (foundEntity.isPresent()) {
                repository.delete(foundEntity.get());
                return " Customer id: " + id + ", Deleted successfully.";
            } else {
                return "Customer id: " + id + ", Not found.";
            }
        } catch (DataAccessException e) {
            throw new PersistenceException("A database access error occurred:", e);
        }

    }
}
