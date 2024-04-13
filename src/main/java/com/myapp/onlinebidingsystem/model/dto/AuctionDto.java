package com.myapp.onlinebidingsystem.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuctionDto {
    private long auctionId;
    private String auctionName;
    private long maxBid;
    private long minBid;
    private long sellerId;
}