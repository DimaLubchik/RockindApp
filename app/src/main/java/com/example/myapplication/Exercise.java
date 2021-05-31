package com.example.myapplication;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/*
 Класс Упражнение.
 Поля
  1.Название (name)
  2.Описание (description)
  3.Сложность(difficulty)
  4.Изображение (Image)


 */
public class Exercise {
    public String name="";
    public String description="";
    public Integer difficulty=0;
    public int image=0;
    Exercise()
    { }
    public Exercise(String n, String desc, Integer diff, int img)
    {
        this.name=n;
        this.description=desc;
        this.difficulty=diff;
        this.image = img;
    }
        public void createCardForExercise(View card)
        {

            TextView name =card.findViewById(R.id.name);
            TextView desc =card.findViewById(R.id.description);
            TextView diff= card.findViewById(R.id.difficulty);
            ImageView image= card.findViewById(R.id.imageView_row2);
            diff.setText(Integer.toString(this.difficulty));
            desc.setText(this.description);
            name.setText(this.name);
            image.setImageResource(this.image);
        }
        public static Exercise setArmExersiceByName(String n)
        {

            Exercises temp =new Exercises();
            for(String bodyPart:temp.ArmsMuscles) {
                List<Exercise> ex = new ArrayList<>();
                ex = temp.Arms.get(bodyPart);
                for (int i = 0; i < ex.size(); i++) {
                    if (ex.get(i).name.equalsIgnoreCase(n))
                        return ex.get(i);
                }
            }

            return new Exercise("Отжимания узким хватом","примите положения лёжа",1000,R.drawable.razogrev);
        }


    }




