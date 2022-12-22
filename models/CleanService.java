package com.cleaning.webproject.models;

import javax.persistence.*;

@Entity
public class CleanService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name_service;
    private int price_service;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName_service() {
        return name_service;
    }

    public void setName_service(String name_service) {
        this.name_service = name_service;
    }

    public int getPrice_service() {
        return price_service;
    }

    public void setPrice_service(int price_service) {
        this.price_service = price_service;
    }

    public CleanService() {
    }

    public CleanService(String name_service, int price_service) {
        this.name_service = name_service;
        this.price_service = price_service;
    }
}