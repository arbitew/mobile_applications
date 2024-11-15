package com.example.lab_8;


import android.app.AlertDialog;
import android.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.MenuItem;

import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.widget.ImageView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class Shop_activity extends AppCompatActivity {



    String[] Iphones =  {"iPhone 12","iPhone 12 Pro"
        ,"iPhone 12 Pro Max"
        ,"iPhone 13"
        ,"iPhone 13 Pro"
        ,"iPhone 13 Pro Max"
        ,"iPhone 14"
        ,"iPhone 14 Pro"};
    String[] countries = { "Бразилия", "Аргентина", "Колумбия", "Чили", "Уругвай"};
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public static class homeFrag extends homePageFragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_home_page, container, false);

            // Найдите кнопку в макете
            ImageView button = view.findViewById(R.id.test1);

            // Установите слушатель на кнопку
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Выполните действие при нажатии на кнопку
                    Toast.makeText(getActivity(), "Button Clicked", Toast.LENGTH_SHORT).show();
                }
            });

            return view;
        }
    }

    public static class adFr extends adressesFragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_adresses, container, false);


            return view;
        }
    }
    public static class appleFrag extends appleFragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_apple, container, false);
            ListView appleList = view.findViewById(R.id.appleList);

            String[] countries = { "Гренни Смит", "Гренни Смит большое", "Семеренко", "Чёрный принц", "Гала", "Гольден", "Фуджи", "Хоней Крисп"};
            // создаем адаптер
            ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, countries);

            appleList.setAdapter(adapter);
            appleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent prod_info = new Intent(getActivity(), the_product_activity.class);
                    String selectedItem = (String) parent.getItemAtPosition(position);
                    prod_info.putExtra("prodName", selectedItem);
                    startActivity(prod_info);
                    //Toast.makeText(getActivity(), "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }
    public static class notAppleFrag extends notAppleFragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_not_apple, container, false);
            ListView appleList = view.findViewById(R.id.notAppleList);

            String[] Iphones =  {"iPhone 12","iPhone 12 Pro"
                    ,"iPhone 12 Pro Max"
                    ,"iPhone 13"
                    ,"iPhone 13 Pro"
                    ,"iPhone 13 Pro Max"
                    ,"iPhone 14"
                    ,"iPhone 14 Pro"};
            // создаем адаптер
            ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, Iphones);

            appleList.setAdapter(adapter);
            appleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent prod_info = new Intent(getActivity(), the_product_activity.class);
                    String selectedItem = (String) parent.getItemAtPosition(position);
                    prod_info.putExtra("prodName", selectedItem);
                    startActivity(prod_info);
                    //Toast.makeText(getActivity(), "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
                }
            });
            return view;
        }
    }

    homeFrag homePFrag = new homeFrag();
    adFr adFrag = new adFr();
    appleFrag appleF = new appleFrag();
    notAppleFrag notAppleF = new notAppleFrag();
    FragmentTransaction fTrans;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_shop);

        drawerLayout = findViewById(R.id.my_drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        NavigationView navigationView = findViewById(R.id.my_nav);
        navigationView.setNavigationItemSelectedListener(item -> {
             String title = item.getTitle().toString();
            if (title.equals("Home")) {
                fTrans = getFragmentManager().beginTransaction();
                fTrans.replace(R.id.your_placeholder, homePFrag);
                fTrans.addToBackStack(null);
                fTrans.commit();
            } else if (title.equals("Apple")) {

                fTrans = getFragmentManager().beginTransaction();
                fTrans.replace(R.id.your_placeholder, appleF);
                fTrans.addToBackStack(null);
                fTrans.commit();
            } else if (title.equals("Not apple")) {

                fTrans = getFragmentManager().beginTransaction();
                fTrans.replace(R.id.your_placeholder, notAppleF);
                fTrans.addToBackStack(null);
                fTrans.commit();
            }else if (title.equals("Adresses")) {
//                AlertDialog.Builder builder = new AlertDialog.Builder(Shop_activity.this);
//                builder.setMessage("Do you want to exit ?" + title);
//                builder.setTitle("Alert !");
//                AlertDialog alertDialog = builder.create();
//                alertDialog.show();
                fTrans = getFragmentManager().beginTransaction();
                fTrans.replace(R.id.your_placeholder, adFrag);
                fTrans.addToBackStack(null);
                fTrans.commit();
            }

            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
        EdgeToEdge.enable(this);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.my_drawer_layout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void goTest(View view){
        startActivity(new Intent(this, MainActivity.class));
    }

}