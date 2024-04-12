package com.example.banking_application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.banking_application.entity.Loan;
import com.example.banking_application.service.LoanService;

import java.util.List;

@RestController
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/addloans")
    public ResponseEntity<Loan> createLoan(@RequestBody Loan loan) {
        Loan createdLoan = loanService.createLoan(loan);
        return new ResponseEntity<>(createdLoan, HttpStatus.CREATED);
    }

    @GetMapping("/showloans")
    public ResponseEntity<List<Loan>> getAllLoans() {
        List<Loan> loans = loanService.getAllLoans();
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @GetMapping("/loans/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable("id") int id) {
        Loan loan = loanService.getLoanById(id);
        if (loan != null) {
            return new ResponseEntity<>(loan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/loan/sortBy/{loanType}")
    public List<Loan> g(@PathVariable String loanType)
    {
        return loanService.sort(loanType);
    }

    @GetMapping("/loan/{offset}/{pagesize}")
    public List<Loan> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return loanService.page(pagesize,offset);
    } 

    @GetMapping("/loan/{offset}/{pagesize}/{loanType}")
    public List<Loan> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String loanType)
    {
        return loanService.getsort(offset,pagesize,loanType);
    }    

    @PutMapping("/loans/{id}")
    public ResponseEntity<Loan> updateLoan(@PathVariable("id") int id, @RequestBody Loan loan) {
        Loan updatedLoan = loanService.updateLoan(id, loan);
        if (updatedLoan != null) {
            return new ResponseEntity<>(updatedLoan, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/loans/{id}")
    public ResponseEntity<Boolean> deleteLoan(@PathVariable("id") int id) {
        if (loanService.deleteLoan(id)) {
            return new ResponseEntity<>(true, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(false, HttpStatus.NOT_FOUND);
        }
    }
    
}