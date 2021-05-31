package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.programs.Arm_Ex_forPrograms;
import com.example.myapplication.programs.Back_Ex_forPrograms;
import com.example.myapplication.programs.Endurance_Ex_forPrograms;
import com.example.myapplication.programs.Legs_Ex_forPrograms;
import com.example.myapplication.programs.Press_Ex_forPrograms;
import com.google.android.material.tabs.TabLayout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class SecondWeekActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FragmentManager myManager;
    private long backPressedTime;
    private Toast backToast;
    ImageButton button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_week);
        checkTestResults();
        ImageButton FragmentOneButton= (ImageButton)findViewById(R.id.button1);
        ImageButton FragmentTwoButton= (ImageButton)findViewById(R.id.button2);
        ImageButton FragmentThreeButton= (ImageButton) findViewById(R.id.button3);






        FrameLayout f=findViewById(R.id.fragment_place);
        Fragment defaultFragment=new MyProgramsFragment();
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment_place, defaultFragment);
        ft.commit();


    }
    public void checkTestResults()
    {   String temp;
        String[] answersForPrograms;
        SharedPreferences save= getSharedPreferences("SAVE",MODE_PRIVATE);
        SharedPreferences.Editor editor = save.edit();
        editor.putString("MyKey","ffff");
        temp=  save.getString("results","");
        try {


            String s = temp.toString();
            s = s.substring(1, s.length() - 1);
            answersForPrograms = s.split(",");
            List<Integer> Levels= new LinkedList<>();

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
         catch (Exception e) {
             e.printStackTrace();
         }

        // обработка ответов, и передача в програмс активити -конец







    }
    public void  onClickFragmentsButtons(View view){
        Fragment currentFragment = null;
        if(view.getId()==R.id.button1)
        {
            currentFragment=new MyProgramsFragment();
        }
        if(view.getId()==R.id.button2)
        {
            currentFragment=new ExLibraryFragment();
        }
        if (view.getId()==R.id.button3)
        {
            currentFragment=new ProfileFragment();
        }
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment_place, currentFragment);
        ft.commit();
    }

    @Override
    public void onBackPressed() {

        if (backPressedTime + 2000 > System.currentTimeMillis())
        {
            backToast.cancel();
            super.onBackPressed();
            return;
        }
        else{
            backToast=Toast.makeText(getBaseContext(),"Нажмите ещё раз, чтобы выйти", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();
    }

    public void onClickPressButton(View view)
    {
        Intent goal =new Intent(this, Press_Ex_forPrograms.class);
        startActivity(goal);
    }
    public void onClickArmButton(View view)
    {
        Intent goal =new Intent(this, Arm_Ex_forPrograms.class);
        startActivity(goal);
    }
    public void onClickLegsButton(View view)
    {
        Intent goal =new Intent(this, Legs_Ex_forPrograms.class);
        startActivity(goal);
    }
    public void onClickBackButton(View view)
    {
        Intent goal =new Intent(this, Back_Ex_forPrograms.class);
        startActivity(goal);
    }
    public void onClickEnduranceButton(View view)
    {
        Intent goal =new Intent(this, Endurance_Ex_forPrograms.class);
        startActivity(goal);
    }
}



