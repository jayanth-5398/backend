package com.example.banking_application.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class EmployeeEntity {

    @Id
    private int custId;
    private String custName;
    private String password; 
    private String mobileNumber;
    private int age;
    private String address;
    private String accountNumber;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL)
    @JsonManagedReference
    private Loan loan;

    public EmployeeEntity(int custId, String custName, String password, String mobileNumber, int age, String address, String accountNumber) {
        this.custId = custId;
        this.custName = custName;
        this.password = password;
        this.mobileNumber = mobileNumber;
        this.age = age;
        this.address = address;
        this.accountNumber = accountNumber;
    }

    public EmployeeEntity() {
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }
}