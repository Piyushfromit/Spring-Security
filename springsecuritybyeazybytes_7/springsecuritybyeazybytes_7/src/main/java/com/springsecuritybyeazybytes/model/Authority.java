package com.springsecuritybyeazybytes.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "authorities")
public class Authority {


    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    private String name;


    @ManyToMany
    @JoinColumn(name = "customer_id")
    private Customer customer;;;;;
}
