package com.dealerservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Dealer_Name")
public class Dealer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Dealer_Name", nullable = false)
    private String name;

    @Column(name = "Dealer_Email" , nullable = false , unique = true)
    private String email;

    @Column(name = "Mobile_Number" , nullable = false , unique = true)
    private String mobileNumber;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
}
