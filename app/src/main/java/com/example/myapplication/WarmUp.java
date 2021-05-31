package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

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

import com.example.myapplication.WarmUpOpening.Cardio_Up;
import com.example.myapplication.WarmUpOpening.Gymnastics_Up;
import com.example.myapplication.WarmUpOpening.Stretching_Up;
import com.example.myapplication.WarmUpOpening.Warming_Up_Muscles;

public class WarmUp extends AppCompatActivity {
    android.widget.ListView ListView;
    String mTitle[] = {"Разогрев мышц","Кардио","Растяжка","Гимнастика"};
    String mDescription[] = {"Важный этап тренировочного процесса,занимает 10-15 минут ","Нужно уделить от 5 до 20 минут бегу, велотренажеру, эллипсоиду.","Растяжка является частью разминки.","1-2 минуты упражнения на суставную гимнастику. "};
    int images[]= {R.drawable.razogrev, R.drawable.kardio,R.drawable.ractijka,R.drawable.gimnastika};
    //установка изображений в массив





    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String[] title, String[] description, int[] imgs) {
            super(c,R.layout.row, R.id.textView1, title);
            this.context = c;
            this. rTitle = title;
            this. rDescription= description;
            this.rImgs=imgs;


        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater= (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent, false);

            //присваивание фотографии в row массивом
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            //позиция по номеру массива
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);



            return row;
        }
    }



       @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_warm_up);

        ListView=findViewById(R.id.listView_1);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        MyAdapter adapter = new MyAdapter(this,mTitle, mDescription,images );
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    Toast.makeText(view.getContext(), "Приступим к разогреву мышц", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Warming_Up_Muscles.class);
                    startActivity(intent);
                }
                if (position == 1) {
                    Toast.makeText(view.getContext(), "Приступим к кардио разминка", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Cardio_Up.class);
                    startActivity(intent);
                }
                if (position == 2) {
                    Toast.makeText(view.getContext(), "Приступим к растяжке", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Stretching_Up.class);
                    startActivity(intent);
                }
                if (position == 3) {
                    Toast.makeText(view.getContext(), "Приступим к гимнастической разминке", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(), Gymnastics_Up.class);
                    startActivity(intent);
                }
            }
        });


    }
}