package com.finehome.TestFineHome.builder;

import com.finehome.TestFineHome.entity.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.time.ZonedDateTime;

@Builder
@ToString
@Getter
public class EmployeeBuilder {

    private Integer id;
    private String name;
    protected Address address;
    private ZonedDateTime createdAt;

}
