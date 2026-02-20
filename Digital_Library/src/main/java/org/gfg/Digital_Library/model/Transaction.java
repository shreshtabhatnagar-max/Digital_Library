package org.gfg.Digital_Library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Transaction {
    private String txnId;
    private Student student;
    private Book book;
    private double paidAmount;
    private Date createdOn;
    private Date updatedOn;
    private TransactionType type;
}
