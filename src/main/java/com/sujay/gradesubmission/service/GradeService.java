package com.sujay.gradesubmission.service;
import com.sujay.gradesubmission.Constants;
import com.sujay.gradesubmission.Grade;
import com.sujay.gradesubmission.repository.GradeRepository;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GradeService {
    GradeRepository gradeRepository = new GradeRepository();

    public Grade getGrade(int index){
        return gradeRepository.getGrade(index);
    }
    public void addGrade(Grade grade){  //accepts a grade obj
        gradeRepository.addGrade(grade);
    }
    public void updateGrade(Grade grade,int index){
        gradeRepository.updateGrade(grade,index);
    }

    public  List<Grade> getGrades(){
        return  gradeRepository.getGrades();
    }
    public  int getGradeIndex(String id){
        for (int i=0; i< getGrades().size(); i++){
            if(getGrades().get(i).getId().equals(id)) return i;
        }
        return  Constants.NOT_FOUND;
    }
    public Grade getGradeById(String id){
        int index = getGradeIndex(id);
        return index == Constants.NOT_FOUND ? new Grade(): getGrade(index);
    }

    public  void submitGrade(Grade grade){
        int index = getGradeIndex(grade.getId());
        if(index == Constants.NOT_FOUND){
            addGrade(grade); //addGrade is a function call from repo
        }
        else{
            updateGrade(grade, index);// adds details which is submitted
        }
    }
}
