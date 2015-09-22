package za.ac.cput.QuoteSystem.services.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.QuoteSystem.domain.Customer;
import za.ac.cput.QuoteSystem.repository.CustomerRepository;
import za.ac.cput.QuoteSystem.services.CustomerService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/18.
 */
@Service
public class CustomerImpl implements CustomerService {
    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Customer save(Customer entity) {
        return repository.save(entity);
    }

    @Override
    public Customer update(Customer entity) {
        return repository.save(entity);

    }

    @Override
    public void delete(Customer entity) {
        repository.delete(entity);
    }

    @Override
    public List<Customer> findAll() {
        List<Customer> customers= new ArrayList<Customer>();
        Iterable<Customer> values = repository.findAll();

        for(Customer value: values ){
            customers.add(value);
        }
        return customers;
    }
}
