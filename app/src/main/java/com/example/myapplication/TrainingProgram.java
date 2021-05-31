package com.example.myapplication;

import java.util.List;

public class TrainingProgram {
    public String workingMuscles = "";
    public String time="";
    public String structure="";
    public List<Exercise> exs;
    TrainingProgram(){}
    TrainingProgram(String wm,String tm,String str,List<Exercise> e){
        this.workingMuscles = wm;
        this.time=tm;
        this.structure=str;
        this.exs=e;
    }
}

