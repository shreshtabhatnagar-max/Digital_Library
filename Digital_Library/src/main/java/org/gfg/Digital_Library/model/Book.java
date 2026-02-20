package org.gfg.Digital_Library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private int bookId;
    private String bookname;
    private String description;
    private double price;
    private String publisher;
    private Author author;
    private BookType booktype;
}
