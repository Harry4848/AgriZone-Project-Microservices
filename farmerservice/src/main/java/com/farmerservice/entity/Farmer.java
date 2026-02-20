package com.farmerservice.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Farmer_Table")
public class Farmer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Farmer_Name",nullable = false)
    private String name;

    @Column(name = "Mobile_Number",nullable = false, unique = true)
    private String mobileNumber;

    @Column(name = "Farmer_Gmail",nullable = false, unique = true)
    private String gmail;

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

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getGmail() {
        return gmail;
    }

    public void setGmail(String gmail) {
        this.gmail = gmail;
    }
}
