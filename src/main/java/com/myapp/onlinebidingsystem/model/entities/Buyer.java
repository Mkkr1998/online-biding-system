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
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long buyerId;
    private String buyerName;
    @OneToMany(mappedBy = "buyer",cascade = CascadeType.ALL)
    private List<Bid> bidList;
}
