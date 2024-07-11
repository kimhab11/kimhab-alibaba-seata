package com.example.kimhabalibabaseataserver.quickstart.service;

import com.example.kimhabalibabaseataserver.quickstart.entity.Account;
import com.example.kimhabalibabaseataserver.quickstart.repo.AccRepo;
import com.example.kimhabalibabaseataserver.quickstart.repo.StoraRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class AccountService {
    @Autowired
    private AccRepo accRepo;


    @Transactional
    public void debit(String userId, int money){
        Account account = accRepo.findByUserId(userId);
        log.info("account: {}", account);
        account.setMoney(account.getMoney()-money);
        accRepo.save(account);
        log.info("account after deduct: {}", account);
    }
}
