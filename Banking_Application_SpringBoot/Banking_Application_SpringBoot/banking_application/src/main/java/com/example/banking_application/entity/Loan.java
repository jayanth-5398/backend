package com.example.banking_application.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Loan {

    @Id
    private int loanId;
    private String loanType;
    private double loanAmount;
    private int duration; 
    private double interestRate;

    @OneToOne
    @JsonBackReference
    private EmployeeEntity employee;

    public EmployeeEntity getEmployee() {
        return employee;
    }

    public void setEmployee(EmployeeEntity employee) {
        this.employee = employee;
    }

    public Loan() {
    }

    public Loan(int loanId, String loanType, double loanAmount, int duration, double interestRate) {
        this.loanId = loanId;
        this.loanType = loanType;
        this.loanAmount = loanAmount;
        this.duration = duration;
        this.interestRate = interestRate;
    }

    public int getLoanId() {
        return loanId;
    }

    public void setLoanId(int loanId) {
        this.loanId = loanId;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }
}