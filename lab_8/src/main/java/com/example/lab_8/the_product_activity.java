package com.example.lab_8;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.File;
import java.util.Objects;

public class the_product_activity extends AppCompatActivity {
    public class Apples{
        String imgName;
        String prodName;
        String price;
        Apples(String imgName, String prodName, String price){
            this.imgName = imgName;
            this.price = price;
            this.prodName = prodName;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_the_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
        Apples[] applesArray = new Apples[8];
        applesArray[0] = new Apples("granny_smith", "Гренни Смит", "5$");
        applesArray[1] = new Apples("granny_smith_large", "Гренни Смит большое", "30$");
        applesArray[2] = new Apples("semerenko", "Семеренко", "8$");
        applesArray[3] = new Apples("black_prince", "Чёрный принц", "5$");
        applesArray[4] = new Apples("gala", "Гала", "7$");
        applesArray[5] = new Apples("golden", "Гольден", "4$");
        applesArray[6] = new Apples("fuji", "Фуджи", "6$");
        applesArray[7] = new Apples("honey_crisp", "Хоней Крисп", "9$");
        Apples[] iphoneArray = new Apples[8];
        iphoneArray[0] = new Apples("iphone_12", "iPhone 12", "799$");
        iphoneArray[1] = new Apples("iphone_12_pro", "iPhone 12 Pro", "999$");
        iphoneArray[2] = new Apples("iphone_12_pro_max", "iPhone 12 Pro Max", "1099$");
        iphoneArray[3] = new Apples("iphone_13", "iPhone 13", "799$");
        iphoneArray[4] = new Apples("iphone_13_pro", "iPhone 13 Pro", "999$");
        iphoneArray[5] = new Apples("iphone_13_pro_max", "iPhone 13 Pro Max", "1099$");
        iphoneArray[6] = new Apples("iphone_14", "iPhone 14", "799$");
        iphoneArray[7] = new Apples("iphone_14_pro", "iPhone 14 Pro", "999$");

        ImageView pr_image = (ImageView) findViewById(R.id.prodImage);
        TextView prod_name = (TextView) findViewById(R.id.prod_name);
        TextView price = (TextView) findViewById(R.id.price);
        prod_name.setText(Objects.requireNonNull(getIntent().getStringExtra("prodName")));
        if(Objects.requireNonNull(getIntent().getStringExtra("prodName")).equals("Семеренко")){
            prod_name.setText(Objects.requireNonNull(getIntent().getStringExtra("prodName")) + "123");

        }
        for (Apples apple : applesArray) {
            if (apple.prodName.equals(Objects.requireNonNull(getIntent().getStringExtra("prodName")))) {
                prod_name.setText(Objects.requireNonNull(getIntent().getStringExtra("prodName")));
                price.setText(apple.price);
                int resourceId = getResources().getIdentifier(apple.imgName, "drawable", getPackageName());
                //Bitmap image = BitmapFactory.decodeFile(  "./" + "com/example/lab_8/granny_smith.jpg");
                pr_image.setImageResource(resourceId);

                break;
                //System.out.println("Found: Image Name: " + apple.imgName + ", Product Name: " + apple.prodName + ", Price: " + apple.price);
            }
        }
        for (Apples not_apple : iphoneArray) {
            if (not_apple.prodName.equals(Objects.requireNonNull(getIntent().getStringExtra("prodName")))) {
                prod_name.setText(Objects.requireNonNull(getIntent().getStringExtra("prodName")));
                price.setText(not_apple.price);
                //File file = new File("../java");
                int resourceId = getResources().getIdentifier(not_apple.imgName, "drawable", getPackageName());
                //Bitmap image = BitmapFactory.decodeFile(  "./" + "com/example/lab_8/granny_smith.jpg");
                pr_image.setImageResource(resourceId);
                //Toast.makeText(this, String.valueOf(R.drawable.granny_smith), Toast.LENGTH_SHORT).show();

                break;
                //System.out.println("Found: Image Name: " + apple.imgName + ", Product Name: " + apple.prodName + ", Price: " + apple.price);
            }
        }
    }
}