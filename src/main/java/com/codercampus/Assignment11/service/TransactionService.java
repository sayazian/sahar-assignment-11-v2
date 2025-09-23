package com.codercampus.Assignment11.service;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import static java.util.Comparator.comparing;

@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> loadTimeSortedTransactions() {
        List<Transaction> transactionList = transactionRepository.findAll();
        transactionList.sort(comparing(Transaction::getDate));
        return transactionList;
    }

    public Transaction findById(Integer transactionId) {
        return transactionRepository.findAll()
                .stream()
                .filter(transaction -> Math.toIntExact(transaction.getId()) == transactionId)
                .findFirst().get();
    }
}
