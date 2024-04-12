package com.example.banking_application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.banking_application.entity.EmployeeEntity;

public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Integer>{

    List<EmployeeEntity> findByAddressOrCustName(String address, String custName);

    Integer deleteEmployeeEntityByAddress(String address);

    // Integer updateEmployeeAddress(String newAddress, String address);

    @Modifying
    @Query("UPDATE EmployeeEntity e SET e.address = :newAddress WHERE e.custName = :custName")
    int updateEmployeeAddress(String custName, String newAddress);

}