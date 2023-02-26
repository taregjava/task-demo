package com.finehome.TestFineHome.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
public class Employee extends TimestampedEntity implements Serializable {

    private String name;
    @OneToOne(fetch = FetchType.LAZY)
    protected Address address;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    protected
    Collection<EmployeeFile> images;

    public Collection<EmployeeFile> getImages() {
        return images;
    }

    public void setImages(Collection<EmployeeFile> images) {
        this.images = images;
    }

    public Employee(){

    }
    public Employee(int id, String name, String image, Address address) {
        this.id = id;
        this.name = name;

        this.address = address;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
