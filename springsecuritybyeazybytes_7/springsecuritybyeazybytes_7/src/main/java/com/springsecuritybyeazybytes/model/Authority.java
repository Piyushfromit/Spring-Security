package com.springsecuritybyeazybytes.model;


import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

<<<<<<< HEAD
=======

>>>>>>> 3d75986406546d0ed93775703e4225f43b7b65b4
@Entity
@Table(name = "authorities")
public class Authority {

<<<<<<< HEAD

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator="native")
    @GenericGenerator(name = "native",strategy = "native")
    private Long id;

    private String name;


    @ManyToMany
    @JoinColumn(name = "customer_id")
    private Customer customer;;;;;
=======
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO,generator ="native")
    @GenericGenerator(name="native",strategy="native")
   private  Long id;
   private  String name;


   @ManyToOne
   @JoinColumn(name = "customer_id")
   private Customer customer;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
>>>>>>> 3d75986406546d0ed93775703e4225f43b7b65b4
}
