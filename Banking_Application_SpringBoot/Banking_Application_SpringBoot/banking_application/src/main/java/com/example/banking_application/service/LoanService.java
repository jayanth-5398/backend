package com.example.banking_application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.banking_application.entity.Loan;
import com.example.banking_application.repository.LoanRepository;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    private LoanRepository loanRepository;

    public Loan createLoan(Loan loan) {
        return loanRepository.save(loan);
    }

    public List<Loan> getAllLoans() {
        return loanRepository.findAll();
    }

    public Loan getLoanById(int id) {
        return loanRepository.findById(id).orElse(null);
    }

    public List<Loan> sort(String loanType)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,loanType);
        return loanRepository.findAll(sort);
    }

    public List<Loan> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return loanRepository.findAll(page).getContent();
    }

    public List<Loan> getsort(int pageNumber,int pageSize,String loanType)
    {          return loanRepository.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,loanType))).getContent();
    }

    public Loan updateLoan(int id, Loan loan) {
        Loan existingLoan = loanRepository.findById(id).orElse(null);
        if (existingLoan != null) {
            loan.setLoanId(existingLoan.getLoanId());
            return loanRepository.save(loan);
        }
        return null;
    }

    public boolean deleteLoan(int id) {
        Loan existingLoan = loanRepository.findById(id).orElse(null);
        if (existingLoan != null) {
            loanRepository.deleteById(id);
            return true;
        }
        return false;
    }
 
}