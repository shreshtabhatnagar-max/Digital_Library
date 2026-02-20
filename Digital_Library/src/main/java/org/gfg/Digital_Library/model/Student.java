package org.gfg.Digital_Library.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private int id;
    private String name;
    private String email;
    private String mobileNo;
    private Address address;
    private String dob;
    private Studentstatus studentstatus;
    List<Book> issuedbook;
    Date createdOn;
    Date updatedOn;
}
