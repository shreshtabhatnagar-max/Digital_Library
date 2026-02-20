package org.gfg.Digital_Library.service;

import org.gfg.Digital_Library.model.Address;
import org.gfg.Digital_Library.model.Student;
import org.gfg.Digital_Library.model.Studentstatus;
import org.gfg.Digital_Library.repository.Studentrepository;
import org.gfg.Digital_Library.request.StudentCreationRequest;
import org.gfg.Digital_Library.response.StudentCreationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Studentservice {
    @Autowired
    Studentrepository studentrepository;

    public StudentCreationResponse createstudent(StudentCreationRequest studentCreationRequest) {
        String name = studentCreationRequest.getName();
        String email = studentCreationRequest.getEmail();
        String dob = studentCreationRequest.getDob();
        String mobno = studentCreationRequest.getMobileNo();
        Address address = studentCreationRequest.getAddress();
        Student student = Student.builder().name(name).email(email).dob(dob).mobileNo(mobno).address(address).build();
        student.setStudentstatus(Studentstatus.ACTIVE);

        int rowupdated = 0;

        try {
             rowupdated = studentrepository.CreateStudentInDatabase(student);
        } catch (Exception ex) {
            System.out.println("Exception" + ex);
            rowupdated = 0;
        }

        StudentCreationResponse studentCreationResponse = new StudentCreationResponse();
        studentCreationResponse.setName(name);
        studentCreationResponse.setEmail(email);


        if (rowupdated == 0) {
            studentCreationResponse = new StudentCreationResponse();
            studentCreationResponse.setStatus("Failed");
            studentCreationResponse.setMessage("Data Not Insert");
            return studentCreationResponse;
        }
        studentCreationResponse.setStatus("Sucess");
        studentCreationResponse.setMessage("Data  Inserted Sucessfully");
        return studentCreationResponse;

    }
}
