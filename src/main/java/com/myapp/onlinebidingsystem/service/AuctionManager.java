package com.myapp.onlinebidingsystem.service;

import com.myapp.onlinebidingsystem.model.entities.Auction;
import com.myapp.onlinebidingsystem.model.entities.Buyer;
import org.springframework.stereotype.Service;

@Service
public interface AuctionManager {
    Auction addAuction(Auction auction);
    Buyer closeAuction(long auction_id);

    Auction getAuction(long auctionId);
}
