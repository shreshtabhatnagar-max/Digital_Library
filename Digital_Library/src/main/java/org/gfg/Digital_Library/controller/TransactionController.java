package org.gfg.Digital_Library.controller;

import org.gfg.Digital_Library.model.Book;
import org.gfg.Digital_Library.model.Transaction;
import org.gfg.Digital_Library.request.BookTransactionRequest;
import org.gfg.Digital_Library.response.TransactionResponse;
import org.gfg.Digital_Library.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionController {
    @Autowired
    TransactionService transactionService;

    @PostMapping("/book/initiate")
    public ResponseEntity<TransactionResponse> initiateTransaction(@RequestBody BookTransactionRequest bookTransactionRequest) {

        TransactionResponse transactionResponse = new TransactionResponse();
        if (bookTransactionRequest == null) {
            transactionResponse.setStatus("FAILED");
            transactionResponse.setMessage("Request is Empty");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);

        }

        Transaction transaction = transactionService.createTransaction(bookTransactionRequest);
        if (transaction == null) {
            transactionResponse.setStatus("FAILED");
            transactionResponse.setMessage("Not Completed, please retry");
            return new ResponseEntity<>(transactionResponse, HttpStatus.OK);

        }
        transactionResponse.setTransactionType(bookTransactionRequest.getRequestType());
        transactionResponse.setBookName(transaction.getBook().getBookname());
        transactionResponse.setMessage("Book"+bookTransactionRequest.getRequestType());
        transactionResponse.setMessage("SUCCESS");
        return new ResponseEntity<>(transactionResponse, HttpStatus.CREATED);
    }
}