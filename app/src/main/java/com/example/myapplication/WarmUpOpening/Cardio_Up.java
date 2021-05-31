package com.example.myapplication.WarmUpOpening;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.myapplication.Exercise;
import com.example.myapplication.R;
import android.os.Bundle;
import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
public class Cardio_Up extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row2);
        Exercise ex = new Exercise("Кардио", "- Бег:\n" +
                "\n" +
                "Около 10 минут, бег на улице или по возможности на беговой дорожке.\n" +
                "\n" +
                "- Прыжки на скакалке:\n" +
                "\n" +
                "Около 2 минут интенисвного прыганья, или 150 раз.\n" +
                "\n" +
                "- Гребля:\n" +
                "\n" +
                "Проплыть около 700 метра, на средней сложности, не оставливаясь.\n", 15, R.drawable.kardio);
        ex.createCardForExercise(getWindow().getDecorView().getRootView());
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }


    }

