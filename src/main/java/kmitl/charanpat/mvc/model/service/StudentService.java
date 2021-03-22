package kmitl.charanpat.mvc.model.service;

import kmitl.charanpat.mvc.model.dto.StudentDTO;
import kmitl.charanpat.mvc.model.entity.Student;
import kmitl.charanpat.mvc.model.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository repository;

    public List<StudentDTO>listAll(){
        List<Student> students = repository.findTop10();
        List<StudentDTO> res = new ArrayList<>();
        for(Student studentloopset : students){
            StudentDTO studentsSet = new StudentDTO();
            studentsSet.setStudentId(studentloopset.getStudent_id());
            studentsSet.setTemperature(String.valueOf(studentloopset.getTemperature())+" C");
            res.add(studentsSet);
        }
        return res;
    }

    public void saveStudent(Student student){
        student.setSick("Not Recive");
        repository.save(student);
    }
    public Student getRunner(long id){
        return repository.findById(id).get();
    }
}
