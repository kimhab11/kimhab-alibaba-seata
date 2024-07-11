package com.example.kimhabalibabaseataserver.quickstart.service;

import com.example.kimhabalibabaseataserver.quickstart.entity.Storage;
import com.example.kimhabalibabaseataserver.quickstart.repo.StoraRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class StorageService {

    @Autowired
    private StoraRepo storaRepo;

    @Transactional
    public void deduct(String commodityCode, int count){
        Storage storage = storaRepo.findByCommodityCode(commodityCode);
        log.info("storage:{}", storage);
        storage.setTotalCount(storage.getTotalCount()-count);
        storaRepo.save(storage);
        log.info("storage after deduct: {}", storage);
    }
}
