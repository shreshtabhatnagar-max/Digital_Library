package org.gfg.Digital_Library.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.gfg.Digital_Library.Annotation.ValidAge;
import org.gfg.Digital_Library.model.Address;
import org.gfg.Digital_Library.model.Student;
import org.hibernate.validator.constraints.Length;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StudentCreationRequest {
    @NotNull
    @Length(min = 6, max = 10)
    private String name;
    @NotNull
    private String email;
    @NotNull
    private String mobileNo;
    @NotNull
    Address address;
    @ValidAge
    private String dob;

}
