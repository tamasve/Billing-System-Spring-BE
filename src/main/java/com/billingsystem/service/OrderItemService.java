package com.billingsystem.service;

import com.billingsystem.entity.OrderDTO;
import com.billingsystem.entity.OrderItem;

import java.util.List;
import java.util.Optional;

public interface OrderItemService {

    List<OrderItem> findAll();

    List<OrderDTO> findAllByOrderId(Long id);

    Optional<OrderItem> findById(Long id);
}
