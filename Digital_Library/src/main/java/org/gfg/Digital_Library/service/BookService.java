package org.gfg.Digital_Library.service;

import org.gfg.Digital_Library.model.Author;
import org.gfg.Digital_Library.model.Book;
import org.gfg.Digital_Library.repository.AuthorRepository;
import org.gfg.Digital_Library.repository.BookRepository;
import org.gfg.Digital_Library.request.BookCreationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    BookRepository bookRepository;
    @Autowired
    AuthorRepository authorRepository;

    public Book createBookInDatabase(BookCreationRequest bookCreationRequest) {
        Book book = Book.builder().bookId(bookCreationRequest.getBookId()).bookname(bookCreationRequest.getBookName()).price(bookCreationRequest.getBookPrice()).booktype(bookCreationRequest.getBookType()).publisher(bookCreationRequest.getPublisher()).build();
        int bookUpdated = 0;
        boolean authorExist = false;
        Author author = Author.builder().name(bookCreationRequest.getAuthorName()).email(bookCreationRequest.getAuthorEmail()).mobileNo(bookCreationRequest.getAuthorMobile()).build();
        try {//Create Author if not exist

            Author dbauthor = authorRepository.checkAuthor(author.getEmail(), author.getMobileNo());
            if (dbauthor == null || dbauthor.getName() == null || dbauthor.getName().length() == 0) {
                //author does not exist, we need to create the author
                int row = authorRepository.createAuthor(author);
            }
            //Create book in Database
            // bookUpdated = bookRepository.createBookInDatabase(book);
            authorExist = true;
        } catch (Exception e) {
            System.out.println("Going To Create The Author");
            authorExist = false;
        }
        try {
            if(!authorExist)
            {
                int row = authorRepository.createAuthor(author);
            }
            bookUpdated = bookRepository.createBookInDatabase(book);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        if (bookUpdated == 0) {
            return null;
        }
        return book;
    }
}
