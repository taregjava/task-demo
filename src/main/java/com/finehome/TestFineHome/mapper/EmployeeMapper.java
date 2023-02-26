package com.finehome.TestFineHome.mapper;

import com.finehome.TestFineHome.builder.EmployeeBuilder;
import com.finehome.TestFineHome.entity.Employee;

public class EmployeeMapper {

    public static EmployeeBuilder mapToEmployeeBuilder(Employee entity) {

        return EmployeeBuilder.builder()
                .id(entity.getId())
                .address(entity.getAddress())
                .name(entity.getName())
                .createdAt(entity.getCreatedAt())
                .build();

    }
}
