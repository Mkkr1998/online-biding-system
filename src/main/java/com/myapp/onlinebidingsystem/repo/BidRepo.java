package com.myapp.onlinebidingsystem.repo;

import com.myapp.onlinebidingsystem.model.entities.Bid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidRepo extends JpaRepository<Bid,Long> {
}
