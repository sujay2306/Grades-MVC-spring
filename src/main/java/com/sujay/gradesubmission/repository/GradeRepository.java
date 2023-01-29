package com.sujay.gradesubmission.repository;

import com.sujay.gradesubmission.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradeRepository {
   private List<Grade> studentGrades = new ArrayList<>();
   public Grade getGrade(int index){
      return studentGrades.get(index);
   }
   public void addGrade(Grade grade){  //accepts a grade obj
      studentGrades.add(grade);
   }
   public void updateGrade(Grade grade,int index){
      studentGrades.set(index, grade);
   }

   public  List<Grade> getGrades(){
         return  studentGrades;
   }

}
