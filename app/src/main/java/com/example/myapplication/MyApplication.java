package com.example.myapplication;

import android.app.Application;

public class MyApplication extends Application {
   private String[] testValues; // ответы из ТЕстАктиви answers

   public String[] getTestValues(){
       return testValues;
   }    // для взятия данных из testValues
   public void setTestValues(String[] instance){
       this.testValues=instance;
   }    // для изменения testValues


}
