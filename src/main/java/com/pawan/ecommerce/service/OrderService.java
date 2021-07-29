package com.pawan.ecommerce.service;

import com.pawan.ecommerce.dto.OrderRequest;
import com.pawan.ecommerce.model.Order;
import com.pawan.ecommerce.repo.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    @Autowired
    OrderRepo orderRepo;

    public void create_order(OrderRequest orderRequest) {

        Order order = new Order();
        order.setCategory(orderRequest.getCategory());
        order.setName(orderRequest.getName());
        order.setCreated_by(orderRequest.getCreated_by());
        order.setPrice(orderRequest.getPrice());
        order.setProduct(orderRequest.getProduct());
    }

    public List<Order> getAllProducts() {
        return orderRepo.findAll();
    }

    public Order getOrderByID(int id) {
       return  orderRepo.findById(id).get();
    }

    public void updateOrder(Order order, OrderRequest orderRequest) {
        order.setName(orderRequest.getName());
        order.setPrice(orderRequest.getPrice());
        order.setCategory(orderRequest.getCategory());
        order.setCreated_by(orderRequest.getCreated_by());
        order.setProduct(orderRequest.getProduct());

        orderRepo.save(order);
    }

    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }
}
