package com.cleaning.webproject.models;

import javax.persistence.*;

@Entity
public class OrderService {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long user_id;
    private Long service_id;
    private String date_service;
    private String time_service;
    private String add_info;

    public OrderService() {
    }

    public OrderService(Long user_id, Long service_id, String date_service, String time_service, String add_info) {
        this.user_id = user_id;
        this.service_id = service_id;
        this.date_service = date_service;
        this.time_service = time_service;
        this.add_info = add_info;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getService_id() {
        return service_id;
    }

    public void setService_id(Long service_id) {
        this.service_id = service_id;
    }

    public String getDate_service() {
        return date_service;
    }

    public void setDate_service(String date_service) {
        this.date_service = date_service;
    }

    public String getTime_service() {
        return time_service;
    }
    public void setTime_service(String time_service) {
        this.time_service = time_service;
    }

    public String getAdd_info() {
        return add_info;
    }

    public void setAdd_info(String add_info) {
        this.add_info = add_info;
    }
}
