package com.billingsystem.repository;

import com.billingsystem.entity.OrderDTO;
import com.billingsystem.entity.OrderItem;
import com.billingsystem.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface OrderItemRepository extends ListCrudRepository<OrderItem, Long> {

//    @Query(value = "select i.order_id, p.name, p.price, i.unit" +
//            "from order_items i, products p" +
//            "where i.prod_id = p.id" +
//            "and i.order_id = 1", nativeQuery = true)

//    @Query(value = "select prod_id from order_items", nativeQuery = true)

//    @Query(value = "select * from order_items o where o.id=2", nativeQuery = true) // works

//    @Query(value = "select o from OrderItem o where o.id=2")    // works

    // How to create a query that uses multiple table from DB?: using a DTO class (Data Transfer Object)
    // + JPQL is much easier to use in this situation...
    @Query(value = "select new com.billingsystem.entity.OrderDTO(oi.id, oi.order.date, oi.order.customer.name,"+
            " oi.product.name, oi.product.price, oi.unit) from OrderItem oi where oi.id = ?1")    // works
    public List<OrderDTO> findAllByOrderId(Long id);
}
