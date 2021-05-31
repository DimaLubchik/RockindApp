package com.example.myapplication.WarmUpOpening;

import androidx.appcompat.app.AppCompatActivity;

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

public class Warming_Up_Muscles extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.row2);
        Exercise ex = new Exercise("Разогрев мышц", "- Вращательные движения руками:\n" +
                "\n" +
                "Встаньте прямо, выпрямите руки, а затем сделайте вращательные движения в плечевых суставах. Сначала 10-15 раз назад, затем столько же вперед\n" +
                "\n" +
                "- Вращательные движения в локтях:\n" +
                "\n" +
                "Расставьте руки в стороны и вращайте предплечья сначала в одну сторону, затем в другую.\n" +
                "\n" +
                "- Вращательные движения головой:\n" +
                "\n" +
                "Расслабьте плечи, затем вращайте головой по кругу – сначала по часовой стрелке, потом против часовой стрелки.\n" +
                "\n" +
                "- Вращения в коленном суставе:\n" +
                "\n" +
                "Встаньте прямо, поднимите одну ногу таким образом, чтобы колено было параллельно полу. Вращайте голень сначала в одну сторону, затем в другую, после чего поменяйте ноги.\n" +
                "\n" +
                "- Повороты корпуса:\n" +
                "\n" +
                "Встаньте прямо, сцепите руки в замок перед грудью и поочередно поворачивайте корпус сначала влево, потом вправо. Все повороты делайте медленно, плавно.\n" +
                "\n" +
                "- Приседания.", 7, R.drawable.razogrev);
        createCardForExercise(ex);
        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public  void createCardForExercise(Exercise ex) {

        try {


            ImageView img = findViewById(R.id.imageView_row2);
            img.setImageResource(ex.image);
            TextView name = findViewById(R.id.name);
            TextView diff =findViewById(R.id.difficulty);
            TextView desc = findViewById(R.id.description);
            name.setText(ex.name);
            diff.setText("Уделить: "+Integer.toString(ex.difficulty) + " - 10 минут");
            desc.setText(ex.description);
        }
        catch (Exception e) {
            System.out.println("Error");
        }
    }
}