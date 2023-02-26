package com.finehome.TestFineHome.controller;

import com.finehome.TestFineHome.builder.EmployeeBuilder;
import com.finehome.TestFineHome.dto.EmployeeResponse;
import com.finehome.TestFineHome.dto.base.AppResponse;
import com.finehome.TestFineHome.entity.Address;
import com.finehome.TestFineHome.entity.Employee;
import com.finehome.TestFineHome.service.EmployeeService;
import com.finehome.TestFineHome.service.EmployeeServiceImpl;
import com.finehome.TestFineHome.service.StorageService;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired
    private StorageService storageService;
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public ResponseEntity<AppResponse> create(HttpServletRequest request,
                                              @RequestParam("images[]") MultipartFile[] uploadingFiles,@RequestPart("address") String address) throws IOException {


        final Employee employee = new Employee();
        request.getParameterMap().forEach((key, value) -> {
            if (key.equalsIgnoreCase("name"))
                employee.setName(value[0]);

        });
        List<File> files = storageService.upload(uploadingFiles, "/images/employee");
        employeeService.createWithImage(employee, files,address);
        return new ResponseEntity<>(EmployeeResponse.build(employee),HttpStatus.CREATED);
    }

    @GetMapping
    public List<EmployeeBuilder> index() {

       List<EmployeeBuilder> employeeList = employeeService.findAll();

        return employeeList;

    }

    }
