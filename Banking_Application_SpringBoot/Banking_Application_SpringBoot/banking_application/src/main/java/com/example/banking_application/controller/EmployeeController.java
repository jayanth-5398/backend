package com.example.banking_application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.banking_application.entity.EmployeeEntity;
import com.example.banking_application.service.EmployeeService;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService es;

    @PostMapping("adddata")
public ResponseEntity<EmployeeEntity>add(@RequestBody EmployeeEntity em){
    EmployeeEntity obj=es.create(em);
   return new ResponseEntity<>(obj,HttpStatus.CREATED); 
}
@GetMapping("showdata")
public ResponseEntity <List<EmployeeEntity>>showinfo(){
    return new ResponseEntity<>(es.getalldetails(),HttpStatus.OK);
}
@GetMapping("getdata")
public ResponseEntity <List<EmployeeEntity>>getinfo(){
    return new ResponseEntity<>(es.getalldetails(),HttpStatus.OK);
}

@GetMapping("/employee/sortBy/{address}")
public List<EmployeeEntity> g(@PathVariable String address)
{
        return es.sort(address);
}

@GetMapping("/employee/{offset}/{pagesize}")
public List<EmployeeEntity> get(@PathVariable int offset,@PathVariable int pagesize)
    {
        return es.page(pagesize,offset);
    } 

@GetMapping("/employee/{offset}/{pagesize}/{address}")
public List<EmployeeEntity> getsorting(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String address)
{
    return es.getsort(offset,pagesize,address);
}    

@PutMapping("/employee/{employeeId}")
    public ResponseEntity<EmployeeEntity> putMethodName(@PathVariable("employeeId") int id, @RequestBody EmployeeEntity employee) {
        if(es.updateDetails(id,employee) == true)
        {
            return new ResponseEntity<>(employee,HttpStatus.OK);
        }
        
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/employee/{employeeId}")
    public ResponseEntity<Boolean> delete(@PathVariable("employeeId") int id)
    {
        if(es.deleteEmployee(id) == true)
        {
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @GetMapping("/select/query/{address}/{custName}")
    public List<EmployeeEntity> displayAll(@PathVariable String address, @PathVariable String custName) {
        return es.getDetails(address, custName);
    }

    @DeleteMapping("/delete/query/{address}")
    public String deleteeInfo(@PathVariable String address) {
        return es.deleteEmployeeDetails(address) + " Deleted";
    }

    @PutMapping("/update/query/{newAddress}/{address}")
    public String updateeInfo(@PathVariable("newAddress") String newAddress, @PathVariable("address") String address) {
        return es.updateEmployeeDetails(newAddress, address) + " Updated";
    }

}