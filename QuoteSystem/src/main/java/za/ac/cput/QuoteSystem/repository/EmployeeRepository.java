package za.ac.cput.QuoteSystem.repository;

import org.springframework.data.repository.CrudRepository;
import za.ac.cput.QuoteSystem.domain.Employee;

/**
 * Created by student on 2015/09/18.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
