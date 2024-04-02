package com.projetowebspring.course.services;

import com.projetowebspring.course.entities.Order;
import com.projetowebspring.course.entities.User;
import com.projetowebspring.course.repositories.OrderRepository;
import com.projetowebspring.course.repositories.UserRepository;
import com.projetowebspring.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> order = orderRepository.findById(id);
        return order.get();
    }
}
