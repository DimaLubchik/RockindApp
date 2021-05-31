package com.example.myapplication;
import com.example.myapplication.Init;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Layout;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.content.DialogInterface;
import android.widget.Toast;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    private long backPressedTime;
    private Toast backToast;
    private TextView myText;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        SharedPreferences save = getSharedPreferences("SAVE",0);
        setContentView(R.layout.activity_main);


        //-верхняя панель
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //-конец

    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences save = getSharedPreferences("SAVE",0);
        if(Init.firstTestDoneCheck==true)
        {
            View m= findViewById(R.id.test_button);
            m.setVisibility(View.INVISIBLE);
        }

    }

    public void onClickTestButton(View view)
    {

        AlertDialog.Builder a_builder =new AlertDialog.Builder(MainActivity.this);
        a_builder.setMessage("Перед прохождением теста, внимательно прочитайте инструкцию.")
                .setCancelable(false)
                .setPositiveButton("Продолжить", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        Intent goal = new Intent(getApplicationContext(), TutorialActivity.class);
                        startActivity(goal);
                    }
                });
        AlertDialog TestButton = a_builder.create();
        TestButton.setTitle("Ознакомьтесь перед переходом");
        TestButton.show();

    }
    public void onClickProgramsButton(View view)
    {

        if(Init.firstTestDoneCheck==true) {
            Intent goal = new Intent(this, ProgramsActivity.class);
            startActivity(goal);
        }
        else {
        //Выдать уведомление, что тест еще не пройден, и мы не можем нажать на мои программы
            AlertDialog.Builder a_builder =new AlertDialog.Builder(MainActivity.this);
            a_builder.setMessage("Вы ещё не прошли тест")
                    .setCancelable(false)
                    .setPositiveButton("Закрыть", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
            AlertDialog mainMessage = a_builder.create();
            mainMessage.setTitle("Ознакомьтесь перед переходом");
            mainMessage.show();
        }
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
}