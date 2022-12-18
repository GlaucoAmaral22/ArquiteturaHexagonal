package com.hexagonalarchitecture.infraestructure;

import com.hexagonalarchitecture.domain.ports.TransactionDAO;
import com.hexagonalarchitecture.infraestructure.database.TransactionRepository;
import com.hexagonalarchitecture.infraestructure.database.TransactionDAODatabase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    public TransactionDAO transactionDAO(TransactionRepository transactionRepository) {
        return new TransactionDAODatabase(transactionRepository);
    }
}
