package com.sujay.gradesubmission.repository;

import com.sujay.gradesubmission.Grade;

import java.util.ArrayList;
import java.util.List;

public class GradeRepository {
   private List<Grade> studentGrades = new ArrayList<>();
   public Grade getGrade(int index){
      return studentGrades.get(index)
   }
}
