package com.twelo.kitchen_gardenguru;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class InfoActivity extends AppCompatActivity {

    private  Toolbar toolbar;
    private String name;
    private int img;

    private ImageView item_img;
    private TextView item_name;
    private TextView item_details;

    public Menu menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (extras!=null){
            name = extras.getString("Name");
            img = extras.getInt("Img");
        }
        getSupportActionBar().setTitle(name);


        set_details();



    }


    private void set_details() {
        item_img = (ImageView)findViewById(R.id.info_img);
        item_name = (TextView)findViewById(R.id.info_name);
        item_details = (TextView)findViewById(R.id.info_details);

        item_img.setImageResource(img);
        item_name.setText(name);
        item_details.setText(new season_list().getContent().get(name.toLowerCase()));


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.menu = menu;


        SharedPreferences pref = getSharedPreferences("Data",Context.MODE_PRIVATE);

        maintain_database main_data = new maintain_database();
        main_data.getShare_pref(pref);

        ArrayList<String> list = main_data.show_data();

        if (list.contains(name)){
            this.menu.clear();
            getMenuInflater().inflate(R.menu.stared_info_menu,this.menu);
        }

        else{

            getMenuInflater().inflate(R.menu.info_menu,menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.not_fav_item){
            this.menu.clear();
            getMenuInflater().inflate(R.menu.stared_info_menu,this.menu);
            Toast.makeText(this, name+" is added in favorite list", Toast.LENGTH_SHORT).show();

           SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

            maintain_database datab = new maintain_database();
            datab.getShare_pref(sharedPreferences);
            datab.add_data(name);
        }

        if (id==R.id.fav_item){
            this.menu.clear();
            getMenuInflater().inflate(R.menu.info_menu,this.menu);
            Toast.makeText(this, name+" is removed from favorite list", Toast.LENGTH_SHORT).show();

            SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

            maintain_database data = new maintain_database();
            data.getShare_pref(sharedPreferences);
            data.delete_data(name);

        }

        return super.onOptionsItemSelected(item);
    }


}
