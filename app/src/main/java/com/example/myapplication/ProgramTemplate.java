package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.WarmUpOpening.Cardio_Up;
import com.example.myapplication.WarmUpOpening.Gymnastics_Up;
import com.example.myapplication.WarmUpOpening.Stretching_Up;
import com.example.myapplication.WarmUpOpening.Warming_Up_Muscles;

import java.util.ArrayList;
import java.util.List;

public class ProgramTemplate extends AppCompatActivity {

    android.widget.ListView ListView;





    static class MyAdapter extends ArrayAdapter<String> {

        Context context;
        TrainingProgram myProgram;

        MyAdapter (Context c,TrainingProgram tp) {

            super(c,R.layout.row, R.id.textView1, listToString(tp.exs));
            this.context = c;
            this.myProgram=tp;
        }
        public static  String[] listToString(List<Exercise> ex)
        {
            List<String> temp= new ArrayList<>();
            for(int i=0;i<ex.size();i++)
            {
                temp.add(ex.get(i).name);
            }
            String[] res =temp.toArray(new String[0]);
            return res;
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
            images.setImageResource(myProgram.exs.get(position).image);
            myTitle.setText(myProgram.exs.get(position).name);
            myDescription.setText("Нажмите, чтобы посмотреть упражнение");



            return row;
        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program_template);

        TextView workingMusclesText=findViewById(R.id.working_muscles);
        TextView timeText=findViewById(R.id.time_work);
        TextView structureText=findViewById(R.id.structure_work);

        ListView = findViewById(R.id.programs_listView);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        SharedPreferences save = getSharedPreferences("SAVE", MODE_PRIVATE);
        int currentLevel = save.getInt("Chest", 0);
        Exercises ex = new Exercises();
        TrainingProgram currentProgram = ex.ArmsProgramsByLevel.get(currentLevel);
        ProgramTemplate.MyAdapter adapter = new ProgramTemplate.MyAdapter(this,currentProgram);
        workingMusclesText.setText("Работающие мышцы:"+"\n"+currentProgram.workingMuscles);
        timeText.setText("Время на выполнение:"+"\n"+currentProgram.time);
        structureText.setText("Структура(кол-во серий,подходов,отдых):"+"\n"+currentProgram.structure);
        ListView.setAdapter(adapter);

        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent goal =new Intent(view.getContext(), TemplateExActivity.class);
                TextView name =view.findViewById(R.id.textView1);
                // TextView muscle = (TextView) listViewAdapter.getGroupView(groupPosition,true,null,parent);
                goal.putExtra("ourExercise",name.getText());
                //  goal.putExtra("ourBodyPart",muscle.getText());
                startActivity(goal);

            }
        });

        //В скобки должен передаваться текуший уровень для данной группы мышц

      /*  TextView name = findViewById(R.id.temp_Name);
        TextView diff = findViewById(R.id.temp_Dif);
        TextView desc = findViewById(R.id.temp_Description);
        name.setText(currentProgram.get(0).name);
        diff.setText(currentProgram.get(0).difficulty.toString());
        desc.setText(currentProgram.get(0).description);*/
    }



}