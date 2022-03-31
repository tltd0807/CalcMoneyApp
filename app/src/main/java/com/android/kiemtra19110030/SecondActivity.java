package com.android.kiemtra19110030;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();

        ArrayList<String> listResult = intent.getStringArrayListExtra("EXTRA_RESULT");

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###,### đ" , symbols);
        String result1 = decimalFormat.format(Double.parseDouble(listResult.get(0)));
        String result2 = decimalFormat.format(Double.parseDouble(listResult.get(1)));

        TextView resultTextView1 = findViewById(R.id.txtLaiNhanDuoc);
        TextView resultTextView2 = findViewById(R.id.txtTongTien);

        resultTextView1.setText(result1);
        resultTextView2.setText(result2);
    }
}