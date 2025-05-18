package com.bank.transactionreconciliation.controller;

import com.bank.transactionreconciliation.model.Transaction;
import com.bank.transactionreconciliation.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
@CrossOrigin
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository;

    // Rechercher toutes les transactions associées à un ID
    @GetMapping("/search/{id}")
    public List<Transaction> searchById(@PathVariable String id) {
        List<Transaction> chain = transactionRepository.findByPrimaryIdOrSecondaryId(id, id);

        // Tri par stepRank PUIS eventRank
        chain.sort(Comparator
                .comparing(Transaction::getStepRank, Comparator.nullsLast(Integer::compareTo))
                .thenComparing(Transaction::getEventRank, Comparator.nullsLast(Integer::compareTo)));

        return chain;
    }

    // Lister les transactions avec une date invalide
    @GetMapping("/invalid-dates")
    public List<Transaction> getInvalidDateTransactions() {
        return transactionRepository.findByValidDateFalse();
    }
}
