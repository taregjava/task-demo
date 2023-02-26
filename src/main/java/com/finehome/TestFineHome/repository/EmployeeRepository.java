package com.finehome.TestFineHome.repository;

import com.finehome.TestFineHome.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

  /*  @Query("select new com.finehome.TestFineHome.entity.Employee(e.name, p.name, p.slug, p.price, p.stock, ) from Employee e")
    Page<Employee> findAll(PageRequest pageRequest);*/

}
