package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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


public class MyProgramsFragment extends Fragment {

    android.widget.ListView ListView;
    String mTitle[] = {"Разминка","Грудные мышцы","Legs","Neck","Back"};
    String mDescription[] = {"Уделить 20 минут до тренировки", "Комплекс тренировок грудных мышц", "Legs Description", "Neck Description", "Back Description"};
    int images[]= {R.drawable.activi_razminka, R.drawable.intro_chest, R.drawable.legs, R.drawable.neck, R.drawable.back};
    //установка изображений в массив





    static class MyAdapter extends ArrayAdapter<String> {

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
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v= inflater.inflate(R.layout.fragment_my_programs, container, false);
        ListView ListView=v.findViewById(R.id.listView);

        MyProgramsFragment.MyAdapter adapter = new MyProgramsFragment.MyAdapter(getContext(),mTitle, mDescription,images );
        ListView.setAdapter(adapter);

        //setClick on list view
        ListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    Toast.makeText(view.getContext(), "Разминка", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(),WarmUp.class);
                    startActivity(intent);
                }
                if (position == 1){
                    Toast.makeText(view.getContext(), "Arms Description", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(view.getContext(),ProgramTemplate.class);
                    startActivity(intent);
                }
                if (position == 2){
                    Toast.makeText(view.getContext(), "Legs Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 3){
                    Toast.makeText(view.getContext(), "Neck Description", Toast.LENGTH_SHORT).show();
                }
                if (position == 4){
                    Toast.makeText(view.getContext(), "Back Description", Toast.LENGTH_SHORT).show();
                }
            }

        });
        // Inflate the layout for this fragment
        return v;
    }
}