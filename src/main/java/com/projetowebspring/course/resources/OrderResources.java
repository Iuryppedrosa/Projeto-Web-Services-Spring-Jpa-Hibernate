package com.projetowebspring.course.resources;
import com.projetowebspring.course.entities.Order;
import com.projetowebspring.course.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderResources {
    @Autowired
    private OrderService orderService;
    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> list = orderService.findAll();

        return ResponseEntity.ok().body(list);
    }//T = generics

    @GetMapping(value = "/{id}")
    public ResponseEntity<Order> findById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}


//        Order Order = new Order();
//        Order.setId(1);
//        Order.setName("admin");
//        Order.setPassword("<PASSWORD>");
//        Order.setEmail("<EMAIL>");
//        Order.setPhone("1234567890");