package kmitl.charanpat.mvc.controller;

import kmitl.charanpat.mvc.model.dto.StudentDTO;
import kmitl.charanpat.mvc.model.entity.Student;
import kmitl.charanpat.mvc.model.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class StudentConroller {
    @Autowired
    StudentService service;
    @RequestMapping("/")
    public String viewHomePage(Model model){
        List<StudentDTO> listStudent = service.listAll();
        model.addAttribute("listStudent",listStudent);
        return "index";
    }
    @PostMapping("/register")
    public String saveNewRunner(@ModelAttribute("student") Student student, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "register";
        }
        service.saveStudent(student);
        return "redirect:/";
    }
    @RequestMapping("/register/{id}")
    public ModelAndView showEditRunner(@PathVariable(name = "id")long id){
        ModelAndView mav = new ModelAndView("editLecturer");
        Student student = service.getRunner(id);
        mav.addObject("runner", student);
        return mav;
    }
    @GetMapping("/register")
    public String showNewLecturer(Model model){
        Student lecturer = new Student();
        model.addAttribute("runner",lecturer);
        return "register";
    }
}
