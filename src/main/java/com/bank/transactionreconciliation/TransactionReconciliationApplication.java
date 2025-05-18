package com.bank.transactionreconciliation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.bank.transactionreconciliation.model.Transaction;
import com.bank.transactionreconciliation.model.EventDictionary;
import com.bank.transactionreconciliation.repository.TransactionRepository;
import com.bank.transactionreconciliation.repository.EventDictionaryRepository;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

@SpringBootApplication
public class TransactionReconciliationApplication {
	public static void main(String[] args) {
		SpringApplication.run(TransactionReconciliationApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(TransactionRepository transactionRepository, EventDictionaryRepository eventDictionaryRepository) {
		return args -> {
			ObjectMapper objectMapper = new ObjectMapper();
			InputStream inputStream = getClass().getResourceAsStream("/transactions.json");

			if (inputStream != null) {
				Transaction[] transactions = objectMapper.readValue(inputStream, Transaction[].class);
				for (Transaction t : transactions) {
					t.setEventDate(parseDate(t.getRawDate()));
					t.setValidDate(t.getEventDate() != null);

					List<EventDictionary> refs = eventDictionaryRepository.findByEventType(t.getEventType());
					if (!refs.isEmpty()) {
						EventDictionary ref = refs.get(0);
						t.setEventRank(ref.getEventRank());
						t.setStepRank(ref.getStepRank());
					}

					transactionRepository.save(t);
				}
			}
		};
	}

	private LocalDateTime parseDate(String dateStr) {
		try {
			return LocalDateTime.parse(dateStr, DateTimeFormatter.ISO_DATE_TIME);
		} catch (DateTimeParseException e) {
			return null; // Invalid date
		}
	}
}
