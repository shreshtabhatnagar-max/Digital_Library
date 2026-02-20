package org.gfg.Digital_Library.request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.gfg.Digital_Library.model.BookType;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class BookCreationRequest {
    @NotNull
    private  Integer bookId;
    @NotNull
    private  String bookName;
    @NotNull
    private  String description;
    @NotNull
    private  String publisher;
    @NotNull
    private  String authorName;
    @NotNull
    private BookType bookType;
    @NotNull
    private double bookPrice;
    @NotNull
    private  String authorEmail;
    @NotNull
    private  String authorMobile ;

}
