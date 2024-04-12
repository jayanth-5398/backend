package com.example.banking_application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.banking_application.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Integer> {
    

}