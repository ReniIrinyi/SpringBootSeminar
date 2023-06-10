package restcrudapi.demo.rest;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import restcrudapi.demo.entity.Student;

import java.util.ArrayList;
import java.util.List;

@RestController

@RequestMapping("/api")
public class StudentRestController {
       private List <Student> students;
       @PostConstruct
       public void loadData(){
               Student student1 =new Student("Hala", "Mala");
               Student student2 =new Student("Hala", "Malam");
               Student student3 =new Student("Hala", "Malamm");

               students=new ArrayList<>();
               students.add(student1);
               students.add(student2);
               students.add(student3);
       }
        @GetMapping("/students")
        public List<Student> getStudents(){
        return students;
    }

    @GetMapping("/students/{studentId}")
        public Student getStudent(@PathVariable int studentId){

           if(studentId >= students.size() || studentId < 0){
               throw new StudentNotFoundException("Student id: "+ studentId+" not found");
           }
                return students.get(studentId);
    }


}




