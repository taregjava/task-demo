package com.finehome.TestFineHome.service;

import com.finehome.TestFineHome.entity.Employee;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface EmployeeService {
    public Employee save(MultipartFile file) throws IOException;
    Employee create(Employee product);
}
