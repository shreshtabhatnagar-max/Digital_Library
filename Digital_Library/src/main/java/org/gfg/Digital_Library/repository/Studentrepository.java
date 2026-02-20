package org.gfg.Digital_Library.repository;

import org.gfg.Digital_Library.model.Address;
import org.gfg.Digital_Library.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Date;

@Repository

public class Studentrepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

  private   SimpleJdbcInsert jdbcInsert;



@Autowired
  Studentrepository(DataSource dataSource) {
    this.jdbcInsert =new SimpleJdbcInsert(dataSource).withTableName("Student").usingGeneratedKeyColumns("id");
   // jdbcInsert.withTableName("Student");
    //jdbcInsert.usingGeneratedKeyColumns("id");
    }

    public int CreateStudentInDatabase(Student student) {
        /*jdbcTemplate.update("INSERT INTO Student(name,email,mobil,status,createdOn,updatedOn) VALUES (?,?,?,?,?,?)",student.getName(),

                student.getEmail(),student.getMobileNo(),student.getStudentstatus(),new Date(),new Date());*/
        MapSqlParameterSource mapSqlParameterSource = new MapSqlParameterSource();
        mapSqlParameterSource.addValue("name", student.getName());
        mapSqlParameterSource.addValue("email", student.getEmail());
        mapSqlParameterSource.addValue("dob",student.getDob());
        mapSqlParameterSource.addValue("mobile", student.getMobileNo());
        mapSqlParameterSource.addValue("status", student.getStudentstatus());
        mapSqlParameterSource.addValue("createdOn", new Date());
        mapSqlParameterSource.addValue("updatedOn", new Date());
        //mapSqlParameterSource.addValue("name",student.getName());
        Number number = jdbcInsert.executeAndReturnKey(mapSqlParameterSource);
        int studentId = number.intValue();

        System.out.println("Student Data  Inserted");
        Address address = student.getAddress();
        int ar = jdbcTemplate.update("INSERT INTO Address(studentid , street, city,pincode) VALUES (?,?,?,?)", studentId, address.getStreet(), address.getCity(), address.getPincode());
        System.out.println("Rows Updated For address" + ar);
        return ar;
    }

}
