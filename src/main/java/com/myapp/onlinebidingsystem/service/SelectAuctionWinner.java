package com.myapp.onlinebidingsystem.service;

import com.myapp.onlinebidingsystem.model.entities.Bid;
import com.myapp.onlinebidingsystem.model.entities.Buyer;

import java.util.List;

public interface SelectAuctionWinner {
    Buyer auctionWinner(List<Bid> bidList);
}
