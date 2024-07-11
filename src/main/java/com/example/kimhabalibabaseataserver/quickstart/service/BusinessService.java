package com.example.kimhabalibabaseataserver.quickstart.service;

import com.example.kimhabalibabaseataserver.quickstart.entity.Order;
import com.example.kimhabalibabaseataserver.quickstart.repo.OrderRepo;
import com.example.kimhabalibabaseataserver.quickstart.repo.StoraRepo;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusinessService {

    @Autowired
    private StorageService storageService;
    @Autowired
    private OrderService orderService;

    @GlobalTransactional(name = "test-seata", rollbackFor = Exception.class)
   // @GlobalTransactional
    public void purchase(String userId, String commodityCode, int orderCount) {
        storageService.deduct(commodityCode, orderCount);
        orderService.create(userId, commodityCode, orderCount);

        if (orderCount > 100) {
            throw new RuntimeException("Order amount exceeds limit");
        }

    }
}
