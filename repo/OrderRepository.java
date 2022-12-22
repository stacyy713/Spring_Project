package com.cleaning.webproject.repo;

import com.cleaning.webproject.models.OrderService;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<OrderService, Long> {
}
