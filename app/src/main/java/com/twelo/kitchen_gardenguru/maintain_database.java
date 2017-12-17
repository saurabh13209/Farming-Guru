package com.twelo.kitchen_gardenguru;



import android.content.SharedPreferences;
import java.util.ArrayList;

public class maintain_database {
    private SharedPreferences pref;
    private String result;
    private ArrayList<String> list_of_fav;

    public void add_data(String item){
        SharedPreferences.Editor editor = this.pref.edit();

        try{

            String data = this.pref.getString("Data","");
            result = data;

        }catch (Exception e){
            result = "something went wrong";
            return;
        }

        result=result+item+",";
        //result="";
        editor.putString("Data",result);
        editor.apply();
    }


    public String get_result(){
        return result;
    }

    public void delete_data(String item){
        SharedPreferences.Editor editor = this.pref.edit();

        String data = this.pref.getString("Data","");

        ArrayList<String> list = get_list(data);

        ArrayList<String> new_list = new ArrayList<>();

        for (int i=0;i<list.size();i++){
            if (!String.valueOf(list.get(i)).equals(item)){
                new_list.add(list.get(i));
            }
        }

        String ret_data="";
        for (int i=0;i<new_list.size();i++){
            ret_data=ret_data+new_list.get(i)+",";
        }

        result =ret_data;
        editor.putString("Data",result);
        editor.apply();

    }
    public ArrayList<String> show_data(){
        String data = this.pref.getString("Data","");

        list_of_fav = get_list(data);

        return list_of_fav;
    }

    public ArrayList<String> get_list(String fake_list){
        ArrayList<String> list = new ArrayList<>();

        int start = 0;

        for (int i=0;i<fake_list.length();i++){
            if (String .valueOf(fake_list.charAt(i)).equals(",")){
                list.add(String.valueOf(fake_list.substring(start,i)));
                start=i+1;
            }
        }
        return list;

    }

    public void getShare_pref(SharedPreferences shared_pref) {
        this.pref = shared_pref;
    }


}
