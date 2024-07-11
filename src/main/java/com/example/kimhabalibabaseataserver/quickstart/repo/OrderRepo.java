package com.example.kimhabalibabaseataserver.quickstart.repo;

import com.example.kimhabalibabaseataserver.quickstart.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {

}
