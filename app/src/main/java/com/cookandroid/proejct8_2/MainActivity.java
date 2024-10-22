package com.cookandroid.proejct8_2;

import android.Manifest;
import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import java.io.File;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    myPictureView myPicture;


    File[] imageFiles = new File[0];
    int currentNum = 0;
    String imageName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MODE_PRIVATE);

        myPictureView myPicture = findViewById(R.id.myPictureView1);
        File[] allFiles = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Pictures").listFiles();
        for( int i=0;i<allFiles.length;i++){
            if(allFiles[i].isFile()){
                imageFiles= Arrays.copyOf(imageFiles, imageFiles.length+1);
                imageFiles[imageFiles.length-1] = allFiles[i];
            }
        }
        imageName=imageFiles[currentNum].toString();
        myPicture.imagePath = imageName;
    }
}
