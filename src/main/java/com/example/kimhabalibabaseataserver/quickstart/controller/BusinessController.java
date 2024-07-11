package com.example.kimhabalibabaseataserver.quickstart.controller;

import com.example.kimhabalibabaseataserver.quickstart.service.BusinessService;
import com.example.kimhabalibabaseataserver.test_mysql.TestMySQLData;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class BusinessController {

    @Autowired
    private BusinessService businessService;

    @Autowired
    private TestMySQLData testMySQLData;

    @PostMapping("order/do")
    @GlobalTransactional
    public String order(@RequestParam String userId,
                      @RequestParam String commodityCode,
                      @RequestParam int orderCount) {
        businessService.purchase(userId,commodityCode,orderCount);
        log.info("Success");

        return "SUCCESS";
    }

    @PostMapping("sql")
    public void add() throws Exception {
        testMySQLData.run();
    }
}
