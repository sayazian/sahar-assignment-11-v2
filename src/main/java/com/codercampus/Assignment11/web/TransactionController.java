package com.codercampus.Assignment11.web;

import com.codercampus.Assignment11.domain.Transaction;
import com.codercampus.Assignment11.service.TransactionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class TransactionController {

    private final TransactionService transactionService;

    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/")
    public String redirectToTransactions() {
        return "redirect:/transactions";
    }

    @GetMapping("/transactions")
    public String getTransactions(ModelMap model) {
        model.put("transactionList", transactionService.findAll());
        return "transactions";
    }

    @GetMapping("/transactions/{transactionId}")
    public String getOneTransaction(@PathVariable Integer transactionId, ModelMap model) {
        Transaction transaction = transactionService.findById(transactionId);
        if (transaction == null) {
            return "transactionError";
        }
        model.put("transaction", transaction);
        return "transaction";
    }

}
