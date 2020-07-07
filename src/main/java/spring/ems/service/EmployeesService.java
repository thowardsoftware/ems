package spring.ems.service;

import spring.ems.exception.ResourceNotFoundException;
import spring.ems.model.Employee;
import spring.ems.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeesService {
    @Autowired
    private EmployeeRepository repo;

    // Get all employees
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }

    // Get employee by id
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long id)
            throws ResourceNotFoundException {
        Employee employees = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));
        return ResponseEntity.ok().body(employees);
    }

    // Create employee
    public Employee createEmployee(@Valid @RequestBody Employee employees) {
        return repo.save(employees);
    }

    // Update employee information
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long id,
                                                   @Valid @RequestBody Employee employeesDetails) throws ResourceNotFoundException {
        Employee employees = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + id));

        employees.setDepartment(employeesDetails.getDepartment());
        employees.setTitle(employeesDetails.getTitle());
        employees.setEmail(employeesDetails.getEmail());
        employees.setLastName(employeesDetails.getLastName());
        employees.setFirstName(employeesDetails.getFirstName());
        final Employee updatedEmployee = repo.save(employees);
        return ResponseEntity.ok(updatedEmployee);
    }

    // Delete employee
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long department)
            throws ResourceNotFoundException {
        Employee employees = repo.findById(department)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + department));

        repo.delete(employees);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

}
