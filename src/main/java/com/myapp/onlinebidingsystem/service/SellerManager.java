package com.myapp.onlinebidingsystem.service;

import com.myapp.onlinebidingsystem.model.entities.Seller;
import org.springframework.stereotype.Service;


public interface SellerManager {
    Seller addSeller(Seller seller);

}
