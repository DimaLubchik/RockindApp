package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import java.io.Console;
import java.security.acl.Group;
import java.util.LinkedHashSet;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.Set;

public class TestActivity extends AppCompatActivity {
    LinkedHashSet<String> answers=new LinkedHashSet<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_osn);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void onCLickAnswerButton(View view) {
            answersHandler();;
            Context context;
            context=this;
            Intent goal = new Intent(context, SecondWeekActivity.class);
            startActivity(goal);

    }
    public void answersHandler() {
        int N = 5;
        int [] Groups=new int[N];
        Groups[0]=(R.id.answer1);
        Groups[1]=(R.id.answer2);
        Groups[2]=(R.id.answer3);
        Groups[3]=(R.id.answer4);
        Groups[4]=(R.id.answer5);
        for (int i = 0; i <N; i++) {
            RadioGroup test= findViewById(Groups[i]);
            int resultId =test.getCheckedRadioButtonId();
            RadioButton answer=findViewById(resultId);
            String resultText= answer.getResources().getResourceEntryName(resultId);
            answers.add(resultText);
            System.out.println(resultText);
        }
        SharedPreferences save = getSharedPreferences("SAVE",0);
        SharedPreferences.Editor editor = save.edit();
        String msg=answers.toString();
        editor.putString("results",msg);
        editor.putBoolean("testCheck",true);
        Init.firstTestDoneCheck = true;
        editor.commit();
        answers.clear();
    }
}