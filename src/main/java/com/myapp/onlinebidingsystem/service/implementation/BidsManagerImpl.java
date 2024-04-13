package com.myapp.onlinebidingsystem.service.implementation;

import com.myapp.onlinebidingsystem.model.entities.Bid;
import com.myapp.onlinebidingsystem.repo.BidRepo;
import com.myapp.onlinebidingsystem.service.BidsManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BidsManagerImpl implements BidsManager {
    private BidRepo bidRepo;
    @Override
    public Bid addBid(Bid bid) {
        return bidRepo.save(bid);
    }
    @Override
    public Bid removeBid(long bid_id) {
        Bid temp = bidRepo.getReferenceById(bid_id);
        bidRepo.delete(temp);
        return temp;
    }

    @Override
    public Bid getBid(long bidId) {
        return bidRepo.getReferenceById(bidId);
    }

}
