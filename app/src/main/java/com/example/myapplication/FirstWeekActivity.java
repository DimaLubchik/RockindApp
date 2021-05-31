package com.example.myapplication;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class FirstWeekActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_week);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        createChestProgram();



        createEnduranceProgram();
        createAbsProgram();
        createCoreProgram();
        createLegsProgram();
    }
    public void createChestProgram()
    {
        SharedPreferences save= getSharedPreferences("SAVE",0);
        String ChestEx= save.getStringSet("Chest", new HashSet<String>()).toString();
        ChestEx=ChestEx.substring(1,ChestEx.length()-1);
        List<String> ChestList= Arrays.asList(ChestEx.split(","));
        TextView text=findViewById(R.id.Chest);
        String res="";
        for(int i=0;i<ChestList.size();i++)
        {
            res+=ChestList.get(i)+ " ";
        }
        text.setText(res);
    }
    public void createEnduranceProgram()
    {
        SharedPreferences save= getSharedPreferences("SAVE",0);
        String EnduranceEx= save.getStringSet("Endurance", new HashSet<String>()).toString();
        EnduranceEx=EnduranceEx.substring(1,EnduranceEx.length()-1);
        List<String> EnduranceList= Arrays.asList(EnduranceEx.split(","));
        TextView text=findViewById(R.id.Endurance);
        String res="";
        for(int i=0;i<EnduranceList.size();i++)
        {
            res+=EnduranceList.get(i)+ " ";
        }
        text.setText(res);
    }
    public void createAbsProgram()
    {
        SharedPreferences save= getSharedPreferences("SAVE",0);
        String AbsEx= save.getStringSet("Abs", new HashSet<String>()).toString();
        AbsEx=AbsEx.substring(1,AbsEx.length()-1);
        List<String> AbsList= Arrays.asList(AbsEx.split(","));
        TextView text=findViewById(R.id.Abs);
        String res="";
        for(int i=0;i<AbsList.size();i++)
        {
            res+=AbsList.get(i)+ " ";
        }
        text.setText(res);
    }
    public void createCoreProgram()
    {
        SharedPreferences save= getSharedPreferences("SAVE",0);
        String CoreEx= save.getStringSet("Core", new HashSet<String>()).toString();
        CoreEx=CoreEx.substring(1,CoreEx.length()-1);
        List<String> CoreList= Arrays.asList(CoreEx.split(","));
        TextView text=findViewById(R.id.Core);
        String res="";
        for(int i=0;i<CoreList.size();i++)
        {
            res+=CoreList.get(i)+ " ";
        }
        text.setText(res);

    }
    public void createLegsProgram()
    {
        SharedPreferences save= getSharedPreferences("SAVE",0);
        String LegsEx= save.getStringSet("Legs", new HashSet<String>()).toString();
        LegsEx=LegsEx.substring(1,LegsEx.length()-1);
        List<String> LegsList= Arrays.asList(LegsEx.split(","));
        TextView text=findViewById(R.id.Legs);
        String res="";
        for(int i=0;i<LegsList.size();i++)
        {
            res+=LegsList.get(i)+ " ";
        }
        text.setText(res);

    }


}