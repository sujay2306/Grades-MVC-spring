package com.sujay.gradesubmission.controller;

import com.sujay.gradesubmission.Constants;
import com.sujay.gradesubmission.Grade;
import com.sujay.gradesubmission.repository.GradeRepository;
import jakarta.validation.Valid;
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

    GradeRepository gradeRepository = new GradeRepository();
    @GetMapping("/")
    public String getForm(Model model , @RequestParam(required = false) String id){
        int index = getGradeIndex(id);
        model.addAttribute("grade", index == Constants.NOT_FOUND ? new Grade(): studentGrades.get(index));
        return "form";
    }

    @PostMapping("/handleSubmit")
    public String submitForm(@Valid Grade grade , BindingResult result){   //creats a object and uses our grades empty constructor and setters to update details
        System.out.println("has errors?: " + result.hasErrors());
        if(result.hasErrors()){
            return "form";
        }
       int index = getGradeIndex(grade.getId());
       if(index == Constants.NOT_FOUND){
           studentGrades.add(grade);
       }
       else{
           studentGrades.set(index,grade);// adds details which is submitted
       }
        return "redirect:/grades";
    }
    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grades",studentGrades);
        return "grades";
    }



    public Integer getGradeIndex(String id){
        for (int i=0; i< studentGrades.size(); i++){
            if(studentGrades.get(i).getId().equals(id)) return i;
        }
        return  Constants.NOT_FOUND;
    }

}
