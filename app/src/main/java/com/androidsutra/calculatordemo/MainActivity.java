package com.androidsutra.calculatordemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean mAdd,mSub,mDiv,mMultiply;
    TextView txtValue,txtSum;
    ImageView imgOperator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtValue=findViewById(R.id.txtValue);
        txtSum=findViewById(R.id.txtSum);
        imgOperator=findViewById(R.id.imgOperator);

    }

    public void onClickOne(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "1"));
    }
    public void onClickTwo(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "2"));
    }
    public void onClickThree(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "3"));
    }
    public void onClickFour(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "4"));
    }
    public void onClickFive(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "5"));
    }
    public void onClickSix(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "6"));
    }
    public void onClickSeven(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "7"));
    }
    public void onClickEight(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "8"));
    }
    public void onClickNine(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "9"));
    }
    public void onClickZero(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "0"));
    }

    public void onClickZeroZero(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "00"));
    }

    public void onClickPoint(View v){
        txtValue.setText(String.format("%s%s", txtValue.getText().toString(), "."));
    }

    public void onClickClear(View v){
        //When we Clear we need to make both text tobe empty and operators image to be clear
        txtValue.setText("");
        txtSum.setText("");
        imgOperator.setImageResource(0);
    }

    //Only Division is Selected all other operators should be false
    public void onClickDiv(View v){
        mAdd=false;
        mDiv=true;
        mMultiply=false;
        mSub=false;
        if(!txtValue.getText().toString().isEmpty()) {
            txtSum.setText(txtValue.getText().toString());
        }
        if(!txtSum.getText().toString().isEmpty()) {
            imgOperator.setImageResource(R.drawable.ic_division);
        }else{
            imgOperator.setImageResource(0);
        }
        txtValue.setText("");
    }

    //Only Add is Selected all other operators should be false
    public void onClickAdd(View v){
        mAdd=true;
        mDiv=false;
        mMultiply=false;
        mSub=false;
        if(!txtValue.getText().toString().isEmpty()) {
            txtSum.setText(txtValue.getText().toString());
        }
        if(!txtSum.getText().toString().isEmpty()) {
            imgOperator.setImageResource(R.drawable.ic_add);
        }else{
            imgOperator.setImageResource(0);
        }
        txtValue.setText("");
    }

    //Only Multi is Selected all other operators should be false
    public void onClickMulti(View v){
        mAdd=false;
        mDiv=false;
        mMultiply=true;
        mSub=false;
        if(!txtValue.getText().toString().isEmpty()) {
            txtSum.setText(txtValue.getText().toString());
        }
        if(!txtSum.getText().toString().isEmpty()) {
            imgOperator.setImageResource(R.drawable.ic_multiply);
        }else{
            imgOperator.setImageResource(0);
        }
        txtValue.setText("");
    }

    //Only Sub is Selected all other operators should be false
    public void onClickSub(View v){
        mAdd=false;
        mDiv=false;
        mMultiply=false;
        mSub=true;
        if(!txtValue.getText().toString().isEmpty()) {
            txtSum.setText(txtValue.getText().toString());
        }
        if(!txtSum.getText().toString().isEmpty()) {
            imgOperator.setImageResource(R.drawable.ic_minus);
        }else{
            imgOperator.setImageResource(0);
        }
        txtValue.setText("");
    }

    //clear Last digit
    public void onClickBackSpace(View v){
        String newTxtValue;

        /*
            Suppose value is 123456
            total there is 6 length
            index will start at 0
            When substringed it will be from 0 to (6-1)
            5 length
            new number will be 12345
        */
        if(txtValue.getText().toString().length()>0) {
            newTxtValue = txtValue.getText().toString().substring(0, txtValue.getText().toString().length() - 1);
        }else{
            newTxtValue="";
        }
        txtValue.setText(newTxtValue);
    }

    public void onClickEqual(View v) {
        imgOperator.setImageResource(0);
        //if sum is fill and value is empty and pressing equals again and again operator
        // should not be gone
        if(!txtSum.getText().toString().isEmpty() && txtValue.getText().toString().isEmpty()){
            if (mAdd) {
                imgOperator.setImageResource(R.drawable.ic_add);
            } else if (mSub) {
                imgOperator.setImageResource(R.drawable.ic_minus);
            } else if (mMultiply) {
                imgOperator.setImageResource(R.drawable.ic_multiply);
            } else if (mDiv) {
                imgOperator.setImageResource(R.drawable.ic_division);
            }
        }else if(!txtSum.getText().toString().isEmpty() && !txtValue.getText().toString().isEmpty()) {
            if (mAdd) {
                double add = Double.valueOf(txtSum.getText().toString()) + Double.valueOf(txtValue.getText().toString());
                txtSum.setText(Utility.fmt(add));
                txtValue.setText("");
            } else if (mSub) {
                double sub = Double.valueOf(txtSum.getText().toString()) - Double.valueOf(txtValue.getText().toString());
                txtSum.setText(Utility.fmt(sub));
                txtValue.setText("");
            } else if (mMultiply) {
                double multiply = Double.valueOf(txtSum.getText().toString()) * Double.valueOf(txtValue.getText().toString());
                txtSum.setText(Utility.fmt(multiply));
                txtValue.setText("");
            } else if (mDiv) {
                double div = Double.valueOf(txtSum.getText().toString()) / Double.valueOf(txtValue.getText().toString());
                txtSum.setText(Utility.fmt(div));
                txtValue.setText("");
            }
            mAdd=false;
            mDiv=false;
            mSub=false;
            mMultiply=false;
        }


    }
}
