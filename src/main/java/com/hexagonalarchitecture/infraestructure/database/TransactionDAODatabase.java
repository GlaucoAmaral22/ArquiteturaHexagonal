package com.hexagonalarchitecture.infraestructure.database;

import com.hexagonalarchitecture.domain.Transaction;
import com.hexagonalarchitecture.domain.ports.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDAODatabase implements TransactionDAO {

    TransactionRepository transactionRepository;
    @Autowired
    public TransactionDAODatabase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public List<Transaction> findCurrentTransactions(int cardNumber, int year, int month) {
        List<TransactionEntity> transactionEntities = transactionRepository.findAllTransactionsByCardAndCurrentMonth(cardNumber,year,month);
        List<Transaction> transactions = new ArrayList<>();
        for (TransactionEntity entity : transactionEntities)
            transactions.add(new Transaction(
                    entity.getCardNumber(),
                    entity.getAmount(),
                    entity.getCurrecy(),
                    entity.getDate()
            ));
        return transactions;
    }
}
