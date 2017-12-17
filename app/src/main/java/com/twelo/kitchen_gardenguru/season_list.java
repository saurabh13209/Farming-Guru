package com.twelo.kitchen_gardenguru;


import android.drm.DrmStore;
import android.graphics.drawable.RippleDrawable;

import java.util.HashMap;
import java.util.Map;

public class season_list {

    String[] jan_name = {"Tomatoes","Peppers","Onions","Herbs"};
    String[] feb_name = {"Broccoli","Herbs","Lettuce","Onions","Peppers","Tomatoes","Lady finger"};
    String[] mar_name = {"Beets","Broccoli","Cabbage","Carrots","Corn","Cucumber","Herbs","Lettuce","Melons","Onions","Peas","Peppers","Spinach","Summer squash","Tomatoes","Lady finger","Bitter gourd"};
    String[] apr_name = {"Beans","Beets","Cabbage","Carrots","Corn","Cucumber","Herbs","Lettuce","Melons","Onions","Peas","Peppers","Summer squash","Tomatoes","Capsicum"};
    String[] may_name = {"Beans","Beets","Cabbage","Carrots","Corn","Cucumber","Herbs","Melons","Peppers","Summer squash","Tomatoes"};
    String[] jun_name = {"Beans","Beets","Cabbage","Carrots","Corn","Cucumber","Herbs","Melons","Peas","Summer squash"};
    String[] jul_name = {"Beans","Broccoli","Carrots","Corn","Cucumber","Kale","Bitter gourd","Lady finger"};
    String[] aug_name = {"Beans","Cucumber","Kale","Lettuce","Peas","Radish","Spinach","Cauliflower"};
    String[] sep_name = {"Blueberries","Broccoli","Garlic","Lettuce","Radish","Spinach","Cauliflower"};
    String[] oct_name = {"Blueberries","Garlic","herbs","Cauliflower"};
    String[] nov_name = {"Herbs","Sprouts","Lettuce","Radish","Spinach","Carrots"};
    String[] dec_name = {"Herbs","Lettuce","Radish","Spinach","Broccoli","Carrots"};

    int[] jan_img = {R.drawable.tomato,R.drawable.pepper,R.drawable.onion,R.drawable.herbs};
    int[] feb_img = {R.drawable.broccoli,R.drawable.herbs,R.drawable.lettuce,R.drawable.onion,R.drawable.pepper,R.drawable.tomato,R.drawable.okra};
    int[] mar_img = {R.drawable.beet,R.drawable.broccoli,R.drawable.cabbage,R.drawable.carrot,R.drawable.corn,R.drawable.cucumber,R.drawable.herbs,R.drawable.lettuce,R.drawable.water_melon,R.drawable.onion,R.drawable.peas,R.drawable.pepper,R.drawable.spinich,R.drawable.summer_squas,R.drawable.tomato,R.drawable.okra,R.drawable.bitter_gourd};
    int[] apr_img = {R.drawable.beans,R.drawable.beet,R.drawable.cabbage,R.drawable.carrot, R.drawable.corn,R.drawable.cucumber,R.drawable.herbs,R.drawable.lettuce,R.drawable.water_melon,R.drawable.onion,R.drawable.peas,R.drawable.pepper,R.drawable.summer_squas,R.drawable.tomato,R.drawable.capcicum};
    int[] may_img = {R.drawable.beans,R.drawable.beet,R.drawable.cabbage,R.drawable.carrot,R.drawable.corn,R.drawable.cucumber,R.drawable.herbs,R.drawable.water_melon,R.drawable.pepper,R.drawable.summer_squas,R.drawable.tomato};
    int[] jun_img = {R.drawable.beans,R.drawable.beet,R.drawable.cabbage,R.drawable.carrot,R.drawable.corn,R.drawable.cucumber,R.drawable.herbs,R.drawable.water_melon,R.drawable.peas,R.drawable.summer_squas};
    int[] jul_img = {R.drawable.beans,R.drawable.broccoli,R.drawable.carrot,R.drawable.corn,R.drawable.cucumber,R.drawable.kale,R.drawable.bitter_gourd,R.drawable.okra};
    int[] aug_img = {R.drawable.beans,R.drawable.cucumber,R.drawable.kale,R.drawable.lettuce, R.drawable.peas, R.drawable.radish,R.drawable.spinich,R.drawable.cauliflower};
    int[] sep_img = {R.drawable.blueberries,R.drawable.broccoli,R.drawable.garlic,R.drawable.lettuce,R.drawable.radish,R.drawable.spinich,R.drawable.cauliflower};
    int[] oct_img = {R.drawable.blueberries,R.drawable.garlic,R.drawable.herbs,R.drawable.cauliflower};
    int[] nov_img = {R.drawable.herbs,R.drawable.sprouts,R.drawable.lettuce,R.drawable.radish,R.drawable.spinich,R.drawable.carrot};
    int[] dec_img ={R.drawable.herbs, R.drawable.lettuce,R.drawable.radish,R.drawable.spinich,R.drawable.broccoli,R.drawable.carrot};

