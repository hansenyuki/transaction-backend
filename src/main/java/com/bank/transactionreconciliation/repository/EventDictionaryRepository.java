package com.bank.transactionreconciliation.repository;

import com.bank.transactionreconciliation.model.EventDictionary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventDictionaryRepository extends JpaRepository<EventDictionary, Long> {
    List<EventDictionary> findByEventType(String eventType);
}
