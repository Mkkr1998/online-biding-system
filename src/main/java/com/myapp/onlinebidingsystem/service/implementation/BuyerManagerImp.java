package com.myapp.onlinebidingsystem.service.implementation;

import com.myapp.onlinebidingsystem.model.entities.Buyer;
import com.myapp.onlinebidingsystem.repo.BuyerRepo;
import com.myapp.onlinebidingsystem.service.BuyerManger;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BuyerManagerImp implements BuyerManger {

    BuyerRepo buyerRepo;
    @Override
    public Buyer addBuyer(Buyer buyer) {
        return buyerRepo.save(buyer);
    }

    @Override
    public Buyer getBuyer(long buyerId) {
        return buyerRepo.getReferenceById(buyerId);
    }
}
