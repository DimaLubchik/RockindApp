package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;


public class ProfileFragment extends Fragment {

   // объект, который берет строку, разбирает ее на составляющие и хранит в себе эту информацию

    TextView textView_name,textView_age;
    Button button_logout;
    CircleImageView circleImageView;

    private static final  String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, container, false);
        SharedPreferences save = getContext().getSharedPreferences("SAVE", 0);
        final  Uri imageUri=Uri.parse(save.getString("profile_image",""));

        textView_name= (TextView)v.findViewById(R.id.text_fullname);
        button_logout= (Button) v.findViewById(R.id.button_logout);
        circleImageView = (CircleImageView) v.findViewById(R.id.Profile_Image_main);
        final InputStream imageStream;
        try {
            imageStream = getContext().getContentResolver().openInputStream(imageUri);
            final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
            circleImageView.setImageBitmap(selectedImage);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        save= this.getActivity().getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);

        String name = save.getString(KEY_NAME,null);
        if (name != null){
            textView_name.setText(name);

        }

        //Bitmap bitmap = (Bitmap) intent.getParcelableExtra("BitmapImage");

        button_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences save = getContext().getSharedPreferences("SAVE", 0);
                SharedPreferences.Editor editor = save.edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getActivity(),"Log out",Toast.LENGTH_SHORT).show();
                //getActivity().finish();
                Intent intent =new Intent(ProfileFragment.this.getActivity(),selectNameFoto.class);
                startActivity(intent);
            }
        });


        return v;
    }
}