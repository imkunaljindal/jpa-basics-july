package com.example.jpabasicsjuly;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody Student student){
        String response = studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }

    @GetMapping("/get_by_id")
    public ResponseEntity getStudentById(@RequestParam("rollNo") int rollNo){

        Student student = studentService.getStudentById(rollNo);
        if(student==null){
            return new ResponseEntity<>("Invalid Roll No",HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity(student,HttpStatus.FOUND);
    }


    // delete a student by roll no

    // update the age of a student based on roll no -> rollNo and age as input

    // find all the student who have age greater than 25

    // delete all the students

    // find all the student with a given name
}
