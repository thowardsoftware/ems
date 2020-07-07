package spring.ems.repository;

import spring.ems.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}



/*
import org.springframework.data.repository.CrudRepository;
import tcode.study.model.Employee;

// Repository class/interface is how we perform crud operations.
// Extends CrudRepository, a generics type, so we need to give the type and the primary key.
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {
    // No Business Logic is needed here
}
*/