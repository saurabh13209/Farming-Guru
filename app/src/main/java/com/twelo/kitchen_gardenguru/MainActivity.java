package com.twelo.kitchen_gardenguru;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.media.RatingCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashSet;
import java.util.Set;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ListView mainlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        set_toolbar();
        set_widget();
        set_data_saver();
    }

    private void set_data_saver() {
        SharedPreferences shared_pref = getSharedPreferences("Data", Context.MODE_PRIVATE);
        
        new maintain_database().getShare_pref(shared_pref);
    }

    private void set_widget() {
        mainlist = (ListView)findViewById(R.id.main_season);

        CustomAdapter custom = new CustomAdapter();
        mainlist.setAdapter(custom);

        mainlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(MainActivity.this,summer_Selected.class).putExtra("Clicked",position+1));

            }
        });

    }

    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return new AllList().get_img().length;
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
            convertView = getLayoutInflater().inflate(R.layout.each_row,null);

            TextView text = (TextView)convertView.findViewById(R.id.text_season);
            TextView mnt_txt = (TextView)convertView.findViewById(R.id.month_text);

            text.setText(new AllList().get_name()[position]);
            mnt_txt.setText(String.valueOf(new AllList().get_img()[position]));

            return convertView;

        }
    }



    private void set_toolbar() {
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.search_btn){
            startActivity(new Intent(this,SearchActivity.class));
        }

        if (id==R.id.about){
            startActivity(new Intent(MainActivity.this,AboutActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}
