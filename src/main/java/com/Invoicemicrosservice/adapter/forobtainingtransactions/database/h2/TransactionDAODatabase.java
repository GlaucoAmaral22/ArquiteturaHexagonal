package com.Invoicemicrosservice.adapter.forobtainingtransactions.database.h2;

import com.Invoicemicrosservice.application.core.domain.Transaction;
import com.Invoicemicrosservice.application.driven.forobtainingtransactions.ForObtainingTransactions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class TransactionDAODatabase implements ForObtainingTransactions {

    TransactionRepository transactionRepository;

    @Autowired
    public TransactionDAODatabase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }
    @Override
    public List<Transaction> getTransactions(int cardNumber) {
        LocalDate localDate = LocalDate.now();
        int year = localDate.getYear();
        int month = localDate.getMonthValue();
        List<TransactionEntity> transactionEntities =
                transactionRepository.findAllTransactionsByCardAndCurrentMonth(cardNumber,year,month);
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
