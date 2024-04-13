package com.myapp.onlinebidingsystem.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class Bid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long bidId;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "auction_id")
    private Auction auction;
}
