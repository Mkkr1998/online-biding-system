package com.myapp.onlinebidingsystem.repo;

import com.myapp.onlinebidingsystem.model.entities.Auction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepo extends JpaRepository<Auction,Long> {
}
