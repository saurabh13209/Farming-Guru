package com.twelo.kitchen_gardenguru;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.NavUtils;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.ls.LSInput;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {
    private  Toolbar toolbar;
    private Button src_btn;
    private EditText src_edit_text;
    private ListView search_list;

    public ArrayList<String> main_list;
    private ArrayList<Integer> img_list = new ArrayList<Integer>();

    private ArrayList<String> test_array = new ArrayList<String>();
    private ArrayList<Integer> img_test = new ArrayList<Integer>();

    private ArrayList<String> data_got=new ArrayList<>();

    private CustomAdapter custom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        toolbar = (Toolbar)findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        main_list = merge(new season_list().getJan_name(),new season_list().getFeb_name(),new season_list().getMar_name(),new season_list().getApr_name(),new season_list().getMay_name(),new season_list().getJun_name(),new season_list().getJul_name(),new season_list().getAug_name(),new season_list().getSep_name(),new season_list().getNov_name(),new season_list().getDec_name());
        img_list = img_merge(new season_list().getJan_img(),new season_list().getFeb_img(),new season_list().getMar_img(),new season_list().getApr_img(),new season_list().getMay_img(),new season_list().getJun_img(),new season_list().getJul_img(),new season_list().getAug_img(),new season_list().getSep_img(),new season_list().getOct_img(),new season_list().getNov_img(),new season_list().getDec_img());
        search_list = (ListView)findViewById(R.id.search_list);


        main_widget();
        
    }



    public class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return test_array.size();
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

            TextView text = (TextView)convertView.findViewById(R.id.fruit);
            ImageView img = (ImageView)convertView.findViewById(R.id.fruit_img);

            text.setText(test_array.get(position));
            img.setImageResource(img_test.get(position));
            return convertView;
        }
    }

    public ArrayList<Integer> img_merge(int[]... a){

        ArrayList<Integer> all = new ArrayList<Integer>();

        for (int[] unit:a){
            for (int ele:unit){
                all.add(ele);
            }
        }
        return all;
    }

    public ArrayList<String> merge(String[]... a){

        ArrayList<String> all = new ArrayList<String>();

        for (String[] unit:a){
            for (String ele:unit){
                all.add(ele.toLowerCase());
            }
        }
        return all;
    }

    private void main_widget() {
        src_btn = (Button)findViewById(R.id.main_src_btn);
        src_edit_text = (EditText)findViewById(R.id.main_src_edit);

         

        src_edit_text.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String got_qu = src_edit_text.getText().toString().toLowerCase();

                test_array.clear();
                img_test.clear();
                for (int i=0;i<main_list.size();i++){
                    if (main_list.get(i).startsWith(got_qu)){
                        if (!got_qu.equals("")){
                            if(!test_array.contains(main_list.get(i))){

                                    test_array.add(main_list.get(i));
                                    img_test.add(img_list.get(i));

                            }
                        }
                        else{
                            test_array.clear();
                            img_test.clear();
                        }
                    }
                }

                custom = new CustomAdapter();
                search_list.setAdapter(custom);
            }
        });

        src_btn.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
                String got_qu = src_edit_text.getText().toString().toLowerCase();

                if (!main_list.contains(got_qu)){

                    Toast.makeText(SearchActivity.this, "Search Not Found", Toast.LENGTH_SHORT).show();
                }
            }
        });
        
        search_list.setOnItemClickListener(new ListView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent info_intent = new Intent(SearchActivity.this,InfoActivity.class);
                info_intent.putExtra("Name",(test_array.get(position).substring(0,1).toUpperCase()+test_array.get(position).substring(1)));
                info_intent.putExtra("Img",img_test.get(position));
                startActivity(info_intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id==android.R.id.home){
            NavUtils.navigateUpFromSameTask(this);
        }
        if (id==R.id.Setting){
            AlertDialog.Builder alert = new AlertDialog.Builder(SearchActivity.this);

            View box = getLayoutInflater().inflate(R.layout.dialog,null);
            alert.setView(box);

            final AlertDialog builder = alert.create();
            builder.show();

            Button yes = (Button)box.findViewById(R.id.yes_box);
            Button no = (Button)box.findViewById(R.id.no_box);

            no.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences preferences = getSharedPreferences("Data", Context.MODE_PRIVATE);

                    maintain_database data = new maintain_database();
                    data.getShare_pref(preferences);
                    data_got = data.show_data();  // fav_list
                    ArrayList<String> temp = new ArrayList<String>();
                    ArrayList<Integer> img_temp = new ArrayList<Integer>();

                    for (int i=0;i<data_got.size();i++){
                        for (int k=0; k<main_list.size();k++){
                            if ((String.valueOf(main_list.get(k)).toLowerCase().equals(String.valueOf(data_got.get(i)).toLowerCase()))){
                                main_list.remove(k);
                                img_list.remove(k);
                            }
                        }
                    }
                    test_array.clear();
                    img_test.clear();
                    custom = new CustomAdapter();
                    search_list.setAdapter(custom);
                    builder.dismiss();
                    Toast.makeText(SearchActivity.this, "Now Favorite Item will be excluded from search result.", Toast.LENGTH_SHORT).show();
                }
            });

            yes.setOnClickListener(new Button.OnClickListener() {
                @Override
                public void onClick(View v) {
                    main_list = merge(new season_list().getJan_name(),new season_list().getFeb_name(),new season_list().getMar_name(),new season_list().getApr_name(),new season_list().getMay_name(),new season_list().getJun_name(),new season_list().getJul_name(),new season_list().getAug_name(),new season_list().getSep_name(),new season_list().getNov_name(),new season_list().getDec_name());
                    img_list = img_merge(new season_list().getJan_img(),new season_list().getFeb_img(),new season_list().getMar_img(),new season_list().getApr_img(),new season_list().getMay_img(),new season_list().getJun_img(),new season_list().getJul_img(),new season_list().getAug_img(),new season_list().getSep_img(),new season_list().getOct_img(),new season_list().getNov_img(),new season_list().getDec_img());

                    test_array=new ArrayList<String>();
                    img_test= new ArrayList<Integer>();
                    main_widget();
                    builder.dismiss();

                    Toast.makeText(SearchActivity.this,"Now Favorite Items will be icluded in search result",Toast.LENGTH_LONG).show();
                }
            });
        }
        return super.onOptionsItemSelected(item);
    }
}
