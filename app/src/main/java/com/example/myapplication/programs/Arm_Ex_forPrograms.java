package com.example.myapplication.programs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Exercises;
import com.example.myapplication.ExpandableListViewAdapter;
import com.example.myapplication.R;
import com.example.myapplication.TemplateExActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Arm_Ex_forPrograms extends AppCompatActivity {
    ExpandableListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> chapterList;
    HashMap<String,List<String>> topicsList;
    HashMap<String,List<Integer>> imagesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm__ex_for_programs);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        expandableListView=findViewById(R.id.eListView_2);

       // showList();
        Exercises ArmsTotal =new Exercises();
        listViewAdapter= new ExpandableListViewAdapter(this,ArmsTotal.ArmsMuscles,ArmsTotal.Arms);
        expandableListView.setAdapter(listViewAdapter);
        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View view, int groupPosition, int childPosition, long id) {
                Intent goal =new Intent(view.getContext(), TemplateExActivity.class);
                TextView name =view.findViewById(R.id.topics_tv);
               // TextView muscle = (TextView) listViewAdapter.getGroupView(groupPosition,true,null,parent);
                goal.putExtra("ourExercise",name.getText());
              //  goal.putExtra("ourBodyPart",muscle.getText());
                startActivity(goal);
                return false;
            }
        });

        ImageView images = findViewById(R.id.imageFor);

    }

}