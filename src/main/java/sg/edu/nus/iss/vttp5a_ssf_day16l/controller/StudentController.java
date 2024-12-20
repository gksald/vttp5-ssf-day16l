package sg.edu.nus.iss.vttp5a_ssf_day16l.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sg.edu.nus.iss.vttp5a_ssf_day16l.model.Student;
import sg.edu.nus.iss.vttp5a_ssf_day16l.service.StudentRestService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    StudentRestService studentRestService;

    @GetMapping("")
    public String studentForm(Model model) {
        Student s = new Student();
        model.addAttribute("student", s);
        
        return "studentform";
    }
    
    @PostMapping("")
    public String postStudentForm(@ModelAttribute("student") Student entity, BindingResult result) {
        
        // if (result.hasErrors())
        //     return "studentform";
        System.out.println("postStudentForm: " + entity.toString());

    
        studentRestService.createStudent(entity);

        return "redirect:/students/list";
    }

    @GetMapping("/list")
    // @ResponseBody
    public String getMethodName(Model model) {
        List<Student> students = new ArrayList<>();
        students = studentRestService.getAllStudents();

        model.addAttribute("students", students);
        return "studentlist";
    }
    
    
    
}
