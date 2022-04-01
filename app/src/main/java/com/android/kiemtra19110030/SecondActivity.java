package com.android.kiemtra19110030;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {



    private Button btnChupHinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        ArrayList<String> listResult = intent.getStringArrayListExtra("RESULT");

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,### đ" , symbols);
        String laiNhanDuoc = decimalFormat.format(Double.parseDouble(listResult.get(0)));
        String tongTien = decimalFormat.format(Double.parseDouble(listResult.get(1)));

        TextView txtLaiNhanDuoc = findViewById(R.id.txtLaiNhanDuoc);
        TextView txtTongTien = findViewById(R.id.txtTongTien);

        txtLaiNhanDuoc.setText(laiNhanDuoc);
        txtTongTien.setText(tongTien);
    }
    public void BtnCamera(View view) {
        btnChupHinh = findViewById(R.id.btnChupHinh);
        Intent cameraIntent= new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, 121);
        finish();
    }
}