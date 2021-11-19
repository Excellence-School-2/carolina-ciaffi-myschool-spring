package it.nttdata.myschool.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import it.nttdata.myschool.entity.Student;
import it.nttdata.myschool.repository.StudentRepository;

@RestController
public class StudentRestController {

    StudentRepository studentRepository;

    public StudentRestController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    
    @GetMapping("api/v0/students")
    public Iterable<Student> getStudents(){
       // List<Student> students =new ArrayList<>();
        return studentRepository.findAll();  //forEach(students::add);

    }
    

    @GetMapping("/api/v0/students/{id}")
    public Student getStudent(@PathVariable Long id){
        return studentRepository.findById(id).get(); //ci trona un oggetto optional che dobbiamo gestire, quindi metto
        //.get() e mi ritorna uno Student

        
    }

    
}

