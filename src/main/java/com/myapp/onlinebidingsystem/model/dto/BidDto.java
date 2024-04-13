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
public class BidDto {
    private long BidId;
    private String BidName;
    private long bid;
    private long buyerId;
    private long auctionId;
}
