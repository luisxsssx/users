package com.example.demousers.Models;

import java.sql.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String name;
    
    private String description;

    @Column(name = "creation_date")
    @CreatedDate
    private Date CreationDate;

    private String total;
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client clien;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "budget_product", joinColumns = @JoinColumn(name = "budget_id"), inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> products;
}