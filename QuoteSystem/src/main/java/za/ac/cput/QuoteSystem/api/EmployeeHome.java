package za.ac.cput.QuoteSystem.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import za.ac.cput.QuoteSystem.domain.Employee;
import za.ac.cput.QuoteSystem.services.EmployeeService;

import java.util.List;

/**
 * Created by student on 2015/09/21.
 */
@RestController
@RequestMapping("/api/**")
public class EmployeeHome {
    @Autowired
    private EmployeeService service;

    @RequestMapping(value = "/employee/", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Employee>> listResponseEntity() {
        List<Employee> employees = service.findAll();
        if(employees.isEmpty()){
            return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") long id)
    {
        Employee employee = service.findById(id);
        if(employee == null)
        {
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/create", method = RequestMethod.POST)
    public ResponseEntity<Void> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder)
    {
        service.save(employee);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/employee/{id}").buildAndExpand(employee.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/update/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee newEmployee)
    {
        service.update(newEmployee);
        return new ResponseEntity<Employee>(newEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Employee> deleteEmployee(@PathVariable("id") long id)
    {
        Employee employee = service.findById(id);
        if (employee == null) {
            System.out.println("Unable to delete. PackageProduct with id " + id + " not found");
            return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
        }

        service.delete(employee);
        System.out.println("Deleted");
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);

    }
}
