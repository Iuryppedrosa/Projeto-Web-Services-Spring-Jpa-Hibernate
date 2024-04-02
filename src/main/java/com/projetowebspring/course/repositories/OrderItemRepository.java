package com.projetowebspring.course.repositories;
import com.projetowebspring.course.entities.OrderItem;
import com.projetowebspring.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
