package org.gfg.Digital_Library.service;

import org.gfg.Digital_Library.model.Book;
import org.gfg.Digital_Library.model.Transaction;
import org.gfg.Digital_Library.repository.BookRepository;
import org.gfg.Digital_Library.repository.TransactionRepository;
import org.gfg.Digital_Library.request.BookTransactionRequest;
import org.gfg.Digital_Library.response.TransactionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
@Autowired
    BookRepository bookRepository;
public Transaction createTransaction(BookTransactionRequest request){
    int row =transactionRepository.issueBookToStudeent(request);
    if(row<=0)
    {
        return null;
    }
    Book book = bookRepository.findBookById(request.getBookId());
    Transaction transaction=new Transaction();
    transaction.setBook(book);
    return  transaction;
}
}
