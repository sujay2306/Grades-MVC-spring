package com.sujay.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> studentGrades = new ArrayList<>();
    @GetMapping("/")
    public String getForm(Model model){
        Grade grade = new Grade();
        model.addAttribute("grade", grade);
        return "form";
    }
    @PostMapping("/handleSubmit")
    public String submitForm(Grade grade){   //creats a object and uses our grades empty constructor and setters to update details
        studentGrades.add(grade); // adds details which is submitted
//        System.out.println(grade);
        return "grades"; //redirecting contents to grades browser will make get request to grades with model
    }
    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades",studentGrades);
        return "grades";
    }



}
