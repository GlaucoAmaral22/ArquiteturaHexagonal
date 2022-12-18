package com.hexagonalarchitecture.infraestructure.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
    @Query(value = "SELECT * from TRANSACTIONS where card_number = ?1 and EXTRACT(YEAR from date) = ?2 and EXTRACT(MONTH from date) = ?3", nativeQuery = true)
    public List<TransactionEntity> findAllTransactionsByCardAndCurrentMonth(int cardNumber, int year, int month);
}
