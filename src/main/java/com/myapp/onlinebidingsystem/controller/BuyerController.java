package com.myapp.onlinebidingsystem.controller;

import com.myapp.onlinebidingsystem.model.dto.BuyerDto;
import com.myapp.onlinebidingsystem.model.entities.Buyer;
import com.myapp.onlinebidingsystem.service.BuyerManger;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/buyer")
@AllArgsConstructor
public class BuyerController {
    private BuyerManger buyerManger;

    @PostMapping
    public ResponseEntity<BuyerDto> addBuyer(@RequestBody BuyerDto buyerDto){
        Buyer buyer = Buyer.builder()
                .buyerName(buyerDto.getBuyerName())
                .build();
        buyer = buyerManger.addBuyer(buyer);
        buyerDto.setBuyerId(buyer.getBuyerId());
        return new ResponseEntity<BuyerDto>(buyerDto, HttpStatus.CREATED);
    }
}
