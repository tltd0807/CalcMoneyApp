package com.android.kiemtra19110030;

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
    private static final String TAG = "CalculatorActivity";
    private EditText tienGui;
    private EditText laiSuat;
    private EditText kyHan;

    private  String stringTienGui;
    private  String stringLaiSuat;
    private  String stringKyHan;

    private List<String> RESULT = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle extras = getIntent().getExtras();
        if(extras != null){
            stringTienGui = extras.getString("tienGui");
            stringLaiSuat = extras.getString("laiSuat");
            stringKyHan = extras.getString("kyHan");

            tienGui.setText(stringTienGui);
            laiSuat.setText(stringLaiSuat);
            kyHan.setText(stringKyHan);
        }

        tienGui= findViewById(R.id.tbSoTienGui);
        laiSuat= findViewById(R.id.tbLaiSuat);
        kyHan= findViewById(R.id.tbKyHan);

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the current state
        String text1 = tienGui.getText().toString();
        outState.putString("tienGui", text1);

        String text2 = laiSuat.getText().toString();
        outState.putString("laiSuat", text2);

        String text3 = kyHan.getText().toString();
        outState.putString("kyHan", text3);
    }


    public void launchSecondActivity(View view) {
        computing();
        Intent intent = new Intent(this, SecondActivity.class);

        intent.putStringArrayListExtra("RESULT", (ArrayList<String>) RESULT);
        startActivity(intent);
    }

    private void computing(){
        double tienGuiTinh,laiSuatTinh, kyHanTinh;

        try {
            tienGuiTinh = getOperand(tienGui);
            laiSuatTinh = getOperand(laiSuat);
            kyHanTinh = getOperand(kyHan);
        } catch (NumberFormatException nfe) {
            Log.e(TAG, "NumberFormatException", nfe);
            RESULT.add("Error");
            RESULT.add("Error");
            return;
        }
        double tienLaiNhanDuoc, tongTien;
        tienLaiNhanDuoc=tienGuiTinh*(laiSuatTinh/100)*(kyHanTinh*30)/360;
        tongTien=tienGuiTinh+tienLaiNhanDuoc;
        RESULT.add(String.valueOf( tienLaiNhanDuoc));
        RESULT.add(String.valueOf(tongTien));
    }

    /**
     * @return the operand value entered in an EditText as double.
     */
    private static Double getOperand(EditText operandEditText) {
        String operandText = getOperandText(operandEditText);
        return Double.valueOf(operandText);
    }

    /**
     * @return the operand text which was entered in an EditText.
     */
    private static String getOperandText(EditText operandEditText) {
        return operandEditText.getText().toString();
    }
}