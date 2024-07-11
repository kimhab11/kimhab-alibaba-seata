package com.example.kimhabalibabaseataserver.quickstart.service;

import com.example.kimhabalibabaseataserver.quickstart.entity.Order;
import com.example.kimhabalibabaseataserver.quickstart.entity.Storage;
import com.example.kimhabalibabaseataserver.quickstart.repo.OrderRepo;
import com.example.kimhabalibabaseataserver.quickstart.repo.StoraRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private StoraRepo storaRepo;

    @Autowired
    private AccountService accountService;

    @Transactional
    public Order create(String userId, String commodityCode, int orderCount) {
        int orderMoney = calculate(commodityCode, orderCount);
        accountService.debit(userId, orderMoney);

        Order order = new Order();
        order.setUserId(userId);
        order.setCommodityCode(commodityCode);
        order.setOrderCount(orderCount);
        order.setMoney(orderMoney);
        log.info("create order: {}", order);
        return orderRepo.save(order);
    }

    private int calculate(String commodityCode, int orderCount) {
        Storage storage = storaRepo.findByCommodityCode(commodityCode);
        int retailPrice = storage.getRetailPrice();
        return orderCount * retailPrice;
    }
}
