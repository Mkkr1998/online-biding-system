package com.myapp.onlinebidingsystem.service;

import com.myapp.onlinebidingsystem.model.entities.Buyer;
import org.springframework.stereotype.Service;

@Service
public interface BuyerManger {
    Buyer addBuyer(Buyer buyer);

    Buyer getBuyer(long buyerId);
}

