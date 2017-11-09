package com.jcmano.datawriting;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main2Activity extends AppCompatActivity {

    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvDisplay = (TextView) findViewById(R.id.tvDisplay);
    }

    public void loadInternalCache(View views){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(new File(getCacheDir(),"data1.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvDisplay.setText(buffer.toString());
    }

    public void loadExternalCache(View view){
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream(new File(getExternalCacheDir(),"data2.txt"));
            while((read = fis.read()) != -1){
                buffer.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvDisplay.setText(buffer.toString());
    }

   public void loadExternalStorage(View view){
       StringBuffer buffer = new StringBuffer();
       int read = 0;
       FileInputStream fis = null;
       try{
           fis = new FileInputStream(new File(getExternalFilesDir("temp"),"data3.txt"));
           while((read = fis.read()) != -1){
               buffer.append((char)read);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       tvDisplay.setText(buffer.toString());
   }

   public void loadExternalPublicStorage(View view){
       StringBuffer buffer = new StringBuffer();
       int read = 0;
       FileInputStream fis = null;
       try{
           fis = new FileInputStream(new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),"data4.txt"));
           while((read = fis.read()) != -1){
               buffer.append((char)read);
           }
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }
       tvDisplay.setText(buffer.toString());
   }

    public void backPage(View view){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
