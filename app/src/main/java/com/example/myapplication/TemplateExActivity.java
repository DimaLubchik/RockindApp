package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class TemplateExActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.row2);
        TextView workMus= findViewById(R.id.working_muscles);
        TextView time = findViewById(R.id.time_work);
        TextView structure=findViewById(R.id.structure_work);
        Bundle bundle = getIntent().getExtras();
        Exercise temp =Exercise.setArmExersiceByName(bundle.getString("ourExercise"));
        Exercise ex = new Exercise(temp.name,temp.description,temp.difficulty,temp.image);
        ex.createCardForExercise(getWindow().getDecorView().getRootView());



    }
}