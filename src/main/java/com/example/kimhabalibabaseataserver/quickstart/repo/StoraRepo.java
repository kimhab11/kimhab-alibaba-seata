package com.example.kimhabalibabaseataserver.quickstart.repo;

import com.example.kimhabalibabaseataserver.quickstart.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoraRepo extends JpaRepository<Storage, Long> {
    Storage findByCommodityCode(String code);
}
