package com.example.kimhabalibabaseataserver.test_mysql;

import com.example.kimhabalibabaseataserver.quickstart.entity.Account;
import com.example.kimhabalibabaseataserver.quickstart.entity.Storage;
import com.example.kimhabalibabaseataserver.quickstart.repo.AccRepo;
import com.example.kimhabalibabaseataserver.quickstart.repo.StoraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Component
public class TestMySQLData implements CommandLineRunner {

    private Logger logger = LoggerFactory.getLogger(TestMySQLData.class);

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AccRepo accRepo;
    @Autowired
    private StoraRepo storaRepo;

    @Override
    public void run(String... args) {
        insertData();
    }

    public void insertData(){
        Account account = new Account();
        account.setMoney(20000);
        account.setUserId("A0384");
        accRepo.save(account);
        Storage storage = new Storage();
        storage.setTotalCount(500);
        storage.setCommodityCode("USB");
        storage.setRetailPrice(5);
        storaRepo.save(storage);
    }

    public void createCustomer(){
        //  create new customer
        Customer newCustomer = new Customer();
        newCustomer.setFirstName("John");
        newCustomer.setLastName("Doe");
        newCustomer.setEmail("john@simplesolution.dev");
        newCustomer.setPhone("123-456-789");
        customerRepository.save(newCustomer);

        List<Customer> customers = new ArrayList<>();
        customerRepository.findAll().forEach(customers::add);
        for(Customer customer: customers) {
            logger.info("Customer: " + customer.toString());
        }
    }
}
