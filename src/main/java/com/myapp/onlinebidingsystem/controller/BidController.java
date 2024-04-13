package com.myapp.onlinebidingsystem.controller;

import com.myapp.onlinebidingsystem.model.dto.BidDto;
import com.myapp.onlinebidingsystem.model.entities.Auction;
import com.myapp.onlinebidingsystem.model.entities.Bid;
import com.myapp.onlinebidingsystem.model.entities.Buyer;
import com.myapp.onlinebidingsystem.service.AuctionManager;
import com.myapp.onlinebidingsystem.service.BidsManager;
import com.myapp.onlinebidingsystem.service.BuyerManger;
import com.myapp.onlinebidingsystem.service.implementation.BidsManagerImpl;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/bid")
@AllArgsConstructor
public class BidController {

    private BidsManager bidsManager;
    private AuctionManager auctionManager;
    private BuyerManger buyerManger;

    @PostMapping
    public ResponseEntity<BidDto> addBid(@RequestBody BidDto bidDto){
        Auction auction = auctionManager.getAuction(bidDto.getAuctionId());
        Buyer buyer= buyerManger.getBuyer(bidDto.getBuyerId());
        Bid bid=Bid.builder()
                .bidName(bidDto.getBidName())
                .bid(bidDto.getBid())
                .auction(auction)
                .buyer(buyer).build();
        bid = bidsManager.addBid(bid);
        bidDto.setBidId(bid.getBidId());
        return new ResponseEntity<BidDto>(bidDto,HttpStatus.CREATED);
    }

    @PutMapping("/{bidId}")
    public ResponseEntity<BidDto> updateBid(@PathVariable long bidId,@RequestBody BidDto bidDto){
        Bid bid= bidsManager.getBid(bidId);
        if(bid.equals(null)) return new ResponseEntity<BidDto>(HttpStatus.NOT_FOUND);
        bid.setBid(bidDto.getBid());
        bid = bidsManager.addBid(bid);
        bidDto.setBidId(bidId);
        bidDto.setBidName(bid.getBidName());
        bidDto.setAuctionId(bid.getAuction().getAuctionId());
        bidDto.setBuyerId(bid.getBuyer().getBuyerId());
        return new ResponseEntity<BidDto>(bidDto, HttpStatus.CREATED);
    }

    @DeleteMapping("/{bidId}")
    public ResponseEntity<BidDto> removeBid(@PathVariable long bidId){
        Bid bid= bidsManager.getBid(bidId);
        if(bid.equals(null)) return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        bidsManager.removeBid(bidId);
        BidDto bidDto = BidDto.builder()
                .BidName(bid.getBidName())
                .bid(bid.getBid())
                .auctionId(bid.getAuction().getAuctionId())
                .buyerId(bid.getBuyer().getBuyerId()).build();
        return new ResponseEntity<BidDto>(bidDto,HttpStatus.ACCEPTED);
    }
}
