package com.finehome.TestFineHome.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.finehome.TestFineHome.builder.EmployeeBuilder;
import com.finehome.TestFineHome.entity.Address;
import com.finehome.TestFineHome.entity.Employee;
import com.finehome.TestFineHome.mapper.EmployeeMapper;
import com.finehome.TestFineHome.repository.AddressRepository;
import com.finehome.TestFineHome.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    @Autowired
    private EmployeeRepository repository;
    @Autowired
    FileUploadService fileUploadService;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Employee save(MultipartFile file)  throws IOException {

        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        long size = file.getSize();
        return null;
    }

    @Override
    public Employee create(Employee product) {
        return null;
    }

    public Employee createWithImage(Employee employee, List<File> files, String empAdd) {

        Address address= saveEmpAdd(empAdd);
        addressRepository.save(address);
        employee.setAddress(address);
        employee.setImages(fileUploadService.saveImages(employee, files));

        return repository.save(employee);
    }
    public Address saveEmpAdd(String adress){
        Address addressJson= new Address();
      try {
          ObjectMapper objectMapper= new ObjectMapper();
          addressJson= objectMapper.readValue(adress,Address.class);
      } catch (JsonMappingException e) {
          throw new RuntimeException(e);
      } catch (JsonProcessingException e) {
          throw new RuntimeException(e);
      }
      return addressJson;
    }
    public List<EmployeeBuilder> findAll(){
       List<EmployeeBuilder> employeeBuilders= repository.findAll()
               .stream()
               .map(EmployeeMapper::mapToEmployeeBuilder)
               .collect(Collectors.toList());
       return employeeBuilders;

    }
}
