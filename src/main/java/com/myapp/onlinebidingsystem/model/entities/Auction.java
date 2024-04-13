package com.myapp.onlinebidingsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Auction {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long auctionId;
    private String auctionName;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "seller_id")
    private Seller seller;
    private long maxBid;
    private long minBid;
    @OneToMany(mappedBy = "auction",cascade = CascadeType.ALL)
    private List<Bid> bidList;
}
