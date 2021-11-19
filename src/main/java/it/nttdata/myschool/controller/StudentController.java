package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import it.nttdata.myschool.repository.StudentRepository;

@Controller
public class StudentController {
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository){
        this.studentRepository=studentRepository;
    }

    //preleviamo i repository e le inseriamo nel modello
     //RequestMapping di tipo get
     @GetMapping("/students")
     public String getStudent(Model model){//per mandare le informazione dal database all'html utilizziamo il Model
         model.addAttribute("students", studentRepository.findAll());//chiave="students" valore 
             //recuperiamo i dati dal database
        model.addAttribute("title", "My School Students ");
         return "studentlist";
     }

     @GetMapping("/students/{section}")
    public String getStudentByClass(Model model, @PathVariable String section){
        model.addAttribute("students",  studentRepository.findStudentByClass(section));
        model.addAttribute("title",  section + " Students");
       //il metodo findStudentByClass è dichiarato in StudentRepositor
    return "studentlist";
    }
     
}
