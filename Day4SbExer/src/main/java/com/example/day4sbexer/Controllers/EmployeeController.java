package com.example.day4sbexer.Controllers;


import com.example.day4sbexer.models.AnnualLeave;
import com.example.day4sbexer.models.ApiResponse;
import com.example.day4sbexer.models.Employee;
import com.example.day4sbexer.models.Ride;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/emp")
public class EmployeeController {

    ArrayList<Employee> employees = new ArrayList<>();


    @GetMapping
    public ResponseEntity<ArrayList<Employee>> getEmp(){
        return ResponseEntity.status(HttpStatus.OK).body(employees);
    }


    @PostMapping
    public ResponseEntity<ApiResponse> addEmp(@RequestBody @Valid Employee employee,
                                               Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage(), 400));
        }
        employees.add(employee);
        return ResponseEntity.status(201).body(new ApiResponse("New Employee added " , 201));

    }


    @PutMapping("/{index}")
    public ResponseEntity<ApiResponse> updateEmp(@RequestBody Employee employee, @PathVariable Integer index){
        if(index>= employees.size()-1 || index <0 ){
            return ResponseEntity.status(400).body(new ApiResponse("invalid index" , 400));
        }

        employees.set(index , employee);
        return ResponseEntity.status(200).body(new ApiResponse("the Emp updated" ,200));
    }


    @DeleteMapping("/{index}")
    public ResponseEntity<ApiResponse> delEmp(@RequestBody Employee employee, @PathVariable Integer index){
        if(index>= employees.size()-1 || index <0 ){
            return ResponseEntity.status(400).body(new ApiResponse("invalid index" , 400));
        }

        employees.remove(index);

        return ResponseEntity.status(200).body(new ApiResponse("the Employee deleted" ,200));
    }

    @PutMapping("/index")
    public ResponseEntity<ApiResponse> annualLeave(AnnualLeave annualLeave){
        if(annualLeave.getId() == null){
            return ResponseEntity.status(400).body(new ApiResponse("you must have an id" ,400));
        }



    }



    public void applyLeave(AnnualLeave annualLeave){
        Integer du= annualLeave.getStartDate() - annualLeave.getEndDate();
    }

























}
