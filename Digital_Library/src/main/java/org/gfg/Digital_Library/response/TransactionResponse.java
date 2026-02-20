package org.gfg.Digital_Library.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransactionResponse extends Response{
    private String transactionType;
    private String bookName;

}
