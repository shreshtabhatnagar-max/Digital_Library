package org.gfg.Digital_Library.controller;

import jakarta.validation.Valid;
import org.gfg.Digital_Library.request.StudentCreationRequest;
import org.gfg.Digital_Library.response.Response;
import org.gfg.Digital_Library.response.StudentCreationResponse;
import org.gfg.Digital_Library.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    Studentservice studentservice;



    @PostMapping("/create/student")
    public ResponseEntity<StudentCreationResponse> createstudent(@Valid @RequestBody StudentCreationRequest studentCreationRequest) {
        if (studentCreationRequest == null) {
            StudentCreationResponse response = new StudentCreationResponse();
            response.setStatus("Invalid request");
            response.setMessage("Request is invalid");
            return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
        }
StudentCreationResponse studentCreationResponse=studentservice.createstudent(studentCreationRequest);
        return new ResponseEntity<>(studentCreationResponse,HttpStatus.OK);
    }
}
