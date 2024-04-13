package com.myapp.onlinebidingsystem.repo;

import com.myapp.onlinebidingsystem.model.entities.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerRepo extends JpaRepository<Buyer,Long> {
}
