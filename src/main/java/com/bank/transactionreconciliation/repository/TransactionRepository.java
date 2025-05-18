package com.bank.transactionreconciliation.repository;

import com.bank.transactionreconciliation.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    // Recherche par primaryId ou secondaryId
    List<Transaction> findByPrimaryIdOrSecondaryId(String primaryId, String secondaryId);

    // Pour rechercher uniquement les transactions dont la date est invalide
    List<Transaction> findByValidDateFalse();
}
