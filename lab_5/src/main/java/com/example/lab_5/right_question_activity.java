package com.example.lab_5;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class right_question_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_right_question);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        TextView test1 = (TextView) findViewById(R.id.test1);
        test1.setText(Objects.requireNonNull(getIntent().getStringArrayExtra("answers"))[0]);
        TextView test_text = (TextView) findViewById(R.id.testText);
        test_text.setText(Objects.requireNonNull(getIntent().getStringArrayExtra("answers"))[1]);
        TextView test2 = (TextView) findViewById(R.id.test2);
        test2.setText(Objects.requireNonNull(getIntent().getStringArrayExtra("answers"))[2]);
        TextView test3 = (TextView) findViewById(R.id.test3);
        test3.setText(Objects.requireNonNull(getIntent().getStringArrayExtra("answers"))[3]);

    }
    public void shareResults(View view){
        TextView test1 = (TextView) findViewById(R.id.test1);
        TextView test_text = (TextView) findViewById(R.id.testText);
        TextView test2 = (TextView) findViewById(R.id.test2);
        TextView test3 = (TextView) findViewById(R.id.test3);

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = test1.getText().toString() + "\n" + test_text.getText().toString() +
                "\n" + test2.getText().toString() + test3.getText().toString();
        //String shareSubject = "pivo";

        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);

        //sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        startActivity(Intent.createChooser(sharingIntent, "Share your results"));
    }
    public void toInternet(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://en.wikipedia.org/wiki/Granny_Smith"));
        startActivity(intent);
    }
}