package com.sujay.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class GradeController {

    List<Grade> studentGrades = Arrays.asList(
            new Grade("sujay", "portions", "c-"),
             new Grade("sandyy", "portions", "c-"),
             new Grade("sujay", "portions", "c-")
    );
    @GetMapping("/grades")
    public String getGrades(Model model){
        model.addAttribute("grade",studentGrades);
        return "grades";
    }
}
