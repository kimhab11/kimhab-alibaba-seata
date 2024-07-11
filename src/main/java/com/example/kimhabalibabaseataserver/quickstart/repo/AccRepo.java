package com.example.kimhabalibabaseataserver.quickstart.repo;

import com.example.kimhabalibabaseataserver.quickstart.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccRepo extends JpaRepository<Account, Long> {
    Account findByUserId(String id);
}
