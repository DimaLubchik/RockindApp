package com.example.myapplication.programs;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ExpandableListView;
import android.widget.ImageView;

import com.example.myapplication.ExpandableListViewAdapter;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Press_Ex_forPrograms extends AppCompatActivity {
    ExpandableListViewAdapter listViewAdapter;
    ExpandableListView expandableListView;
    List<String> chapterList;
    HashMap<String,List<String>> topicsList;
    HashMap<String,List<Integer>> imagesList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_press__ex_for_programs);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        expandableListView=findViewById(R.id.eListView);
        showList();
       // listViewAdapter= new ExpandableListViewAdapter(this,chapterList,topicsList,imagesList);
        expandableListView.setAdapter(listViewAdapter);

        ImageView images = findViewById(R.id.imageFor);
    }




private void showList() {
        chapterList = new ArrayList<String>();
        topicsList= new HashMap<String, List<String>>();
        imagesList = new HashMap<String, List<Integer>>();
        chapterList.add("Chapter 1");
        chapterList.add("Chapter 2");
        chapterList.add("Chapter 3");
        chapterList.add("Chapter 4");
        chapterList.add("Chapter 5");

        List<String> topic1=new ArrayList<>();
        topic1.add("Topic 1");
        topic1.add("Topic 2");
        topic1.add("Topic 3");

        List<String> topic2=new ArrayList<>();
        topic2.add("Topic 1");
        topic2.add("Topic 2");
        topic2.add("Topic 3");

        List<String> topic3=new ArrayList<>();
        topic3.add("Topic 1");
        topic3.add("Topic 2");
        topic3.add("Topic 3");

        List<String> topic4=new ArrayList<>();
        topic4.add("Topic 1");
        topic4.add("Topic 2");
        topic4.add("Topic 3");

        List<String> topic5=new ArrayList<>();
        topic5.add("Topic 1");
        topic5.add("Topic 2");
        topic5.add("Topic 3");

        List<Integer> image1=new ArrayList<>();
        image1.add(R.drawable.back);
        image1.add(R.drawable.neck);
        image1.add(R.drawable.press);

        List<Integer> image2=new ArrayList<>();
        image2.add(R.drawable.ryki);
        image2.add(R.drawable.back1);
        image2.add(R.drawable.legs);
        // topic1.get(images(R.drawable.arms));
        topicsList.put(chapterList.get(0),topic1);
        topicsList.put(chapterList.get(1),topic2);
        topicsList.put(chapterList.get(2),topic3);
        topicsList.put(chapterList.get(3),topic4);
        topicsList.put(chapterList.get(4),topic5);

        imagesList.put(chapterList.get(0), image1);
        imagesList.put(chapterList.get(1), image2);
        imagesList.put(chapterList.get(2), image1);
        imagesList.put(chapterList.get(3), image2);
        imagesList.put(chapterList.get(4), image2);
        }
}


