package com.codercampus.Assignment11.web;


import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.repository.TransactionRepository;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Comparator;
import java.util.List;

import static java.util.Comparator.*;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        model.put("transactionList", transactionService.loadTimeSortedTransactions());
        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getOneTransaction(@PathVariable Integer transactionId, ModelMap model) {
        model.put("transaction", transactionService.findById(transactionId));
        return "transaction";
    }

}
