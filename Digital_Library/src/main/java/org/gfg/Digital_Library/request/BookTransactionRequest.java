package org.gfg.Digital_Library.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookTransactionRequest {

    int studentId;
    int bookId;
    String amount;
    String requestType;

}