    Map<String,Integer> content = new HashMap<String,Integer>();

    public season_list(){
        content.put("tomatoes",R.string.tomatoe_details);
        content.put("peppers",R.string.peppers_details);
        content.put("onions",R.string.onion_details);
        content.put("herbs",R.string.herbs_details);
        content.put("broccoli",R.string.brocoli_details);
        content.put("beets",R.string.beets_details);
        content.put("cabbage",R.string.cabbage_details);
        content.put("carrots",R.string.carrot_details);
        content.put("corn",R.string.corn_details);
        content.put("cucumber",R.string.cucumber_details);
        content.put("lettuce",R.string.lettuce_details);
        content.put("melons",R.string.melons_details);
        content.put("peas",R.string.peas_details);
        content.put("spinach",R.string.spinach_details);
        content.put("summer squash",R.string.summer_squash_details);
        content.put("beans",R.string.beans_details);
        content.put("kale",R.string.kale_details);
        content.put("radish",R.string.radish_details);
        content.put("blueberries",R.string.blueberries_details);
        content.put("garlic",R.string.garlic_details);
        content.put("sprouts",R.string.sprouts_details);
        content.put("lady finger", R.string.okra_details);
        content.put("bitter gourd",R.string.bitter_details);
        content.put("capsicum",R.string.capsicum_details);
        content.put("cauliflower",R.string.cauliflower_details);


    }

    public Map<String, Integer> getContent() {
        return content;
    }

    public String[] getJan_name(){
        return jan_name;
    }

    public int[] getJan_img(){
        return jan_img;
    }

    public String[] getFeb_name(){
        return feb_name;
    }

    public int[] getFeb_img(){
        return feb_img;
    }

    public String[] getMar_name(){
        return mar_name;
    }

    public int[] getMar_img(){
        return mar_img;
    }

    public String[] getApr_name(){
        return apr_name;
    }

    public int[] getApr_img(){
        return apr_img;
    }

    public String[] getMay_name(){
        return may_name;
    }

    public int[] getMay_img(){
        return may_img;
    }

    public String[] getJun_name(){
        return jun_name;
    }

    public int[] getJun_img(){
        return jun_img;
    }

    public String[] getJul_name(){
        return jul_name;
    }

    public int[] getJul_img(){
        return jul_img;
    }

    public String[] getAug_name(){
        return aug_name;
    }

    public String[] getSep_name(){
        return sep_name;
    }

    public String[] getOct_name(){
        return oct_name;
    }

    public String[] getNov_name(){
        return nov_name;
    }

    public String[] getDec_name(){
        return dec_name;
    }

    public int[] getAug_img(){
        return aug_img;
    }

    public int[] getSep_img(){
        return sep_img;
    }

    public int[] getOct_img(){
        return oct_img;
    }

    public int[] getNov_img(){
        return nov_img;
    }

    public int[] getDec_img(){
        return dec_img;
    }

}
