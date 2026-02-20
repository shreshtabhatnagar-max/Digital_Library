package org.gfg.Digital_Library.response;

import lombok.Data;

@Data
public class StudentCreationResponse extends Response{
private int id;
private String name;
private String email;

}
