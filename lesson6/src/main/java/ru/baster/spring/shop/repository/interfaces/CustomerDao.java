package ru.baster.spring.shop.repository.interfaces;

import org.springframework.stereotype.Component;
import ru.baster.spring.shop.models.Customer;


import java.util.List;

@Component
public interface CustomerDao {

    Customer findById (Long id);
    List<Customer> findAll();
    void deleteById(Long id);
    Customer saveOrUpdate(Customer customer);

}
