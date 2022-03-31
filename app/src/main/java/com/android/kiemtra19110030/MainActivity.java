package com.android.kiemtra19110030;

import static android.content.ContentValues.TAG;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG =
            MainActivity.class.getSimpleName();
    private EditText tienGui;
    private EditText laiSuat;
    private EditText kyHan;
    private List<String> RESULT = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Log.d(LOG_TAG, "onCreate");
        tienGui= findViewById(R.id.tbSoTienGui);
        laiSuat= findViewById(R.id.tbLaiSuat);
        kyHan= findViewById(R.id.tbKyHan);
    }


    public void launchSecondActivity(View view) {
        computing();
        Intent intent = new Intent(this, SecondActivity.class);
//        Log.d(LOG_TAG, "launchSecondActivity");
        intent.putStringArrayListExtra("RESULT", (ArrayList<String>) RESULT);

        startActivity(intent);
    }

    private void computing(){
        double tienGuiTinh,laiSuatTinh, kyHanTinh;

        try {
            tienGuiTinh = Double.parseDouble(String.valueOf(tienGui));
            laiSuatTinh = Double.parseDouble(String.valueOf(laiSuat));
            kyHanTinh = Double.parseDouble(String.valueOf(kyHan));
        } catch (NumberFormatException e) {
            Log.e(TAG, "NumberFormatException", e);
            RESULT.add("Error");
            RESULT.add("Error");
            return;
        }
        double tienLaiNhanDuoc=0, tongTien=0;
        tienLaiNhanDuoc=tienGuiTinh*(laiSuatTinh/100)*(kyHanTinh*30)/360;
        tongTien=tienGuiTinh+tienLaiNhanDuoc;
        RESULT.add(String.valueOf(tienLaiNhanDuoc));
        RESULT.add(String.valueOf(tongTien));
    }
}