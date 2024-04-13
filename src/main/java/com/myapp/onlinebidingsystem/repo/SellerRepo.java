package com.myapp.onlinebidingsystem.repo;

import com.myapp.onlinebidingsystem.model.entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepo extends JpaRepository<Seller,Long> {
}
