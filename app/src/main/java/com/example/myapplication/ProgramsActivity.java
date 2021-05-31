package com.example.myapplication;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.myapplication.Exercises;

public class ProgramsActivity extends AppCompatActivity {
   String temp;
   String[] answersForPrograms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        SharedPreferences save= getSharedPreferences("SAVE",0);
        SharedPreferences.Editor editor = save.edit();
        temp=  save.getString("results","");
        String s=temp.toString();
        s=s.substring(1,s.length()-1);
        answersForPrograms=s.split(",");
         // обработка ответов, и передача в програмс активити -конец


        List <Integer> Levels= new LinkedList<>();

        List<String> MuscleGroups= new LinkedList<>();
        MuscleGroups.add("Chest");
        MuscleGroups.add("Endurance");
        MuscleGroups.add("Abs");
        MuscleGroups.add("Core");
        MuscleGroups.add("Legs");



        for(int i=0;i<answersForPrograms.length;i++) {
            Integer el = Integer.parseInt(answersForPrograms[i].substring(answersForPrograms[i].length() - 1));//Взятие последнего элемента первого ответа и преобразование в интеджер
            Levels.add(el);
            System.out.println(el);

        }
        List<Integer> numOfEx=new LinkedList<>();//Количество упражнений на каждую группу
        for(int i=0;i<Levels.size();i++)
        {
            String currentMuscleGroup=MuscleGroups.get(i);

            int currentLevel=Levels.get(i);
            editor.putInt(currentMuscleGroup,currentLevel);

            editor.commit();
        }



    }
}






