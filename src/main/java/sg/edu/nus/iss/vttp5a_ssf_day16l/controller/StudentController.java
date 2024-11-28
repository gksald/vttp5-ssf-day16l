package sg.edu.nus.iss.vttp5a_ssf_day16l.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import sg.edu.nus.iss.vttp5a_ssf_day16l.model.Student;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("/students")
public class StudentController {

    @GetMapping("")
    public String studentForm(Model model) {
        Student s = new Student();
        model.addAttribute("student", s);
        
        return "studentform";
    }
    
    @PostMapping("")
    public String postStudentForm(@ModelAttribute Student entity) {
        
        return "redirect:/students/list";
    }

    @GetMapping("/list")
    public String getMethodName(@RequestParam String param) {
        return "studentlist";
    }
    
    
    
}
