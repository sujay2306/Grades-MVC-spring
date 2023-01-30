package com.sujay.gradesubmission.controller;

import com.sujay.gradesubmission.Constants;
import com.sujay.gradesubmission.Grade;
import com.sujay.gradesubmission.repository.GradeRepository;
import com.sujay.gradesubmission.service.GradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.naming.Binding;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {
    @Autowired
    GradeService gradeService;
    @GetMapping("/")
    public String getForm(Model model , @RequestParam(required = false) String id){
        model.addAttribute("grade", gradeService.getGradeById(id));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade , BindingResult result){   //creats a object and uses our grades empty constructor and setters to update details
        System.out.println("has errors?: " + result.hasErrors());
        if(result.hasErrors()){
            return "form";
        }
        gradeService.submitGrade(grade);
        return "redirect:/grades";
    }
    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades",gradeService.getGrades());
        return "grades";
    }

}
