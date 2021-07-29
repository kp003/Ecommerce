package com.pawan.ecommerce.controller;


import com.pawan.ecommerce.dto.OrderRequest;
import com.pawan.ecommerce.model.Order;
import com.pawan.ecommerce.service.OrderService;
import org.aspectj.weaver.ast.Or;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order_")
public class OrderController {
    @Autowired
    OrderService orderService;

    @PostMapping("/create")
    public ResponseEntity<?> createorder(@RequestBody OrderRequest orderRequest)
    {

        JSONObject jsonObject = new JSONObject();
        orderService.create_order(orderRequest);
        jsonObject.put("Status",200);
        jsonObject.put("message","Sucessfully added order");
        return ResponseEntity.status(HttpStatus.OK).body(jsonObject.toString());
    }

    @GetMapping("/getAllOrder")
    public List<Order> getAllOrders(){

        return orderService.getAllProducts();
    }

    @GetMapping("/getOrder/{id}")
    public Order getOrder(@PathVariable int id){

        return orderService.getOrderByID(id);
    }

    @PutMapping("/updateOrder/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody OrderRequest orderRequest){

        Order order = orderService.getOrderByID(id);
        orderService.updateOrder(order,orderRequest);
    }

    @DeleteMapping("/deleteOrder/{id}")
    public void deleteOrder(@PathVariable int id){
        orderService.deleteOrder(id);
    }
}
