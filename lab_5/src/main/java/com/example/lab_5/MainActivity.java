package com.example.lab_5;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.app.AlertDialog;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RadioButton;
import android.widget.CheckBox;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    public class Test {
//        boolean t1_rad_apple;
//        boolean t1_rad_not;
//        boolean t2_rad_apple;
//        boolean t2_rad_not;
//        boolean t3_rad_apple;
//        boolean t3_rad_not;
        boolean[] tests;
        String[] test_ans;
        Test(boolean [] tests, String[] test_ans) {
            this.tests = tests;
            this.test_ans = test_ans;
        }
        void boolSetter(boolean[] tests){
            this.tests = tests;
        }
        void strSetter(String[] test_ans){
            this.test_ans = test_ans;
        }
    }
    Test myTest = new Test(new boolean[]{false, false, false, false, false, false}, new String[]{"false", "false", "false", "false"});
    String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            a = savedInstanceState.getString("key");
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("Do you want to exit ?" + a);
            builder.setTitle("Alert !");
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            myTest.tests = savedInstanceState.getBooleanArray("testData");
            myTest.test_ans = savedInstanceState.getStringArray("checkTest");

        }


        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        EditText test = (EditText) findViewById(R.id.bestFruit);
        savedInstanceState.putString("key", String.valueOf(test.getText()));
        RadioButton t1A = (RadioButton) findViewById(R.id.radApple);
        RadioButton t1NA = (RadioButton) findViewById(R.id.radNotApple);
        CheckBox t2A = (CheckBox) findViewById(R.id.chApple);
        CheckBox t2NA = (CheckBox) findViewById(R.id.chNotApple);
        RadioButton t3A = (RadioButton) findViewById(R.id.ImApple);
        RadioButton t3NA = (RadioButton) findViewById(R.id.ImNotApple);
        TextView test1 = (TextView) findViewById(R.id.test1);
        TextView test2 = (TextView) findViewById(R.id.test2);
        TextView test3 = (TextView) findViewById(R.id.test3);
        TextView test_Text = (TextView) findViewById(R.id.testText);
        String [] test_all ={test1.getText().toString(), test2.getText().toString(), test3.getText().toString(), test_Text.getText().toString()};
        myTest.test_ans = test_all;
        savedInstanceState.putStringArray("checkTest", myTest.test_ans);
        boolean [] thistest = {
                t1A.isActivated(),
                t1NA.isActivated(),
                t2A.isActivated(),
                t2NA.isActivated(),
                t3A.isActivated(),
                t3NA.isActivated()};
        myTest.tests = thistest;
        savedInstanceState.putBooleanArray("testData", myTest.tests);

    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onStart() {
        super.onStart();

        EditText test = (EditText) findViewById(R.id.bestFruit);
        test.setText(a);

        TextView test_text = (TextView) findViewById(R.id.testText);
        test_text.setText(myTest.test_ans[3]);
        //test_text.setText(myTest.test_ans[3]);
        RadioButton t1A = (RadioButton) findViewById(R.id.radApple);
        RadioButton t1NA = (RadioButton) findViewById(R.id.radNotApple);
        TextView test1 = (TextView) findViewById(R.id.test1);
        t1A.setChecked(myTest.tests[0]);
        t1NA.setChecked(myTest.tests[1]);


        test1.setText(myTest.test_ans[0]);

        CheckBox t2A = (CheckBox) findViewById(R.id.chApple);
        CheckBox t2NA = (CheckBox) findViewById(R.id.chNotApple);
        t2A.setActivated(myTest.tests[2]);
        t2NA.setActivated(myTest.tests[3]);

        TextView test2 = (TextView) findViewById(R.id.test2);

        test2.setText(myTest.test_ans[1]);
        RadioButton t3A = (RadioButton) findViewById(R.id.ImApple);
        RadioButton t3NA = (RadioButton) findViewById(R.id.ImNotApple);
        t3A.setActivated(myTest.tests[4]);
        t3NA.setActivated(myTest.tests[5]);
        TextView test3 = (TextView) findViewById(R.id.test3);

        test3.setText(myTest.test_ans[2]);

    }
    public void test1Change(View view){
        RadioButton t1A = (RadioButton) findViewById(R.id.radApple);
        RadioButton t1NA = (RadioButton) findViewById(R.id.radNotApple);
        TextView test1 = (TextView) findViewById(R.id.test1);
        if(t1A.isChecked()){
            test1.setText("true");
        }
        else {
            test1.setText("false");

        }
    }
    public void test2Change(View view){
        CheckBox t2A = (CheckBox) findViewById(R.id.chApple);
        CheckBox t2NA = (CheckBox) findViewById(R.id.chNotApple);
        TextView test2 = (TextView) findViewById(R.id.test2);
        if(t2A.isChecked()&& !t2NA.isChecked()){
            test2.setText("true");
        }
        else {
            test2.setText("false");

        }
    }
    public void testTextChanged(View view){
        EditText isBestFruit = (EditText) findViewById(R.id.bestFruit);
        TextView testText = (TextView) findViewById(R.id.testText);
        if(String.valueOf(isBestFruit.getText()).equals("Granny Smith")){
            testText.setText("true");
        }
        else {
            testText.setText("false");

        }
    }
    public void test3Change(View view){
        RadioButton t3A = (RadioButton) findViewById(R.id.ImApple);
        RadioButton t3NA = (RadioButton) findViewById(R.id.ImNotApple);
        TextView test1 = (TextView) findViewById(R.id.test3);
        if(t3A.isChecked()){
            test1.setText("true");
        }
        else {
            test1.setText("false");

        }
    }
    public void toCheck(View view){
        Intent check_my_res = new Intent(this, right_question_activity.class);
        TextView q1 = (TextView) findViewById(R.id.test1);
        TextView q2 = (TextView) findViewById(R.id.test2);
        TextView q3 = (TextView) findViewById(R.id.test3);
        TextView q_text = (TextView) findViewById(R.id.testText);
        String[] results = new String[] {
                q1.getText().toString(),
                q_text.getText().toString(),
                q2.getText().toString(),
                q3.getText().toString()};
        check_my_res.putExtra("answers", results);

        startActivity(check_my_res);
    }
}