package com.twelo.kitchen_gardenguru;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class summer_Selected extends AppCompatActivity {
    private  Toolbar toolbar;
    private ListView innerlist;

    private String[] name_list;
    private int[] img_list;

    private CustomAdapter custom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summer__selected);
        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        Intent intent = getIntent();

        Bundle extras = intent.getExtras();

        if (extras!=null){
            int clicked = extras.getInt("Clicked");

            if (clicked==1){
                name_list = new season_list().getJan_name();
                img_list = new season_list().getJan_img();
                getSupportActionBar().setTitle("January");
            }

            if (clicked==2){
                name_list = new season_list().getFeb_name();
                img_list = new season_list().getFeb_img();
                getSupportActionBar().setTitle("February");
            }

            if (clicked==3){
                name_list = new season_list().getMar_name();
                img_list = new season_list().getMar_img();
                getSupportActionBar().setTitle("March");
            }

            if (clicked==4){
                name_list = new season_list().getApr_name();
                img_list = new season_list().getApr_img();
                getSupportActionBar().setTitle("April");
            }

            if (clicked==5){
                name_list = new season_list().getMay_name();
                img_list = new season_list().getMay_img();
                getSupportActionBar().setTitle("May");
            }

            if (clicked==6){
                name_list = new season_list().getJun_name();
                img_list = new season_list().getJun_img();
                getSupportActionBar().setTitle("June");
            }

            if (clicked==7){
                name_list = new season_list().getJul_name();
                img_list = new season_list().getJul_img();
                getSupportActionBar().setTitle("July");
            }

            if (clicked==8){
                name_list = new season_list().getAug_name();
                img_list = new season_list().getAug_img();
                getSupportActionBar().setTitle("August");
            }

            if (clicked==9){
                name_list = new season_list().getSep_name();
                img_list = new season_list().getSep_img();
                getSupportActionBar().setTitle("September");
            }
            if (clicked==10){
                name_list = new season_list().getOct_name();
                img_list = new season_list().getOct_img();
                getSupportActionBar().setTitle("October");
            }

            if (clicked==11){
                name_list = new season_list().getNov_name();
                img_list = new season_list().getNov_img();
                getSupportActionBar().setTitle("November");
            }

            if (clicked==12){
                name_list = new season_list().getDec_name();
                img_list = new season_list().getDec_img();
                getSupportActionBar().setTitle("December");
            }

        }

        set_widget();
    }

    private void set_widget() {
        innerlist = (ListView)findViewById(R.id.summer_inner);
        custom = new CustomAdapter();
        innerlist.setAdapter(custom);

        innerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent info_intent = new Intent(summer_Selected.this,InfoActivity.class);
                info_intent.putExtra("Name",name_list[position].toString());
                info_intent.putExtra("Img",img_list[position]);
                startActivity(info_intent);
            }
        });


    }

    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return name_list.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.inner_each_row,null);

            TextView fruit = (TextView)convertView.findViewById(R.id.fruit);
            ImageView img = (ImageView)convertView.findViewById(R.id.fruit_img);

            fruit.setText(name_list[position]);
            img.setImageResource(img_list[position]);

            return convertView;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.month_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.mnt_src_btn){
            startActivity(new Intent(this,SearchActivity.class));
        }

        if (id==R.id.shw_fav){

            SharedPreferences preferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

            maintain_database data = new maintain_database();
            data.getShare_pref(preferences);

            ArrayList<String> got_data = data.show_data();

            ArrayList<String> temp=new ArrayList<>();
            ArrayList<Integer> temp_img = new ArrayList<>();


            for (int i=0;i<got_data.size();i++){
                for (int k=0;k<name_list.length;k++){
                    if ((String.valueOf(got_data.get(i)).equals(name_list[k]))){
                        temp.add(got_data.get(i));
                        temp_img.add(img_list[k]);
                    }
                }
            }

            String[] temp_main = new String[temp.size()];
            int[] main_img = new int[temp_img.size()];

            for (int i=0;i<temp.size();i++){
                temp_main[i]=temp.get(i);
                main_img[i] = temp_img.get(i);
            }

            if ((temp_main.length==0)||(main_img.length==0)){
                name_list=new String[0];
                img_list=new int[0];
                Toast.makeText(summer_Selected.this,R.string.no_fave_main,Toast.LENGTH_LONG).show();

            }else{
                name_list = temp_main;
                img_list = main_img;

            }
            set_widget();



        }

        if (id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        return super.onOptionsItemSelected(item);
    }
}
