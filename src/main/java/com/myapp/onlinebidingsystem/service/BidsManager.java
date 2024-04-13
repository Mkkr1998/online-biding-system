package com.myapp.onlinebidingsystem.service;

import com.myapp.onlinebidingsystem.model.entities.Bid;
import org.springframework.stereotype.Service;

@Service
public interface BidsManager {
    Bid addBid(Bid bid);
    Bid removeBid(long bid_id);

    Bid getBid(long bidId);
}
