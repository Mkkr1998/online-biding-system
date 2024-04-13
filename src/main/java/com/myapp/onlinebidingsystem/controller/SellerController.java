package com.myapp.onlinebidingsystem.controller;

import com.myapp.onlinebidingsystem.model.dto.SellerDto;
import com.myapp.onlinebidingsystem.model.entities.Seller;
import com.myapp.onlinebidingsystem.service.SellerManager;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/seller")
@AllArgsConstructor
public class SellerController {
    private SellerManager sellerManager;

    @PostMapping
    public ResponseEntity<SellerDto> addSeller(@RequestBody SellerDto sellerDto){
        Seller seller= Seller.builder().sellerName(sellerDto.getSellerName()).build();
        sellerManager.addSeller(seller);
        sellerDto.setSellerId(seller.getSellerId());
        return new ResponseEntity<>(sellerDto,HttpStatus.CREATED);
    }
}
