package at.hakimst.Studentenverwaltung.Controler;


import at.hakimst.Studentenverwaltung.Domain.Student;
import at.hakimst.Studentenverwaltung.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class MyWebController {

    StudentService studentService;

    public MyWebController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/web/allstudents")
    public ModelAndView allstudents() {
        List<Student> alleStudis = studentService.gibAlleStudenten();
        return new ModelAndView("allstudents", "studenten", alleStudis);
    }

    @GetMapping("/web/insertstudentform")
    public ModelAndView insertstudentform() {
        return new ModelAndView("insertstudentform", "mystudent", new Student());
    }

    @GetMapping("/web/deletestudent/{id}")
    public View deleteStudentWithId(@PathVariable Long id) {
        this.studentService.studentLoeschen(id);
        return new RedirectView("/web/allstudents");
    }

    @PostMapping("/web/insertstudent")
    public String insertStudent(@Valid @ModelAttribute("mystudent") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "insertstudentform";
        } else {

            this.studentService.studentEinfuegen(student);
            return "redirect:/web/allstudents";
        }
    }

}
