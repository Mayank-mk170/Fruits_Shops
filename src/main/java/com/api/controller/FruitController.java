package com.api.controller;

import com.api.entity.Fruits;
import com.api.payload.FruitsDto;
import com.api.service.FruitService;
import com.api.service.OtpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/fruit")

public class FruitController {
    private FruitService fruitService;
    private OtpService otpService;
    private Map<String, String> otpStore = new HashMap<>();
    public FruitController(FruitService fruitService){
        this.fruitService = fruitService;
    }
     @GetMapping
    public ResponseEntity <List<FruitsDto>>getAllFruits(){
       List<FruitsDto> dto =fruitService.getFruits();
       return new ResponseEntity<>(dto, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<FruitsDto> createFruits(
            @RequestBody FruitsDto fruits
    ){
        FruitsDto frdto = fruitService.createFruits(fruits);
        String  otp  = otpService.generateOtp();
        return new ResponseEntity<>(frdto,HttpStatus.CREATED);

    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateFruits(
            @PathVariable long id,
            @RequestBody Fruits fruits
    ){
        Fruits updFru = fruitService.updateFruits(id, fruits);
        return new ResponseEntity<>("updFru",HttpStatus.OK);

    }
    @DeleteMapping
    public ResponseEntity<String> DdeleteFruits(
            @RequestParam long id
    ){
        fruitService.deleteFruits(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<FruitsDto> getAllById(
            @PathVariable long id
    ){
        FruitsDto dto = fruitService.getFruitsById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }


}
