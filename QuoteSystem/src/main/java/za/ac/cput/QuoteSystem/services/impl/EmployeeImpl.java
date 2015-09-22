package za.ac.cput.QuoteSystem.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.QuoteSystem.domain.Employee;
import za.ac.cput.QuoteSystem.repository.EmployeeRepository;
import za.ac.cput.QuoteSystem.services.EmployeeService;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by student on 2015/09/18.
 */
@Service
public class EmployeeImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    @Override
    public Employee findById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Employee save(Employee entity) {
        return repository.save(entity);
    }

    @Override
    public Employee update(Employee entity) {
        return repository.save(entity);

    }

    @Override
    public void delete(Employee entity) {
        repository.delete(entity);
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> employees= new ArrayList<Employee>();
        Iterable<Employee> values = repository.findAll();

        for(Employee value: values ){
            employees.add(value);
        }
        return employees;
    }
}
