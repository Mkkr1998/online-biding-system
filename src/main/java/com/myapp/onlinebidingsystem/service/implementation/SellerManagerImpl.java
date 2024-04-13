package com.myapp.onlinebidingsystem.service.implementation;

import com.myapp.onlinebidingsystem.model.entities.Seller;
import com.myapp.onlinebidingsystem.repo.SellerRepo;
import com.myapp.onlinebidingsystem.service.SellerManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SellerManagerImpl implements SellerManager {

    private SellerRepo sellerRepo;
    @Override
    public Seller addSeller(Seller seller) {
        return sellerRepo.save(seller);
    }
}
