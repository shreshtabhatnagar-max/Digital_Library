package org.gfg.Digital_Library.controller;

import org.gfg.Digital_Library.model.Book;
import org.gfg.Digital_Library.request.BookCreationRequest;
import org.gfg.Digital_Library.response.BookCreationResponse;
import org.gfg.Digital_Library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    BookService bookService;
    @PostMapping("/create/book")
    public ResponseEntity<BookCreationResponse> createBook(@RequestBody BookCreationRequest bookCreationRequest)
    {
Book book =bookService.createBookInDatabase(bookCreationRequest);
        BookCreationResponse bookCreationResponse=new BookCreationResponse();
        if(book==null)
        {
            bookCreationResponse.setStatus("Not Created");
            bookCreationResponse.setMessage("Book Not Created");
            return new ResponseEntity<>(bookCreationResponse, HttpStatus.BAD_REQUEST);
        }

        bookCreationResponse.setStatus("Created");
        bookCreationResponse.setMessage("Book  Created");
        bookCreationResponse.setBookname(book.getBookname());
        return new ResponseEntity<>(bookCreationResponse, HttpStatus.CREATED);
    }
}









