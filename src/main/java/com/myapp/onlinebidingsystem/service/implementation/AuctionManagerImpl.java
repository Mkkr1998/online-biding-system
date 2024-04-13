package com.myapp.onlinebidingsystem.service.implementation;

import com.myapp.onlinebidingsystem.model.entities.Auction;
import com.myapp.onlinebidingsystem.model.entities.Buyer;
import com.myapp.onlinebidingsystem.repo.AuctionRepo;
import com.myapp.onlinebidingsystem.service.AuctionManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuctionManagerImpl implements AuctionManager {

    private AuctionRepo auctionRepo;
    @Override
    public Auction addAuction(Auction auction) {
        return auctionRepo.save(auction);
    }

    @Override
    public Buyer closeAuction(long auction_id) {
        Auction temp = auctionRepo.getReferenceById(auction_id);
        return null;
    }

    @Override
    public Auction getAuction(long auctionId) {
        return auctionRepo.getReferenceById(auctionId);
    }
}
