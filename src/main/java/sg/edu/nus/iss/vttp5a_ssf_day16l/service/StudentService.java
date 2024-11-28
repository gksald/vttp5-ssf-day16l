package sg.edu.nus.iss.vttp5a_ssf_day16l.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.vttp5a_ssf_day16l.model.Student;
import sg.edu.nus.iss.vttp5a_ssf_day16l.repository.ListRepo;

@Service
public class StudentService {
    
    @Autowired
    ListRepo studentRepo;

    // write your CRUD functions here
    public void add(Student student) {
        studentRepo.rightPush("students", student.toString()); 
    }
    
    public List<Student> findAll(String redisKey) {
        List<String> students = studentRepo.getList(redisKey);

        // i don't know how to do here. please use JSON-P to cast to list of students

        
        return null;
    }

}
