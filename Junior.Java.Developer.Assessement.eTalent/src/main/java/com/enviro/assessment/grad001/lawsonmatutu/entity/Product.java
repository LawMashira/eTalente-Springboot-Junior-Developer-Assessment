package com.enviro.assessment.grad001.lawsonmatutu.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productId;
    private String type; // RETIREMENTorSAVINGS
    private String name;
    private double currentBalance;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "investor_id" ,nullable = false)

    private Investor investor;

    public Product() {
    }

    public Product(String productId, String type, String name, double currentBalance, Investor investor) {
        this.productId = productId;
        this.type = type;
        this.name = name;
        this.currentBalance = currentBalance;
        this.investor = investor;
    }

}
