package com.projetowebspring.course.repositories;
import com.projetowebspring.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
