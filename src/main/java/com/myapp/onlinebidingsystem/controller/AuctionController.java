package com.myapp.onlinebidingsystem.controller;

import com.myapp.onlinebidingsystem.model.dto.AuctionDto;
import com.myapp.onlinebidingsystem.model.dto.BuyerDto;
import com.myapp.onlinebidingsystem.model.entities.Auction;
import com.myapp.onlinebidingsystem.model.entities.Buyer;
import com.myapp.onlinebidingsystem.service.AuctionManager;
import com.myapp.onlinebidingsystem.service.SelectAuctionWinner;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/auction")
@AllArgsConstructor
public class AuctionController {
    private AuctionManager auctionManager;

    @PostMapping
    public ResponseEntity<AuctionDto> addAuction(@RequestBody AuctionDto auctionDto){
        Auction auction= Auction.builder()
                .auctionName(auctionDto.getAuctionName())
                .maxBid(auctionDto.getMaxBid())
                .minBid(auctionDto.getMinBid())
                .build();
        auction =auctionManager.addAuction(auction);
        auctionDto.setAuctionId(auction.getAuctionId());
        return new ResponseEntity<AuctionDto>(auctionDto, HttpStatus.CREATED);
    }

    @GetMapping("/{auctionId}")
    public ResponseEntity<BuyerDto> closeAuction(@PathVariable long auctionId){
        Auction auction = auctionManager.getAuction(auctionId);
        if(auction.equals(null)) return new ResponseEntity<BuyerDto>(HttpStatus.NOT_FOUND);
        SelectAuctionWinner selectAuctionWinner= (bids)->{
            bids.sort((x,y)->y.getBid()<x.getBidId()?0:1);
            if(bids.size()!=0) return bids.get(0).getBuyer();
            return null;
        };
        Buyer buyer = selectAuctionWinner.auctionWinner(auction.getBidList());
        if(buyer == null) return new ResponseEntity<BuyerDto>(HttpStatus.NOT_FOUND);
        BuyerDto buyerDto = BuyerDto.builder()
                .buyerName(buyer.getBuyerName())
                .buyerId(buyer.getBuyerId())
                .build();
        return new ResponseEntity<BuyerDto>(buyerDto, HttpStatusCode.valueOf(200));
    }


}
