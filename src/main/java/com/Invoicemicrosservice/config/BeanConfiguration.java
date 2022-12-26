package com.Invoicemicrosservice.config;

import com.Invoicemicrosservice.adapter.forobtainingtransactions.database.h2.TransactionRepository;
import com.Invoicemicrosservice.adapter.forobtainingtransactions.database.h2.TransactionDAODatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TransactionDAODatabase transactionDAO(TransactionRepository transactionRepository) {
        return new TransactionDAODatabase(transactionRepository);
    }
}
