package com.finehome.TestFineHome.entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("0")
public class EmployeeFile extends FileUpload {

    @ManyToOne(fetch = FetchType.LAZY)
    Employee employee;


    @Override
    public Employee getEmployee() {
        return employee;
    }

    @Override
    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}

