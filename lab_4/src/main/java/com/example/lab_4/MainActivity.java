package com.example.lab_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
public class MainActivity extends AppCompatActivity {

    int fed = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void ChangeText(View view) {
        Button btnLogIn = (Button) findViewById(R.id.tButton);
        EditText MyText = (EditText) findViewById(R.id.plain_text_input);
        TextView Cat_name = (TextView) findViewById(R.id.new_cat_name);
        Cat_name.setText(MyText.getText());
        /*timer.schedule(new TimerTask() {
            public void run() {

                Cat_name.setText("Eat");
                // Your database code here
            }
        }, 1000);*/
    }
    public void feedFun(View view){
        Button FeedBut = (Button) findViewById(R.id.feedButton);
        TextView FeedText = (TextView) findViewById(R.id.feedNum);
        fed++;
        FeedText.setText("it's fed " + Integer.toString(fed) + "times");

    }
}