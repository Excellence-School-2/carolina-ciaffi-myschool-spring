package it.nttdata.myschool.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import it.nttdata.myschool.entity.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

    //Metodo per realizzare la Quey in formato JPA
    //STudent è il nome della classe da cui deriva la tabella (quindi lettera maiuscola)
    @Query("SELECT s FROM Student s WHERE s.schoolClass.section= :section")
    public Collection<Student> findStudentByClass(@Param("section") String section);
    //froniamo a spring una query 
    //Spring JPS sa implementare il metodo dichiarato 
}
