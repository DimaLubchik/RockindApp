package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class selectNameFoto extends AppCompatActivity {

    EditText mNameEt,mAgeEt;
    Button mSaveBtn;
    SharedPreferences sharedPreferences;
    private static final  String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME = "name";
    private static final String KEY_AGE = "age";


    private static ImageView  mImageView;
    Button mChooseButton;

    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_name_foto);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        mNameEt=findViewById(R.id.nameEt);//имя
        mAgeEt=findViewById(R.id.ageEt);//возвраст
        mImageView=findViewById(R.id.Profile_Image);//изображение
        mSaveBtn=findViewById(R.id.saveBtn);//кнопка сохранения
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        String name = sharedPreferences.getString(KEY_NAME,null);
        if (name!=null){
            Intent intent =new Intent(selectNameFoto.this, SecondWeekActivity.class);
            startActivity(intent);

        }
        mAgeEt.setInputType(InputType.TYPE_CLASS_NUMBER |
                InputType.TYPE_NUMBER_FLAG_DECIMAL |
                InputType.TYPE_NUMBER_FLAG_SIGNED);


        mSaveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mNameEt .getText().toString().equals(""))
                {
                    Toast.makeText(selectNameFoto.this,"Вы заполнили не все поля!",Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mAgeEt .getText().toString().equals(""))
                {
                    Toast.makeText(selectNameFoto.this,"Вы заполнили не все поля!",Toast.LENGTH_SHORT).show();
                    return;
                }
                else
                {
                    SharedPreferences.Editor editor= sharedPreferences.edit();
                    editor.putString(KEY_NAME,mNameEt.getText().toString());
                    editor.putString(KEY_AGE,mAgeEt.getText().toString());
                    editor.apply();
                    Intent intent =new Intent(selectNameFoto.this, TutorialActivity.class);
                    startActivity(intent);
                }

            }
        });

       /* mImageView.buildDrawingCache();
        Bitmap bitmap = mImageView.getDrawingCache();
        Intent intent = new Intent(this,SplashActivity.class);
        intent.putExtra("BitmapImage",bitmap);*/


        /*Intent i = new Intent(this, SecondWeekActivity.class);
        Bitmap bitmap = null; // your bitmap
        ByteArrayOutputStream bs = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 50, bs);
        i.putExtra("byteArray", bs.toByteArray());
        startActivity(i);*/





        mChooseButton=findViewById(R.id.choose_image_btn);
        mChooseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if (checkSelfPermission( Manifest.permission.READ_EXTERNAL_STORAGE)==PackageManager.PERMISSION_DENIED){

                        String[] permissions={Manifest.permission.READ_EXTERNAL_STORAGE};
                        requestPermissions(permissions,PERMISSION_CODE);
                    }
                    else {
                        pickImageFromGallery();
                    }
                }
                else {
                    pickImageFromGallery();
                }
            }
        });
    }

    private void pickImageFromGallery() {
        Intent intent= new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case PERMISSION_CODE:{
                if (grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    pickImageFromGallery();
                }
                else{
                    Toast.makeText(this,"Permission denied...!",Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE && data!=null) {
            System.out.println("ffsdfsdf");
            mImageView.setImageURI(data.getData());
            SharedPreferences save = getSharedPreferences("SAVE",0);
            SharedPreferences.Editor editor = save.edit();
            final Uri imgUri=data.getData();
            editor.putString("profile_image",String.valueOf(imgUri));
            editor.commit();
            System.out.println("ffsdfsdf");
            mImageView.invalidate();

        }
    }

}