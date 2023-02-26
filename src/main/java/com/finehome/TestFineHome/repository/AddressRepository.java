package com.finehome.TestFineHome.repository;

import com.finehome.TestFineHome.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Integer> {
}
