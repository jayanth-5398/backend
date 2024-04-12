package com.example.banking_application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.banking_application.entity.EmployeeEntity;
import com.example.banking_application.repository.EmployeeRepo;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo er;

    public EmployeeEntity create(EmployeeEntity ee){
        return er.save(ee);
    }

    public List<EmployeeEntity> getalldetails(){
        return er.findAll();
    
    }

    public EmployeeEntity getEmployeeById(int id){
        return er.findById(id).orElse(null);
    }

    public List<EmployeeEntity> sort(String address)
    {
        Sort sort=Sort.by(Sort.Direction.ASC,address);
        return er.findAll(sort);
    }

    public List<EmployeeEntity> page(int pageSize,int pageNumber)
    {
        Pageable page=PageRequest.of(pageNumber, pageSize);
        return er.findAll(page).getContent();
    }

    public List<EmployeeEntity> getsort(int pageNumber,int pageSize,String address)
    {          return er.findAll(PageRequest.of(pageNumber, pageSize)
          .withSort(Sort.by(Sort.Direction.ASC,address))).getContent();
    }

    public boolean updateDetails(int id,EmployeeEntity employee)
        {
            if(this.getEmployeeById(id)==null)
            {
                return false;
            }
            try{
                er.save(employee);
            }
            catch(Exception e)
            {
                return false;
            }
            return true;
        }

        public boolean deleteEmployee(int id)
        {
            if(this.getEmployeeById(id) == null)
            {
                return false;
            }
            er.deleteById(id);
            return true;
        }

        public List<EmployeeEntity> getDetails(String address, String custName) {
            return er.findByAddressOrCustName(address, custName);
        }   

        public Integer deleteEmployeeDetails(String address) {
            return er.deleteEmployeeEntityByAddress(address);
        }
        public Integer updateEmployeeDetails(String newAddress, String address) {
            return er.updateEmployeeAddress(newAddress, address);
        }    

}