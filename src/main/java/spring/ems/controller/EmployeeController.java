package spring.ems.controller;

import spring.ems.exception.ResourceNotFoundException;
import spring.ems.model.Employee;
import spring.ems.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@Transactional
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")

public class EmployeeController {
    @Autowired
    private EmployeesService service;

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return service.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long department)
            throws ResourceNotFoundException {
        return service.getEmployeeById(department);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@Valid @RequestBody Employee employees) {
        return service.createEmployee(employees);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long department,
                                                   @Valid @RequestBody Employee employeesDetails) throws ResourceNotFoundException {
        return service.updateEmployee(department, employeesDetails);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long department)
            throws ResourceNotFoundException {
        return service.deleteEmployee(department);
    }

}