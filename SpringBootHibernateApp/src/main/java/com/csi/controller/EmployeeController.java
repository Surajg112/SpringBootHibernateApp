package com.csi.controller;

import com.csi.model.Employee;
import com.csi.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService employeeServiceImpl;

    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody Employee employee){
            log.info("######### trying to save data for"+ employee.getEmpName());
        employeeServiceImpl.signUp(employee);
        return ResponseEntity.ok("SIGN UP DONE SUCESSFULLY");

    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword){

        return ResponseEntity.ok(employeeServiceImpl.signIn(empEmailId,empPassword));

    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Employee> getDataById(@PathVariable int empId){

        return ResponseEntity.ok(employeeServiceImpl.getDataById(empId));

    }

    @GetMapping("/getdatabyname/{empName}")
    public ResponseEntity<List<Employee>> getDataByName(@PathVariable String empName){

        return ResponseEntity.ok(employeeServiceImpl.getDataByName(empName));

    }

    @GetMapping("/getalldata")
    public ResponseEntity<List<Employee>> getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }


    @PutMapping("/updatedata/{empId}")
    public ResponseEntity<String> updateData(@PathVariable int empId, @RequestBody Employee employee){

        employeeServiceImpl.updateData(empId, employee);

        return ResponseEntity.ok("DATA updated sucessfully");

    }


    @DeleteMapping("/deletedatabyid/{empId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int empId){

        employeeServiceImpl.deleteDataById(empId);
        return ResponseEntity.ok("Data deleted sucessfully");
    }

    @DeleteMapping("/deletealldata")
    public ResponseEntity<String> deleteAllData(){
        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All data deleted sucessfully");

    }
}
