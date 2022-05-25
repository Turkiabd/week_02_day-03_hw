package com.example.day4sbexer.Controllers;


import com.example.day4sbexer.models.ApiResponse;
import com.example.day4sbexer.models.Ride;
import com.example.day4sbexer.models.Purchased;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("api/v1/park")
public class ParkController {




    ArrayList<Ride> rides = new ArrayList<>();


    @GetMapping
    public ResponseEntity<ArrayList<Ride>> getRide(){
     return ResponseEntity.status(HttpStatus.OK).body(rides);
    }


    @PostMapping
    public ResponseEntity<ApiResponse> addRide(@RequestBody @Valid Ride ride,
                                                   Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(new ApiResponse(errors.getFieldError().getDefaultMessage(), 400));
        }
        rides.add(ride);
        return ResponseEntity.status(201).body(new ApiResponse("New park added " , 201));

    }


    @PutMapping("/{index}")
    public ResponseEntity<ApiResponse> updateRide(@RequestBody Ride ride, @PathVariable Integer index){
        if(index>= rides.size()-1 || index <0 ){
            return ResponseEntity.status(400).body(new ApiResponse("invalid index" , 201));
        }

        rides.set(index , ride);
        return ResponseEntity.status(200).body(new ApiResponse("the Ride updated" ,200));
    }


    @DeleteMapping("/{index}")
    public ResponseEntity<ApiResponse> delRide(@RequestBody Ride ride, @PathVariable Integer index){
        if(index>= rides.size()-1 || index <0 ){
            return ResponseEntity.status(400).body(new ApiResponse("invalid index" , 201));
        }

        rides.remove(index);

        return ResponseEntity.status(200).body(new ApiResponse("the Ride deleted" ,200));
    }


//need work on my business logic!!!
    @PutMapping("/purchased")
    public ResponseEntity<ApiResponse> tickPurchased(@RequestBody Purchased purchased){
        if(purchased.getAmount() <=0 ){
            return ResponseEntity.status(400).body(new ApiResponse("Wrong Amount" , 400));
        }
        Ride curRide = getRideId(purchased.getId());
        //purchase tick
        Integer oldTick = curRide.getPrice();
        curRide.setTickets(oldTick-purchased.getAmount());
        purchased.setAmount(curRide.getTickets());
        return ResponseEntity.status(200).body(new ApiResponse("Purchase completed", 200));



    }

    public Ride getRideId(String id){
        for (int i = 0; i <rides.size() ; i++) {
            Ride curRide = rides.get(i);

            if(curRide.getRideID()== id){
                return curRide;
            }
        }
        return null;
    }

    // reduce ticket by1
    public Ride reduceTick(Integer ticket){
       if ()

    }



}
